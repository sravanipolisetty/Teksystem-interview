package com.tek.interview.question.ooad.util;

import java.text.DecimalFormat;

public class Utils {
	private static DecimalFormat df = new DecimalFormat("#.##");      

	public static double rounding(double value) {
		return Double.valueOf(df.format(value));

	}

}
