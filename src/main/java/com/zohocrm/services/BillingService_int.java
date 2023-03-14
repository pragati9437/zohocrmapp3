package com.zohocrm.services;


import java.util.List;

import com.zohocrm.entites.Billing;

public interface BillingService_int {
	public void saveonebill(Billing billing);
    public List<Billing> getAllbill();
}
