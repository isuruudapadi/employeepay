package com.seisma.employeepay.entity;

/**
 * Employee Model   .
 *
 *  Employee model constructor and all getter setter
 */
public class Employee {
    private  String firstName;
    private String lastName;
    private  double annualSalary;
    private int paymentMonth;
    private float superRate;


    public  Employee(){

    }
    public  Employee(String firstName,String lastName,double annualSalary,int paymentMonth, float superRate){
        this.firstName=firstName;
        this.lastName =lastName;
        this.annualSalary=annualSalary;
        this.paymentMonth =paymentMonth;
        this.superRate=superRate;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public int getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(int paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public float getSuperRate() {
        return superRate;
    }

    public void setSuperRate(float superRate) {
        this.superRate = superRate;
    }

    @Override public  String toString(){
        return  "employee:{firstName:"+this.firstName+
                ",lastName:"+this.lastName+
                ",annualSalary:" +this.annualSalary+
                ",paymentMonth:" +this.paymentMonth +
                ",superRate:" +this.superRate+
                "},";
    }
}
