package com.amazon.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="orders") 
@NamedQueries({ @NamedQuery(name = "GET_ALL_ORDERS", query = "from Order") }) // query to get all orders
public class Order {
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", payment=" + payment + ", buyer=" + buyer + ", productList="
				+ productList + "]";
	}

	@Id
	@GeneratedValue()
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="PAYMENT_ID") // one order will have only one payment
	private Payment payment;
	
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	@ManyToOne
    private Buyer buyer; //one buyer can have many order 

	@ElementCollection // order has collection of products
	private Collection<Product> productList = new ArrayList();

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}
	
	public Order() {}

}
