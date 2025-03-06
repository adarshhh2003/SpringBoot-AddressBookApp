package com.bridgelabz.addressbookapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressBookController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<>("Get call success", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable("id") Long id) {
        return new ResponseEntity<>("Get call success for id", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addAddress(@RequestParam Long id, @RequestParam String address) {
        return new ResponseEntity<>("Post call success", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable("id") Long id, @RequestParam String newAddress) {
        return new ResponseEntity<>("Put call success", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long id) {
        return new ResponseEntity<>("Delete call success", HttpStatus.OK);
    }
}
