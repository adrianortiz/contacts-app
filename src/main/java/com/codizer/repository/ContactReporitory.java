package com.codizer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codizer.entity.Contact;

@Repository("contactRepository")
public interface ContactReporitory extends JpaRepository<Contact, Serializable> {

	public abstract Contact findById(int id);
}
