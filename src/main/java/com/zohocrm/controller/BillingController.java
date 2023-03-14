package com.zohocrm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entites.Billing;
import com.zohocrm.entites.Contact;
import com.zohocrm.services.BillingService;
import com.zohocrm.services.ContactService;


@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/generateBill")
	public String Billingpage(@RequestParam("id") long id,Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return"generated_bill";
	}
	@RequestMapping("/savebill")
	public String SaveBill(@ModelAttribute("billing")Billing billing,Model model) {
		billingService.saveonebill(billing);
		List<Billing> bills = billingService.getAllbill();
		model.addAttribute("bills",bills);
		return"list_billing";
	}
	
	@RequestMapping("/listbill")
	public String listAllLeads(Model model) {
		List<Billing> bills = billingService.getAllbill();
		model.addAttribute("bills",bills);
		return"list_billing";
	}
}
