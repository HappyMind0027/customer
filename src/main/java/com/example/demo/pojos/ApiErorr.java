package com.example.demo.pojos;

import java.util.Date;

public class ApiErorr {

	private Integer errorCode;
	private String ErrorDesc;
	private Date date;

	public ApiErorr() {
		super();
	}

	public ApiErorr(Integer errorCode, String errorDesc, Date date) {
		super();
		this.errorCode = errorCode;
		ErrorDesc = errorDesc;
		this.date = date;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return ErrorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		ErrorDesc = errorDesc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ApiErorr [errorCode=" + errorCode + ", ErrorDesc=" + ErrorDesc + ", date=" + date + "]";
	}

}
