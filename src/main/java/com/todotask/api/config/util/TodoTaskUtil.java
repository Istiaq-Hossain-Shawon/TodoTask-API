package com.todotask.api.config.util;
import java.text.DecimalFormat;
import java.util.Calendar;

import com.todotask.api.response.ResponseDTO;


public class TodoTaskUtil
{

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
