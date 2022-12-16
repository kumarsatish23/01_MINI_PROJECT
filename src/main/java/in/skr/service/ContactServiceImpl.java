package in.skr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.skr.dao.ContactDao;
import in.skr.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDao repo;

	@Override
	public String saveContact(Contact contact) {
		contact = repo.save(contact);
		if (contact.getContactId() != null) {
			return "contact saved";
		} else {
			return "contact failed to save";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "update success";
		} else {
			return "No Record Found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "Record Deleted";
		} else {
			return "Failed Record Deletion";
		}
	}
}