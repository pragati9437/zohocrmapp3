package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.List;

//import java.util.List;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entites.Contact;


//import com.zohocrm.entites.Contact;

//import com.zohocrm.services.ContactService;

//import com.zohocrm.entites.Contact;
//import com.zohocrm.entites.Lead;
import com.zohocrm.services.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/listallcontact")
	public String listAllcontact(ModelMap model) {
		List<Contact> contacts = contactService.getAllcontact();
		model.addAttribute("contacts",contacts);
		return "list_contact";
	}	
	@RequestMapping("/listcontact")
	public String listcontact(@RequestParam("id")long id,Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact",contact);
		return "contact_info";
		
	}
	@RequestMapping("/deletecontact")
	public String deletecontact (@RequestParam("id")long id,Model model){
		contactService.deleteOnecontact(id);  
		List<Contact> contacts = contactService.getAllcontact();
		model.addAttribute("contacts",contacts); 
		return"list_contact";
	
		
	}
	
}

	

	

	
//
