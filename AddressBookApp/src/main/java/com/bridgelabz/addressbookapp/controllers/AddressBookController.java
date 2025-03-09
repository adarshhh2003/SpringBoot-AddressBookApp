package com.bridgelabz.addressbookapp.controllers;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.services.AddressBookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressBookController {
    @Autowired
    private AddressBookServiceImpl addressService;
    // Get all contacts
    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressService.getAllContacts());
    }

    // Create a new contact
    @PostMapping("/add")
    public ResponseEntity<AddressBook> addContact(@Valid @RequestBody AddressBookDTO contactDTO) {
        return ResponseEntity.ok(addressService.addContact(contactDTO));
    }


    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id) {
        Optional<AddressBook> contact = addressService.getContactById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @Valid @RequestBody AddressBookDTO contactDTO) {
        try {
            AddressBook updatedContact = addressService.updateContact(id, contactDTO);
            return ResponseEntity.ok(updatedContact);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        boolean isDeleted = addressService.deleteContact(id);
        if (isDeleted) {
            return ResponseEntity.ok("Contact deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Contact not found.");
        }
    }
}
