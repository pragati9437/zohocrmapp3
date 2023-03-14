package com.zohocrm.services;

import java.util.List;

import com.zohocrm.entites.Contact;
//import com.zohocrm.entites.Lead;

public interface ContactServiceses {
public void savecontact(Contact contact);
public List<Contact> getAllcontact();
public Contact findContactById(long id);
public void deleteOnecontact(long id);

}
