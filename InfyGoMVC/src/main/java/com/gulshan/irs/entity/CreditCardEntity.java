package com.gulshan.irs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name="CREDITCARD_DETAILS")
public class CreditCardEntity {
	@Id
	@NotEmpty(message="Please Enter the CArd Number")
	private String cardNumber;
	
	@NotEmpty(message="Please Enter the card holder name")
	private String cardHolderName;
	
	@NotEmpty(message="Please enter the cvv")
	private String cvv;
	
	@NotEmpty(message="Please enter the pin")
	private String securePin;
	
	@NotEmpty(message="Please enter card's expiry month")
	private String expiryMonth;
	
	@NotEmpty(message="Please Enter the Card's Expiry Year")
	private String expiryYear;
	
	private String totalBill;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getSecurePin() {
		return securePin;
	}

	public void setSecurePin(String securePin) {
		this.securePin = securePin;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	
	
	
}
