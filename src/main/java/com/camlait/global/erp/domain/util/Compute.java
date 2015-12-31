package com.camlait.global.erp.domain.util;

public class Compute {

	private double value;

	public void cummuler(double nextValue) {
		value += nextValue;
	}

	public double getValue() {
		return value;
	}

}
