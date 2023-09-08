package com.iotapp.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Request {
	
private String device;
private String originalChannel;
private String aliasChannel;
//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
private LocalDateTime timestamp;

public Request() {
	super();
	// TODO Auto-generated constructor stub
}
public Request(String device, String originalChannel, String aliasChannel, LocalDateTime timestamp) {
	super();
	this.device = device;
	this.originalChannel = originalChannel;
	this.aliasChannel = aliasChannel;
	this.timestamp = timestamp;
}
public String getDevice() {
	return device;
}
public void setDevice(String device) {
	this.device = device;
}
public String getOriginalChannel() {
	return originalChannel;
}
public void setOriginalChannel(String originalChannel) {
	this.originalChannel = originalChannel;
}
public String getAliasChannel() {
	return aliasChannel;
}
public void setAliasChannel(String aliasChannel) {
	this.aliasChannel = aliasChannel;
}
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}
@Override
public String toString() {
	return "Request [device=" + device + ", originalChannel=" + originalChannel + ", aliasChannel=" + aliasChannel
			+ ", timestamp=" + timestamp + "]";
}


	
	

}
