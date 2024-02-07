package com.example.producer;

import com.example.schema.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class EmployeeProducer {

    @Autowired
    private Processor processor;

    public void produceEmployee (Integer id, String firstName, String lastName){

        Employee employee = new Employee();

        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);

        Message<Employee> message = MessageBuilder.withPayload(employee)
                .build();

        processor.output().send(message);
    }



}
