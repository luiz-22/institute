package com.example.institute.service.impl;

import com.example.institute.dto.AddressDTO;
import com.example.institute.entity.Address;
import com.example.institute.exception.BadRequestException;
import com.example.institute.repository.IAddressRepository;
import com.example.institute.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createAddress(AddressDTO addressDTO) {
        Address newAddress = mapper.convertValue(addressDTO, Address.class);
        addressRepository.save(newAddress);
    }

    @Override
    public AddressDTO getAddress(Long id) throws BadRequestException {
        Optional<Address> found = addressRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, AddressDTO.class);
        else
            throw new BadRequestException("Address Not Exist");
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        Address newAddress = mapper.convertValue(addressDTO, Address.class);
        addressRepository.save(newAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Set<AddressDTO> getAll() {
        List<Address> allAddress = addressRepository.findAll();
        Set<AddressDTO> allAddressDTO = new HashSet<>();

        for (Address address: allAddress)
            allAddressDTO.add(mapper.convertValue(address, AddressDTO.class));

        return allAddressDTO;
    }
}
