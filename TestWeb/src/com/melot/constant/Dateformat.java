package com.melot.constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dateformat {

	public static void date() {

		String dateString = "Tue May 14 09:10:53 CST 2013";
		dateString = dateString.replace("Jan", "01");
		dateString = dateString.replace("Feb", "02");
		dateString = dateString.replace("Mar", "03");
		dateString = dateString.replace("Apr", "04");
		dateString = dateString.replace("May", "05");
		dateString = dateString.replace("Jun", "06");
		dateString = dateString.replace("Jul", "07");
		dateString = dateString.replace("Aug", "08");
		dateString = dateString.replace("Sep", "09");
		dateString = dateString.replace("Oct", "10");
		dateString = dateString.replace("Nov", "11");
		dateString = dateString.replace("Dec", "12");

		SimpleDateFormat sdf = new SimpleDateFormat(
				"EE MM dd HH:mm:ss 'CST' yyyy", Locale.US);
		try {
			Date date = sdf.parse(dateString);
			System.out.println(date + "date1=====>>");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SimpleDateFormat sdfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datea = sdfa.format(new Date());
		long a = 1399154085;
		System.out.println(new Date(a));
		
		// TODO
		date();
	}

}
