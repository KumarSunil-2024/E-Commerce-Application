package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecom.entity.Admin;
import com.ecom.entity.Message;
import com.ecom.service.ProductService;


@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;

	@GetMapping({"/", "/home"})
	public String homePage() {
		return "HomePage";
	}
	
	@GetMapping("/products")
	public String productPage(Model model) {
		model.addAttribute("productList", productService.getAllProducts());
		
		return "Products";
	}

	@GetMapping("/contactUs")
	public String contactPage(Model model) {
		model.addAttribute("message", new Message());
		
		return "ContactUs";
	}

	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "AboutUs";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		return "LoginPage";
	}

}
