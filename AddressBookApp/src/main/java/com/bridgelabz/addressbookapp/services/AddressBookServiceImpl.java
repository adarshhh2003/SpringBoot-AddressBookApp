package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceImpl implements AddressBookService{
    @Autowired
    private AddressBookRepository addressRepository;

    // Add a new contact
    public AddressBook addContact(AddressBookDTO contactDTO) {
        AddressBook contact = new AddressBook();
        contact.setFullName(contactDTO.getFullName());
        contact.setAddress(contactDTO.getAddress());
        contact.setCity(contactDTO.getCity());
        contact.setState(contactDTO.getState());
        contact.setZip(contactDTO.getZip());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());

        return addressRepository.save(contact); // Store in MySQL
    }

    // Get all contacts
    public List<AddressBook> getAllContacts() {
        return addressRepository.findAll();
    }

    // Get contact by ID
    public Optional<AddressBook> getContactById(Long id) {
        return addressRepository.findById(id);
    }

    // Update contact by ID
    public AddressBook updateContact(Long id, AddressBookDTO contactDTO) {
        Optional<AddressBook> existingContact = addressRepository.findById(id);
        if (existingContact.isPresent()) {
            AddressBook contact = existingContact.get();
            contact.setFullName(contactDTO.getFullName());
            contact.setAddress(contactDTO.getAddress());
            contact.setCity(contactDTO.getCity());
            contact.setState(contactDTO.getState());
            contact.setZip(contactDTO.getZip());
            contact.setPhoneNumber(contactDTO.getPhoneNumber());

            return addressRepository.save(contact); // Update in MySQL
        } else {
            throw new RuntimeException("Contact not found with ID: " + id);
        }
    }

    // Delete contact by ID
    public boolean deleteContact(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true; // Successfully deleted
        }
        return false; // Contact not found
    }

}
