package com.iotapp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Alias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "Device name cannot be blank")
	private String device;
	
	@Column(nullable = false)
	@NotBlank(message = "OriginalChannel name cannot be blank")
	private String originalChannel;
	
	@Column(nullable = false)
	@NotBlank(message = "alias name cannot be blank")
	private String aliasChannel;
	
	private Double value;
	
	@CreationTimestamp
	private LocalDateTime timestamp;

	public Alias() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Alias(Long id, String device, String originalChannel, String aliasChannel, Double value,
			LocalDateTime timestamp) {
		super();
		this.id = id;
		this.device = device;
		this.originalChannel = originalChannel;
		this.aliasChannel = aliasChannel;
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
	
	

}
