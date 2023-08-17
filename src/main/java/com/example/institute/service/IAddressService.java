package com.example.institute.service;

import com.example.institute.dto.AddressDTO;
import com.example.institute.exception.BadRequestException;

import java.util.Set;

public interface IAddressService {

    void createAddress(AddressDTO addressDTO);
    AddressDTO getAddress(Long id) throws BadRequestException;
    void updateAddress(AddressDTO addressDTO);
    void deleteAddress(Long id);
    Set<AddressDTO> getAll();
}
