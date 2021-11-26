package com.todotask.api.config.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Date Utility Class used to convert Strings to Dates and Timestamps
 * 
 */
public final class DateUtil
{
	private static Log log = LogFactory.getLog(DateUtil.class);

	private static final String TIME_PATTERN = "HH:mm";

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private DateUtil()
	{
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 * @see java.text.SimpleDateFormat
	 */
	public static Date convertStringToDate(String aMask, String strDate) throws ParseException
	{
		SimpleDateFormat df;
		Date date;
		df = new SimpleDateFormat(aMask);

		if (log.isDebugEnabled())
		{
			// log.debug("converting '" + strDate + "' to date with mask '" +
			// aMask + "'");
		}

		try
		{
			date = df.parse(strDate);
		}
		catch (ParseException pe)
		{
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime)
	{
		return getDateTime(TIME_PATTERN, theTime);
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * @see java.text.SimpleDateFormat
	 */
	public static String getDateTime(String aMask, Date aDate)
	{
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null)
		{
			log.error("aDate is null!");
		}
		else
		{
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		// log.debug(returnValue);

		return (returnValue);
	}

	public static String ConvertMilliSecondsToFormattedDate(String milliSeconds, String pattern)
	{

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Long.parseLong(milliSeconds));
		return simpleDateFormat.format(calendar.getTime());
	}

	public static Date getDateOnly(Date aDate)
	{
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.setTime(aDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
