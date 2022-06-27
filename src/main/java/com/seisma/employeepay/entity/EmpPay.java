package com.seisma.employeepay.entity;

/**
 * EmployeePay Model   .
 *
 *  EmployeePay model constructor and all getter setter
 */
public class EmpPay {
    private  String fromDate;
    private  String toDate;
    private  double grossIncome;
    private double incomeTax;
    private double superannuation;
    private double netIncome;

    public EmpPay(){

    }
    public EmpPay(String fromDate,String toDate, double grossIncome, double incomeTax, double superannuation, double netIncome){
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.grossIncome= grossIncome;
        this.incomeTax=incomeTax;
        this.superannuation=superannuation;
        this.netIncome=netIncome;
    }
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getSuperannuation() {
        return superannuation;
    }

    public void setSuperannuation(double superannuation) {
        this.superannuation = superannuation;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }
}
