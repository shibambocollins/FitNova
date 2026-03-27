package za.ac.cput.repository.impl;

import za.ac.cput.entity.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * AddressRepositoryImpl.java - Implementation of AddressRepository
 * Author: Athi Sintiya (220212317)
 * Date: March 2026
 */

public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepositoryImpl instance = null;
    private final Map<String, Address> addressMap;

    private AddressRepositoryImpl() {
        this.addressMap = new HashMap<>();
    }

    public static AddressRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AddressRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Address create(Address address) {
        if (address == null || address.getAddressId() == null) {
            return null;
        }
        addressMap.put(address.getAddressId(), address);
        return address;
    }

    @Override
    public Address read(String id) {
        if (id == null) {
            return null;
        }
        return addressMap.get(id);
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Address findById(String s) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return List.of();
    }

    @Override
    public Address update(Address address) {
        if (address == null || address.getAddressId() == null) {
            return null;
        }
        if (!addressMap.containsKey(address.getAddressId())) {
            return null;
        }
        addressMap.put(address.getAddressId(), address);
        return address;
    }

    @Override
    public boolean delete(String addressId) {
        if (addressId == null) {
            return false;
        }
        return addressMap.remove(addressId) != null;
    }

    @Override
    public List<Address> getAll() {
        return new ArrayList<>(addressMap.values());
    }

}