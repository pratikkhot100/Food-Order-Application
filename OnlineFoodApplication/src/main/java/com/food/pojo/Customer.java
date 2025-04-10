package com.food.pojo;

public class Customer {
	private Integer cusId;
	private String cname;
	private String address;
	private String email;
	private Long contactNo;
	private String password;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer cusId, String cname, String address, String email, Long contactNo, String password) {
		super();
		this.cusId = cusId;
		this.cname = cname;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
	}
	public Customer(String cname, String address, String email, Long contactNo, String password) {
		super();
		this.cname = cname;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cname=" + cname + ", address=" + address + ", email=" + email
				+ ", contactNo=" + contactNo + ", password=" + password + "]";
	}
	public Integer getCusId() {
		return cusId;
	}
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
