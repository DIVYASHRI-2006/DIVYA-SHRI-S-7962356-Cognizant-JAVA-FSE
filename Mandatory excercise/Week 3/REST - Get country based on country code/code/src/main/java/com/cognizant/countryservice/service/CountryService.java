package com.cognizant.countryservice.service;

import com.cognizant.countryservice.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {

        List<Country> countries = new ArrayList<>();

        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States"));
        countries.add(new Country("FR", "France"));
        countries.add(new Country("JP", "Japan"));

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}