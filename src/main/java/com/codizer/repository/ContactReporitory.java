package com.codizer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codizer.entity.Contact;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactReporitory.
 */
@Repository("contactRepository")
public interface ContactReporitory extends JpaRepository<Contact, Serializable> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public abstract Contact findById(int id);
}
