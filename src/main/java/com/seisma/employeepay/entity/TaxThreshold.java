package com.seisma.employeepay.entity;

public class TaxThreshold {
    private int min;
    private  int max;
    private int defaultTax;
    private float taxRate;

    public TaxThreshold(){}

    public TaxThreshold(int min, int max, int defaultTax, float taxRate){
        this.min=min;
        this.max=max;
        this.defaultTax= defaultTax;
        this.taxRate=taxRate;
    }
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDefaultTax() {
        return defaultTax;
    }

    public void setDefaultTax(int defaultTax) {
        this.defaultTax = defaultTax;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}
