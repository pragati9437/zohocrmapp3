package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entites.Contact;
import com.zohocrm.entites.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadservice;
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/viewCreatelead")
	public String viewcreateleadpage() {
		return"create_lead";
	}
		@PostMapping("/save")
		public String SaveLead(@ModelAttribute("lead")Lead lead, Model model) {
			leadservice.saveoneLead(lead);
			model.addAttribute("lead" ,lead);
			return "lead_info";
		}
		@PostMapping("/convertLead")
		public String convertLead(@RequestParam("id")long id,Model model) {
			Lead lead=leadservice.findLeadById(id);
			Contact contact = new Contact();
			contact.setFirstName(lead.getFirstName());
			contact.setLastName(lead.getLastName());
			contact.setEmail(lead.getEmail());
			contact.setMobile(lead.getMobile());
			contact.setSource(lead.getSource());
			contactService.savecontact(contact);
			leadservice.deleteLeadById(id);
			List<Contact> contacts = contactService.getAllcontact();
			model.addAttribute("contacts",contacts);
			return "list_contact";
			
		}
		@RequestMapping("/listall")
	public String listAllLeads(ModelMap model) {
			List<Lead> leads = leadservice.getAllLeads();
			model.addAttribute("leads",leads);
			return"list_lead";
	}
		@RequestMapping("/leadinfo")
		public String Leadinfo(@RequestParam("id")long id,Model model) {
			Lead lead = leadservice.findLeadById(id);
			model.addAttribute("lead",lead);
			return "lead_info";
			
		}
		@RequestMapping("/updateleads")
		public String updatecontact(@RequestParam("id")long id,Model model) {
			Lead lead = leadservice.getLeadById(id);
			model.addAttribute("lead",lead);
			return "list_lead";
		}
		
}
