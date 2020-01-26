package com.amazon.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seller") 
public class Seller extends User{
	
    public Seller(String username, String mobile_no, String email, Address home_address, Address office_address) {
		super(username, mobile_no, email, home_address, office_address);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(cascade=CascadeType.ALL) // one seller has many product
    @JoinColumn(name="SELLER_ID")
	private Collection<Product> productList = new ArrayList();
	
	@Override
	public String toString() {
		return "Seller [productList=" + productList + "]";
	}

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}
	public Seller() {}

}
