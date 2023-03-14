package com.zohocrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zohocrm.entites.Lead;
import com.zohocrm.repository.LeadRepository;
@Service
public class LeadService_cls implements LeadService {
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveoneLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead>findById=leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public Lead getLeadById(long id) {
		Optional<Lead> findById  = leadRepo.findById(id);
		Lead leads = findById.get();
		return leads;
	
	}

}
