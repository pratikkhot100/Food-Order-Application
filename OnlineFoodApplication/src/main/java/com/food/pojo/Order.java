package com.food.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
	private Integer orderId;
	private Double billingAmount;
	private LocalDate orderDate;
	private String email;
	private String dropLocation;
	private LocalDateTime deliveryDate;
	private String status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(Double billingAmount, LocalDate orderDate, String email, String dropLocation,
			LocalDateTime deliveryDate, String status) {
		super();
		this.billingAmount = billingAmount;
		this.orderDate = orderDate;
		this.email = email;
		this.dropLocation = dropLocation;
		this.deliveryDate = deliveryDate;
		this.status = status;
	}


	public Order(Integer orderId, Double billingAmount, LocalDate orderDate, String email, String dropLocation,
			LocalDateTime deliveryDate, String status) {
		super();
		this.orderId = orderId;
		this.billingAmount = billingAmount;
		this.orderDate = orderDate;
		this.email = email;
		this.dropLocation = dropLocation;
		this.deliveryDate = deliveryDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", billingAmount=" + billingAmount + ", orderDate=" + orderDate
				+ ", email=" + email + ", dropLocation=" + dropLocation + ", deliveryDate=" + deliveryDate + ", status="
				+ status + "]";
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getBillingAmount() {
		return billingAmount;
	}
	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	
	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
