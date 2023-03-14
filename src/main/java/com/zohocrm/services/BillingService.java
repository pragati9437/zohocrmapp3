package com.zohocrm.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entites.Billing;
import com.zohocrm.repository.BillingRepository;
@Service
public class BillingService implements BillingService_int {
	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveonebill(Billing billing) {
		billingRepo.save(billing);
	}

	@Override
	public List<Billing> getAllbill() {
		List<Billing> bill = billingRepo.findAll();
		return bill;
	}

	

}
