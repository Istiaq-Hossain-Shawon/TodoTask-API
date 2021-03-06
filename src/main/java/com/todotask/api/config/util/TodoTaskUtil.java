package com.todotask.api.config.util;

import java.util.Calendar;

import com.todotask.api.response.ResponseDTO;


public class TodoTaskUtil
{

	public static Boolean checkIfNull(String... arguments)
	{
		for (int i = 0; i < arguments.length; i++)
		{
			if (arguments[i] == null || arguments[i].equals(""))
			{
				return true;
			}
		}
		return false;
	}
	public static ResponseDTO createResponseSuccess()
	{
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setErrorcode(0);
		responseDTO.setErrormsg("SUCCESS");
		responseDTO.setRequesttimestamp(
				DateUtil.getDateTime(SpringJwtConstant.GENERAL_DATE_FORMAT, Calendar.getInstance().getTime()));

		return responseDTO;
	}
	public static ResponseDTO createResponseFalied(String message)
	{
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setErrorcode(-1);
		responseDTO.setErrormsg(message);
		responseDTO.setRequesttimestamp(
				DateUtil.getDateTime(SpringJwtConstant.GENERAL_DATE_FORMAT, Calendar.getInstance().getTime()));

		return responseDTO;
	}
}
