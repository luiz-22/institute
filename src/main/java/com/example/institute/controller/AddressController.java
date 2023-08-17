package com.example.institute.controller;

import com.example.institute.dto.AddressDTO;
import com.example.institute.exception.BadRequestException;
import com.example.institute.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @PostMapping
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.createAddress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AddressDTO getAddress(@PathVariable Long id) throws BadRequestException {
        return addressService.getAddress(id);
    }

    @PutMapping
    public ResponseEntity<?> updateAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<AddressDTO> getAll() {
        return addressService.getAll();
    }
}
