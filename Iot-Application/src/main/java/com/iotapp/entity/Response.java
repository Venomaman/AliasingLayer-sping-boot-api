package com.iotapp.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Response {
   private String aliasChannel;
   private Double calValue;
   private LocalDateTime timestamp;
   
   
public Response() {
	super();
	// TODO Auto-generated constructor stub
}





public Response(String aliasChannel, Double calValue, LocalDateTime timestamp) {
	super();
	this.aliasChannel = aliasChannel;
	this.calValue = calValue;
	this.timestamp = timestamp;
}





public String getAliasChannel() {
	return aliasChannel;
}


public void setAliasChannel(String aliasChannel) {
	this.aliasChannel = aliasChannel;
}


public Double getCalValue() {
	return calValue;
}


public void setCalValue(Double calValue) {
	this.calValue = calValue;
}





public LocalDateTime getTimestamp() {
	return timestamp;
}





public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}



   
   
	
	

}
