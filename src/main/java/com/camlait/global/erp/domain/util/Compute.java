package com.camlait.global.erp.domain.util;

public class Compute {

	private double value;

	private boolean test;
	
	public void cummuler(double nextValue) {
		value += nextValue;
	}

	public double getValue() {
		return value;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}	
}
