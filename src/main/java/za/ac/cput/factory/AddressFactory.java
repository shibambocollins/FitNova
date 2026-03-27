package za.ac.cput.factory;

import za.ac.cput.entity.Address;
import za.ac.cput.util.Helper;

/*
 * AddressFactory.java - Factory class for Address entity
 * Author: Athi Sintiya (220212317)
 * Date: March 2026
 */

public class AddressFactory {

    public static Address createAddress(String streetNumber, String streetName,
                                        String suburbName, String city,
                                        String postalCode, String province,
                                        String country) {


        if (Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName) ||
                Helper.isNullOrEmpty(suburbName) || Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(postalCode) || Helper.isNullOrEmpty(province) ||
                Helper.isNullOrEmpty(country)) {
            return null;
        }

        String addressId = Helper.generateId();

        return new Address.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburbName(suburbName)
                .setCity(city)
                .setPostalCode(postalCode)
                .setProvince(province)
                .setCountry(country)
                .build();
    }

}