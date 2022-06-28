package com.seisma.employeepay.utils;


import com.seisma.employeepay.entity.EmpPay;
import com.seisma.employeepay.entity.Employee;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;

public  class PayCalculation {
    /**
     * Pay calcualtion Static method do all  calculation for employee data  .
     *
     * @param  @Employee   Employee model send data for calculations
     */
    private static  String filePath="..\\employeepay\\data.json";
    public static EmpPay PayCalculation(Employee empData) {

        EmpPay empPay = new EmpPay();
        empPay.setGrossIncome(PayCalculation.grossIncomeCalculation(empData.getAnnualSalary()));
        empPay.setIncomeTax(PayCalculation.incomeTaxCalculation(empData.getAnnualSalary(),parseJSONFile(filePath)));
        empPay.setNetIncome(PayCalculation.netIncomeCalculation(empPay.getGrossIncome(), empPay.getIncomeTax()));
        empPay.setSuperannuation(PayCalculation.superCalculation(empPay.getGrossIncome(),empData.getSuperRate()));
        empPay.setFromDate(PayCalculation.setFromDate(empData.getPaymentMonth()));
        empPay.setToDate(PayCalculation.setToDate(empData.getPaymentMonth()));


        return empPay;
    }

    public static JSONArray parseJSONFile(String filename)  {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new JSONArray(content);
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
    private static double incomeTaxCalculation(double salary, JSONArray salaryBand) {
        double incomeTax = 0;
        double taxRate =0;
        for(int i=0;i<salaryBand.length();i++){

            if(salaryBand.getJSONObject(i).getInt("min")<salary &&  salary<salaryBand.getJSONObject(i).getInt("max")){
                /* Tax income logic base on document Refer Page 1 */
                taxRate=(salaryBand.getJSONObject(i).getInt("taxRate"));
                incomeTax=(salaryBand.getJSONObject(i).getInt("defaultTax")+ ((salary-(salaryBand.getJSONObject(i).getInt("min"))) * taxRate))/12;
            }else{
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
