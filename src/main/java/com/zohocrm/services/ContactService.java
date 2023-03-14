 package com.zohocrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entites.Contact;
//import com.zohocrm.entites.Lead;
import com.zohocrm.repository.ContactRepository;
@Service
public class ContactService implements ContactServiceses {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void savecontact(Contact contact) {
		contactRepo.save(contact);

	}

	@Override
	public List<Contact> getAllcontact() {
		List<Contact> Contact = contactRepo.findAll();
		return Contact;
	}

	@Override
	public Contact findContactById(long id) {
		Optional<Contact> findById  = contactRepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}

	@Override
	public void deleteOnecontact(long id) {
		contactRepo.deleteById(id);
		
	}

	

	

	

	

	

}
