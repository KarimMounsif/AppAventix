package com.qrcodeteam.utilitaire;

import java.math.BigDecimal;

public class Numeric {
	
	 public static float arrondir(float d, int decimalPlace) {
	        BigDecimal bd = new BigDecimal(Float.toString(d));
	        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	        return bd.floatValue();
	    }
}
