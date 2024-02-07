package com.example.consumer;

import com.example.schema.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeConsumer {

    public void consumeEmployee (Employee employee){

    log.info("Employee consumed");

    }


}
