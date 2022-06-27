package com.seisma.employeepay.service;


import com.seisma.employeepay.entity.EmpPay;
import com.seisma.employeepay.entity.Employee;
import com.seisma.employeepay.utils.PayCalculation;

import java.util.HashMap;
import java.util.List;

public class EmployeePayService {
    /**
     * empCaculations call method calculation each employee via for loop and return the array for the API  .
     *
     * @param  @<List>Employee   Employee model send data for calculations
     */
    public  HashMap<String, EmpPay> empPayCalculations(List<Employee> employee){
        HashMap<String, EmpPay> rtObject = new  HashMap<String, EmpPay>();
        for(Employee emp:employee){

            rtObject.put(emp.toString(), PayCalculation.PayCalculation(emp));

        }

        return  rtObject;
    }
}
