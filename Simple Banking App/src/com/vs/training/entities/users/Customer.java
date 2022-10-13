package com.vs.training.entities.users;

import java.util.List;

import com.vs.training.entities.identities.Identities;

public class Customer extends User {

	private String customerType;
	private boolean status;
	private List<Identities> identities;
	 // addresss
	//phone
	//email ..

	public List<Identities> getIdentities() {
		return identities;
	}

	public void setIdentities(List<Identities> identities) {
		this.identities = identities;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
