package com.todotask.api.response;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.todotask.api.dto.TodoTaskDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO
{
	private Integer errorcode;

	private String errormsg;
	
	private String requesttimestamp;
	
	private List<TodoTaskDto> payload;	
	private Integer pageSize;	
	private Integer pageNumber;
	private Integer totalElements;
	
	public List<TodoTaskDto> getPayload()
	{
		return payload;
	}

	public void setPayload(List<TodoTaskDto> payload)
	{
		this.payload = payload;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}
	
	
	
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
