package com.seisma.employeepay.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.seisma.employeepay.entity.EmpPay;
import com.seisma.employeepay.entity.Employee;
import com.seisma.employeepay.entity.TaxThreshold;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public  class PayCalculation {
    /**
     * Pay calcualtion Static method do all  calculation for employee data  .
     *
     * @param  @Employee   Employee model send data for calculations
     */
    private static  String filePath="..\\employeepay\\data.json";
    public static EmpPay PayCalculation(Employee empData) throws IOException {
        // create EmpPay instance
        EmpPay empPay = new EmpPay();
        //Call method set gross income
        empPay.setGrossIncome(PayCalculation.grossIncomeCalculation(empData.getAnnualSalary()));
        //Call method to set income calculate income tax @param1 salary @param2 pass JSON array list  && parse json file path to read json file
        empPay.setIncomeTax(PayCalculation.incomeTaxCalculationV2(empData.getAnnualSalary(),parseJSONFileTOTTaxThreshold(filePath)));
        //Call method to set net income
        empPay.setNetIncome(PayCalculation.netIncomeCalculation(empPay.getGrossIncome(), empPay.getIncomeTax()));
        //call method to set supper
        empPay.setSuperannuation(PayCalculation.superCalculation(empPay.getGrossIncome(),empData.getSuperRate()));
        //call method to set set date format for return object
        empPay.setFromDate(PayCalculation.setFromDate(empData.getPaymentMonth()));
        empPay.setToDate(PayCalculation.setToDate(empData.getPaymentMonth()));

        return empPay;
    }

    public  static  List<TaxThreshold> parseJSONFileTOTTaxThreshold(String filename) {

        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();
        // create a array list TaxThreshold
        List<TaxThreshold> taxThreshold;

        try {
            taxThreshold = Arrays.asList(mapper.readValue(Paths.get(filename).toFile(), TaxThreshold[].class));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return taxThreshold;


    }


    // Set data Start date of the month "01 JANUARY" for the paying month
    private  static  String setFromDate(int monthVal){
        String month = Month.of(monthVal+1).name();

        return "01 "+month;
    }
    // Set data End  date of the month "31 JANUARY" for the paying month
    private  static  String setToDate(int monthVal){
        Month month = Month.of(monthVal+1);
        String monthName =Month.of(monthVal+1).name();

        int lengthOfMonth = month.length(true);
        return lengthOfMonth+" "+monthName;
    }

    //method return the round up value upto 0ne decimal point
    private static double roundUp(double inputVal) {
        return Math.ceil(inputVal);
    }

    //method calculate the gross income of the employee
    private static double grossIncomeCalculation(double salary) {
        return roundUp(salary / 12);
    }
    //method calculate the tax bandwidth according salary
    private static double incomeTaxCalculationV2(double salary, List<TaxThreshold> taxThreshold){
        double incomeTax = 0;
        for (TaxThreshold taxBand:taxThreshold) {
            if(( taxBand.getMin())< salary && salary < taxBand.getMax()){
                incomeTax =(taxBand.getDefaultTax()+((salary-taxBand.getMin())* taxBand.getTaxRate()))/12;
            }else {
                //ERROR
            }
        }
        return  roundUp(incomeTax);
    }

    // method return net income Logic(grossIncome  - income Tax)
    private static double netIncomeCalculation(double grossIncome, double incomeTax){
        return roundUp(grossIncome-incomeTax);
    }
    // method return super annuation amount Logic(grossIncome multiply by superannuation rate)
    private  static  double superCalculation(double grossIncome, double superRate){
        return roundUp(grossIncome*superRate);
    }


}
