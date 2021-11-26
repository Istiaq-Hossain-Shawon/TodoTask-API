package com.todotask.api.response;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO
{
	private Integer errorcode;

	private String errormsg;
	
	private String requesttimestamp;
	public Integer getErrorcode()
	{
		return errorcode;
	}

	public void setErrorcode(Integer errorcode)
	{
		this.errorcode = errorcode;
	}

	public String getErrormsg()
	{
		return errormsg;
	}

	public void setErrormsg(String errormsg)
	{
		this.errormsg = errormsg;
	}
	public String getRequesttimestamp()
	{
		return requesttimestamp;
	}

	public void setRequesttimestamp(String requesttimestamp)
	{
		this.requesttimestamp = requesttimestamp;
	}

	

}
