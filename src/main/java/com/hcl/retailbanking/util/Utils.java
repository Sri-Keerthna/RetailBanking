package com.hcl.retailbanking.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Sri Keerthna. This is a Util class for Transaction table.
 */
public class Utils {

	/**
	 * Passing month and year and converting in date format
	 * @param month
	 * @param year
	 * @return
	 */
	public static List<LocalDate> getDateFromMonthAndYear(String month, Integer year) {
		int monthInt = monthConverter(month) + 1;

		List<LocalDate> dates = new ArrayList<>();
		LocalDate date1 = LocalDate.of(year, monthInt, 01);
		int days = date1.lengthOfMonth();

		LocalDate date2 = LocalDate.of(year, monthInt, days);
		if (date2 != null) {
			dates.add(date1);
			dates.add(date2);
		}
		return dates;
	}

	/**
	 * Month is taken as string datatype and converted into integer datatype
	 * @param month
	 * @return
	 */
	public static Integer monthConverter(String month) {
		if (month.equalsIgnoreCase("January")) {
			return Calendar.JANUARY;
		}
		if (month.equalsIgnoreCase("February")) {
			return Calendar.FEBRUARY;
		}
		if (month.equalsIgnoreCase("March")) {
			return Calendar.MARCH;
		}
		if (month.equalsIgnoreCase("April")) {
			return Calendar.APRIL;
		}
		if (month.equalsIgnoreCase("May")) {
			return Calendar.MAY;
		}
		if (month.equalsIgnoreCase("June")) {
			return Calendar.JUNE;
		}
		if (month.equalsIgnoreCase("July")) {
			return Calendar.JULY;
		}
		if (month.equalsIgnoreCase("August")) {
			return Calendar.AUGUST;
		}
		if (month.equalsIgnoreCase("September")) {
			return Calendar.SEPTEMBER;
		}
		if (month.equalsIgnoreCase("October")) {
			return Calendar.OCTOBER;
		}
		if (month.equalsIgnoreCase("November")) {
			return Calendar.NOVEMBER;
		}
		if (month.equalsIgnoreCase("December")) {
			return Calendar.DECEMBER;
		}
		return 0;
	}



}
