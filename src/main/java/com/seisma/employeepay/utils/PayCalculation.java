package com.seisma.employeepay.utils;

import com.seisma.employeepay.entity.EmpPay;
import com.seisma.employeepay.entity.Employee;

import java.time.Month;

public  class PayCalculation {
    /**
     * Pay calcualtion Static method do all  calculation for employee data  .
     *
     * @param  @Employee   Employee model send data for calculations
     */
    public static EmpPay PayCalculation(Employee empData) {
        EmpPay empPay = new EmpPay();
        empPay.setGrossIncome(PayCalculation.grossIncomeCalculation(empData.getAnnualSalary()));
        empPay.setIncomeTax(PayCalculation.grossIncomeCalculation(empPay.getGrossIncome()));
        empPay.setNetIncome(PayCalculation.netIncomeCalculation(empPay.getGrossIncome(), empPay.getIncomeTax()));
        empPay.setSuperannuation(PayCalculation.superCalculation(empPay.getGrossIncome(),empData.getSuperRate()));
        empPay.setFromDate(PayCalculation.setFromDate(empData.getPaymentMonth()));
        empPay.setToDate(PayCalculation.setToDate(empData.getPaymentMonth()));
        return empPay;
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
    private double incomeTaxCalculation(double salary) {
        double incomeTax = 0;
        if (salary < 18200) {
            return incomeTax;
        } else if (18200<salary && salary < 37000) {
            return roundUp(incomeTax = ((incomeTax * 0.19) / 12));
        } else if (37000< salary && salary < 87000) {
            return roundUp(incomeTax = (incomeTax + 3572) + (((salary - 37000) * 0.325) / 12));
        } else if (87000 <salary && salary < 180000) {
            return roundUp(incomeTax = (incomeTax + 19822) + (((salary - 87000) * 0.37) / 12));
        } else if (salary > 180000) {
            return roundUp(incomeTax = (incomeTax + 54232) + (((salary - 180000) * 0.45) / 12));
        }else{
            return  incomeTax;
        }
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
