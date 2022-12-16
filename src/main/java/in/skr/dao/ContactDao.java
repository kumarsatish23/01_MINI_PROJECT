package in.skr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skr.entity.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {

}
