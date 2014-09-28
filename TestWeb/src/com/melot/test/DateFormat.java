package com.melot.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
	public static void main(String[] args) throws ParseException {
		String dateString1 = "Tue May 14 09:10:53 CST 2013";
		dateString1 = dateString1.replace("Jan", "01");
		dateString1 = dateString1.replace("Feb", "02");
		dateString1 = dateString1.replace("Mar", "03");
		dateString1 = dateString1.replace("Apr", "04");
		dateString1 = dateString1.replace("May", "05");
		dateString1 = dateString1.replace("Jun", "06");
		dateString1 = dateString1.replace("Jul", "07");
		dateString1 = dateString1.replace("Aug", "08");
		dateString1 = dateString1.replace("Sep", "09");
		dateString1 = dateString1.replace("Oct", "10");
		dateString1 = dateString1.replace("Nov", "11");
		dateString1 = dateString1.replace("Dec", "12");

		SimpleDateFormat sdf = new SimpleDateFormat(
				"EE MM dd HH:mm:ss 'CST' yyyy", Locale.US);
		Date date = sdf.parse(dateString1);
		System.out.println("----dateString2===>" +date);

		String dateString2 = "Tue Apr 15 18:23:55 CST 2014";
		String sfEnd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
						java.util.Locale.ENGLISH).parse(dateString2));
		System.out.println("sfEnd===>" + sfEnd);

		SimpleDateFormat sdfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datea = sdfa.format(new Date());
		System.out.println("localhost date to yyyy-mm-dd hh:mm:ss===>" + datea);

		System.out.println("yyyymmddhhmmss String to date===>"
				+ new Date(20130224201210l));
		// System.out.println(sfEnd);
	}

}
