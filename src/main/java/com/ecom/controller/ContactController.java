package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecom.entity.Message;
import com.ecom.service.ContactService;

import ch.qos.logback.core.model.Model;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/send/message")
	public String sendMessage(Message message, Model model) {
		contactService.createMessage(message);
		model.addAttribute("confirmation", "Your message has been successfully sent!!");
		
		return "ContactUs";
	}
}