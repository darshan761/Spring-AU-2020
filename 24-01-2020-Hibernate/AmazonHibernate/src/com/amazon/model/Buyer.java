package com.amazon.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="buyers") 
public class Buyer extends User{

	public Buyer(String username, String mobile_no, String email, Address home_address, Address office_address) {
		super(username, mobile_no, email, home_address, office_address);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(cascade=CascadeType.ALL) // one buyer can have many orders
    @JoinColumn(name="BUYER_ID")
	private Collection<Order> orderList = new ArrayList();

	public Collection<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}
	
	public Buyer() {}

}
