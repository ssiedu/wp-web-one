package com.ssi;


public class TaxBean {
	private int income;
	private int tax;
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
		process();
		
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	private void process() {
		if(income>=500000) {
			tax=income*20/100;
		}else{
			tax=income*10/100;
		}
	}
	
}
