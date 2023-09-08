package com.iotapp.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class AliasRequest {
	
	@Column(nullable = false)
	@NotBlank(message = "Device name cannot be blank")
	private String device;
	
	@Column(nullable = false)
	@NotBlank(message = "originalChannel name cannot be blank")
	private String originalChannel;
	
	@Column(nullable = false)
	@NotBlank(message = "alias name cannot be blank")
	private String aliasChannel;
	
	private Double newValue;
	
	public AliasRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AliasRequest(String device, String originalChannel, String aliasChannel, Double newValue) {
		super();
		this.device = device;
		this.originalChannel = originalChannel;
		this.aliasChannel = aliasChannel;
		this.newValue = newValue;
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
	public Double getNewValue() {
		return newValue;
	}
	public void setNewValue(Double newValue) {
		this.newValue = newValue;
	}
	
	

}
