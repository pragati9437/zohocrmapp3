package com.zohocrm.services;

import java.util.List;


import com.zohocrm.entites.Lead;

public interface LeadService {
public void saveoneLead(Lead lead);
public Lead findLeadById(long id);
public void deleteLeadById(long id);
public List<Lead> getAllLeads();
public Lead getLeadById(long id);
}
