package com.pub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormater {

	public static final String LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_FORMAT = "yyyy-MM-dd";
	public static final String YEAR_MONTH = "yyyy-MM";
	public static final String DAYS = "dd";

	private Date date = null;

	private DateFormater() {

	}

	public static DateFormater getInstance() {
		return DateFormater.getInstance(null);
	}

	public static DateFormater getInstance(String dateStr) {
		DateFormater formater = new DateFormater();
		try {
			if (dateStr == null || "".equals(dateStr)) {
				formater.date = Calendar.getInstance().getTime();
			} else if (dateStr.length() == 10) {
				SimpleDateFormat sdf = new SimpleDateFormat(SHORT_FORMAT);
				formater.date = sdf.parse(dateStr);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(LONG_FORMAT);
				formater.date = sdf.parse(dateStr);
			}
		} catch (Throwable t) {
			throw new RuntimeException("日期非法：" + dateStr);
		}

		return formater;
	}

	/**
	 * 
	 * @param millis
	 *            the milliseconds since January 1, 1970, 00:00:00 GMT.
	 * @return DateFormater
	 */
	public static DateFormater getInstance(long millis) {
		DateFormater formater = new DateFormater();
		formater.date = new Date(millis);
		return formater;
	}

	public Date getDate() {
		return date;
	}

	public DateFormater getOffset(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);

		DateFormater formater = new DateFormater();
		formater.date = calendar.getTime();

		return formater;
	}

	public DateFormater getOffsetMonth(int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);

		DateFormater formater = new DateFormater();
		formater.date = calendar.getTime();

		return formater;
	}

	public int getDaysOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public DateFormater getFirstDateOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		DateFormater formater = new DateFormater();
		formater.date = calendar.getTime();

		return formater;
	}

	public DateFormater getLastDateOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, getDaysOfMonth());

		DateFormater formater = new DateFormater();
		formater.date = calendar.getTime();

		return formater;
	}

	public int getDaysBetween(DateFormater df) {
		long differSeconds = Math.abs(this.getDate().getTime() - df.getDate().getTime()) / 1000;
		return (int) Math.ceil(differSeconds * 1.0 / (3600 * 24));
	}

	public String getBegin() {
		return format(SHORT_FORMAT + " 00:00:00");
	}

	public Date getBeginDate() {
		return DateFormater.getInstance(getBegin()).getDate();
	}

	public Date getEndDate() {
		return DateFormater.getInstance(getEnd()).getDate();
	}

	public String getEnd() {
		return format(SHORT_FORMAT + " 23:59:59");
	}

	public String getLongFormat() {
		return format(LONG_FORMAT);
	}

	public String getShortFormat() {
		return format(SHORT_FORMAT);
	}

	public String getYearMonth() {
		return format(YEAR_MONTH);
	}

	public String format(String format) {
		return new SimpleDateFormat(format).format(date);
	}

	@Override
	public String toString() {
		return this.getLongFormat();
	}

	public String getDays() {
		return format(DAYS);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int getDaysBetween(Date startDate, Date enddate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startDate = sdf.parse(sdf.format(startDate));
		enddate = sdf.parse(sdf.format(enddate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(enddate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int getDaysBetweenByStr(String startDate, String enddate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sate = sdf.parse(sdf.format(startDate));
		Date edate = sdf.parse(sdf.format(enddate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(sate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(edate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 校验某一时间是否在有效期内
	 * 
	 * @param startDate
	 *            开始时间
	 * @param unit
	 *            单位(分,小时,天)1,2,3
	 * @param subMount
	 *            差额
	 * @return
	 * @throws ParseException
	 */
	public static boolean checkTimeIn(String startDate, int unit, int subMount) {
		Long st = Long.valueOf(startDate);
		Long now = System.currentTimeMillis();
		Long sub = (long) 0;
		sub = now - st;

		if (unit == 1) {
			subMount = subMount * 1000 * 60;
		}
		if (unit == 2) {
			subMount = subMount * 1000 * 60 * 60;
		}
		if (unit == 3) {
			subMount = subMount * 1000 * 60 * 60 * 24;
		}
		if (sub > subMount) {
			return false;// 不再有效期内
		} else {
			return true;
		}

	}

	public static void main(String[] args) throws ParseException {
		// 1469157669449---11.21
		System.out.println("----------" + System.currentTimeMillis());
		System.out.println(DateFormater.checkTimeIn("1469157669449", 1, 10));
	}

}
