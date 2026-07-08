package com.cognizant.countrywebservice.controller;

import com.cognizant.countrywebservice.model.country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class countrycontroller {

    @RequestMapping("/country")
    public country getcountryIndia() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        country country = (country) context.getBean("india");

        return country;
    }
}