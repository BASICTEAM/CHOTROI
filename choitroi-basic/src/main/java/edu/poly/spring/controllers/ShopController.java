package edu.poly.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.dtos.ShopDto;
import edu.poly.spring.helpers.UserLogin;
import edu.poly.spring.models.Shop;
import edu.poly.spring.repositories.ShopRepository;

@Controller
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	private ShopRepository shopRepository;

	@RequestMapping("/detailshop")
	public String detailShop(Model model) {

		// Check login
		if (!UserLogin.authenticated()) {
			model.addAttribute("shop", new Shop());
			model.addAttribute("message", "Please log in to access!!");
			return "users/login";
		}

		// Set user login
		Shop shop = UserLogin.USER;
		model.addAttribute("user", shop);
		model.addAttribute("shop", shop);

		return "shops/detailShop";
	}

	@PostMapping("/update")
	public String update(Model model, @Validated Shop shops) {

		// Check login
		if (!UserLogin.authenticated()) {
			model.addAttribute("shop", new Shop());
			model.addAttribute("message", "Please log in to access!!");
			return "users/login";
		}

		// Set user login
		Shop shop = UserLogin.USER;
		model.addAttribute("user", shop);

		shops.setId(shop.getId());
		shops.setPassword(shop.getPassword());

		shopRepository.save(shops);

		UserLogin.USER = shops;
		model.addAttribute("user", shop);
		model.addAttribute("message", "Đã cập nhật thành công tài khoản!");

		return "shops/detailShop";
	}

	@RequestMapping("/changepassword")
	public String changePassword(Model model, ShopDto shopDto) {

		// Check login
		if (!UserLogin.authenticated()) {
			model.addAttribute("shop", new Shop());
			model.addAttribute("message", "Please log in to access!!");
			return "users/login";
		}

		// Set user login
		Shop shop = UserLogin.USER;
		model.addAttribute("user", shop);

		shopDto.setUsername(shop.getUsername());
		model.addAttribute("shopDto", shopDto);

		return "shops/changePassword";
	}

	@PostMapping("/changepassword")
	public String updatePassword(Model model, @Validated ShopDto shopDto, BindingResult result) {

		// Check login
		if (!UserLogin.authenticated()) {
			model.addAttribute("shop", new Shop());
			model.addAttribute("message", "Please log in to access!!");
			return "users/login";
		}

		// Set user login
		Shop shop = UserLogin.USER;
		model.addAttribute("user", shop);

		if (!shop.getPassword().equals(shopDto.getOldPassword())) {
			model.addAttribute("checkValid", "Mật khẩu cũ không đúng!");
			return "shops/changePassword";
		}
		if (!shopDto.getNewPassword().equals(shopDto.getPassword())) {
			model.addAttribute("checkValid", "Mật khẩu xác nhận không đúng!");
			return "shops/changePassword";
		}

		Shop shopUpdate = new Shop();

		shopUpdate.setId(shop.getId());
		shopUpdate.setUsername(shop.getUsername());
		shopUpdate.setEmail(shop.getEmail());
		shopUpdate.setPhone(shop.getPhone());
		shopUpdate.setAddress(shop.getAddress());
		shopUpdate.setInformation(shop.getInformation());
		shopUpdate.setNameShop(shop.getNameShop());
		shopUpdate.setNumberShop(shop.getNumberShop());
		shopUpdate.setPassword(shopDto.getPassword());

		shopRepository.save(shopUpdate);

		UserLogin.USER = shopUpdate;

		model.addAttribute("message", "Đã đổi mật khẩu thành công!");

		return "shops/changePassword";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {

		// Set user login
		Shop shop = UserLogin.USER;
		model.addAttribute("user", shop);

//		Shop shopfind = shopRepository.findByUsername(name);

		List<Shop> list = shopRepository.findByUsernameLikeOrderByUsername(name);

		model.addAttribute("shops", list);

		return "shops/find";
	}
}
