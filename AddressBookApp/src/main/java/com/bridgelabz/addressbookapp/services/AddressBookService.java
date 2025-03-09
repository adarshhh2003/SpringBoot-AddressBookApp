package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    AddressBook addContact(AddressBookDTO contactDTO);
    List<AddressBook> getAllContacts();
    Optional<AddressBook> getContactById(Long id);
    AddressBook updateContact(Long id, AddressBookDTO contactDTO);
    boolean deleteContact(Long id);
}
