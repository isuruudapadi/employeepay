package com.seisma.employeepay.controller;

import com.seisma.employeepay.entity.EmpPay;
import com.seisma.employeepay.entity.Employee;
import com.seisma.employeepay.service.EmployeePayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeePayController {
    /**
     * empCaculations call method calculation each employee via for loop and return the array for the API  .
     *
     * @param  <@List>Employee   Employee model send data for calculations
     */
    @PostMapping("/payCalculation")
    public  HashMap<String, EmpPay> PayCalculation(@RequestBody List<Employee> employee){
         HashMap<String, EmpPay>entities = new HashMap<String, EmpPay>();
        EmployeePayService employeePayService = new EmployeePayService();
        entities= employeePayService.empPayCalculations( employee);
        return entities;
    }

}
