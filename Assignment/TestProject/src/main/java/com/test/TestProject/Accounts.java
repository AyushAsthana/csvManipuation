package com.test.TestProject;

public class Accounts {

	private String transactionDate;
	private String product;
	private int price;
	private String paymentType;
	private String name;
	private String city;
	private String state;
	private String country;
	private String accountCreated;
	private String lastLogin;
	private float latitude;
	private float longitude;
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAccountCreated() {
		return accountCreated;
	}
	@Override
	public String toString() {
		return "Accounts [transactionDate=" + transactionDate + ", product=" + product + ", price=" + price
				+ ", paymentType=" + paymentType + ", name=" + name + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", accountCreated=" + accountCreated + ", lastLogin=" + lastLogin
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	public void setAccountCreated(String accountCreated) {
		this.accountCreated = accountCreated;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
}
