package com.example.controller;

import com.example.producer.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class employeeEndpoint {

    @Autowired
    private EmployeeProducer employeeProducer;

    @PostMapping("/employees/{id}/{firstName}/{lastName}")
    public String sendEmployee (@PathVariable Integer id,
                                @PathVariable String firstName,
                                @PathVariable String lastName){

        employeeProducer.produceEmployee(id, firstName, lastName);
        return "Employee sent";
    }



}
