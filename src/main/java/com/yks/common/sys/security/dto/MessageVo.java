package com.yks.common.sys.security.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MessageVo implements Serializable {
	private static ObjectMapper json = new ObjectMapper();
	private int status;
	private String message;
	
	public String toString(){
		try {
			return json.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public MessageVo(){}
	
	public MessageVo(int status, String message){
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
