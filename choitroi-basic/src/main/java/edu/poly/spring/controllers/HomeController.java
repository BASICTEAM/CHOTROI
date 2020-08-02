package edu.poly.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.spring.helpers.CountryVN;
import edu.poly.spring.helpers.UserLogin;
import edu.poly.spring.models.Shop;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(ModelMap model) {

		if (!UserLogin.authenticated()) {
			model.addAttribute("user", null);
			
			return "index";
		}
		
		Shop shop = UserLogin.USER;
		model.addAttribute("user", shop);

		return "index";
	}

	@RequestMapping("/logout")
	public String login(ModelMap model) {

		UserLogin.logoff();

		model.addAttribute("shop", new Shop());

		return "index";
	}
	
	@RequestMapping("/country")
	public String index(ModelMap model) {

		List<String> country = CountryVN.city();
		model.addAttribute("country", country);
		
		model.addAttribute("user", new Shop());

		return "country";
	}

}
