package com.iotapp.entity;

import java.time.LocalDateTime;

public class CustomDto {
	
	private LocalDateTime timestamp;
	private Double value;
	
	public CustomDto(LocalDateTime timestamp, Double value) {
		this.timestamp = timestamp;
		this.value = value;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	

}
