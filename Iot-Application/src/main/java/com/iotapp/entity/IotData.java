package com.iotapp.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class IotData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String device;
	
	private String channel;
	
	private Double value;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalDateTime timestamp;
	
	
	
	
	

	public IotData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IotData(Long id, String device, String channel, Double value, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.device = device;
		this.channel = channel;
		this.value = value;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		device = device;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "IotData [id=" + id + ", device=" + device + ", channel=" + channel + ", value=" + value + ", timestamp="
				+ timestamp + "]";
	}
	


}
	
	//--------------------------------------------------------------------------------------
	
//	public boolean newValue(Double value) {
//	Double values = getValue();
//	String str = getChannel();
//	if(str.contains("visiblesatellites")&& values>3) {
//		return true;
//	}
//	return false;
//
//	}
//	public Double calValue(Double value) {
//		Double val = getValue();
//		String str = getChannel();
//		if (str.contains("x-axis")||str.contains("y-axis")) {
//			Double y = getValue();
//			Double x = getValue();
//			if(y!=null && x != null) {
//				Double direction = Math.atan2(y, x);
//				return direction;
//			}	
//			
//		}
//		return val;
//				
//	}
//	
//	public String newString(String Channel) {
//		
//		String str1 = getChannel();
//		if(str1.contains("visiblesatellites")) {
//			String newstr =str1.replace("visiblesatellites","IsVisible");
//			return newstr;
//		}else if (str1.equalsIgnoreCase("x-axis")) {
//			String newstr2 = str1.replace("x-axis", "Direction");
//			return newstr2;
//		}
//			else if (str1.equalsIgnoreCase("y-axis")) {
//			String newstr3 = str1.replace("y-axis", "Direction");
//			return newstr3;
//		}
//			
//		
//		return str1;
//		
//		
//	}---------------------------------------------------------------------------------------------


