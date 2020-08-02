package edu.poly.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.spring.helpers.RandomMa;
import edu.poly.spring.helpers.UserLogin;
import edu.poly.spring.models.Shop;
import edu.poly.spring.repositories.ShopRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private JavaMailSender emailSender;

	@RequestMapping("/login")
	public String login(ModelMap model) {

		UserLogin.logoff();

		model.addAttribute("shop", new Shop());

		return "users/login";
	}

	@PostMapping("/signin")
	public String signin(ModelMap model, @Validated Shop shop, BindingResult result) {

		// Check fields
		if (result.hasErrors()) {
			model.addAttribute("message", "Please input all required fields!!");

			return "users/login";
		}

		// Check login
		String username = shop.getUsername();
		String password = shop.getPassword();

		List<Shop> list = (List<Shop>) shopRepository.findAll();

		model.addAttribute("message", "Wrong username & password!!");

		for (Shop shop2 : list) {
			if (username.equals(shop2.getUsername())) {
				if (password.equals(shop2.getPassword())) {
					Shop shop3 = shopRepository.findByUsername(username);

					// set UserLogin
					UserLogin.USER = shop3;

					model.addAttribute("user", shop3);

					return "index";
				}
				model.addAttribute("message", "Wrong password!!");
			}
		}

		return "users/login";

	}

	@RequestMapping("/forgotpassword")
	public String forgotPassword(Model model) {

		UserLogin.logoff();

		return "users/forgotPassword";
	}

	@PostMapping("/getpassword")
	public String getPassword(Model model, @RequestParam(value = "username") String username,
			@RequestParam(value = "email") String email) {

		String errorMessage = "Tài khoản không đúng. Vui lòng nhập lại!";

		List<Shop> list = (List<Shop>) shopRepository.findAll();
		for (Shop shop : list) {
			if (shop.getUsername().equals(username)) {
				if (shop.getEmail().equals(email)) {

					Shop shop2 = shopRepository.findByUsername(username);

					// Send mail
					String strEmail = shop.getEmail();

					SimpleMailMessage message = new SimpleMailMessage();
					message.setTo(strEmail);
					message.setSubject("Chợ Trời - Mật khẩu của bạn");
					message.setText("Kính chào " + shop2.getNameShop()
							+ ", chúng tôi cung cập lại mật khẩu cho bạn với tài khoản: " + shop.getUsername()
							+ ", mật khẩu: " + shop2.getPassword() + ". Cảm ơn đã sử dụng dịch vụ của chúng tôi!");
					this.emailSender.send(message);

					model.addAttribute("message", "Mật khẩu đã được gửi về email thành công!");

					return "users/forgotPassword";
				}
				errorMessage = "Email không đúng. Vui lòng nhập lại!";
			}
		}

		model.addAttribute("errorMessage", errorMessage);

		return "users/forgotPassword";
	}

	@GetMapping("/register")
	public String add(ModelMap model) {

		model.addAttribute("shop", new Shop());
		return "users/register";

	}

	@PostMapping("/signup")
	public String saveOrUpdate(ModelMap model, Shop shop) {

		shopRepository.save(shop);

		// Send mail
		String strEmail = shop.getEmail();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(strEmail);
		message.setSubject("Mã kích hoạt tài khoản");
		int numberOfCharactor = 6;
		RandomMa rand = new RandomMa();
		message.setText("Mã kích hoạt tài khoản chợ trời của bạn là : " + rand.randomAlphaNumeric(numberOfCharactor));
		this.emailSender.send(message);

		model.addAttribute(shop);
		model.addAttribute("message", "Đăng ký tài khoản thành công!");

		return "users/register";
	}

	@ResponseBody
	public void sendEmail() {
		Optional<Shop> optShop = shopRepository.findById(0);
		if (optShop.isPresent()) {

			// Send mail
			String strEmail = optShop.get().getEmail();

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(strEmail);
			message.setSubject("Mã kích hoạt tài khoản");
			int numberOfCharactor = 6;
			RandomMa rand = new RandomMa();
			message.setText(
					"Mã kích hoạt tài khoản chợ trời của bạn là : " + rand.randomAlphaNumeric(numberOfCharactor));
			this.emailSender.send(message);
		}

	}

//	public void tranIdToMail() {
//		Optional<Shop> optShop = shopService.findById(idshop);
//		if (optShop.isPresent()) {
//			MyConstants.mail = optShop.get().getEmail();
//		} else {
//		}
//	}

}
