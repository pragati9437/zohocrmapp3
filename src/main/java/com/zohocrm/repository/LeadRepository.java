 package com.zohocrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm.entites.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
