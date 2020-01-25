package com.construction.leaf;

import com.construction.component.RawMaterialComponent;

public class SandLeaf implements RawMaterialComponent{

	private String name;
	private int qty;
	private int price;
	private String provider;
	private String arrivalDate;
	
	public SandLeaf() {}
	
	public SandLeaf(String name, int qty, int price, String provider, String arrivalDate) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.provider = provider;
		this.arrivalDate = arrivalDate;
	}
	
	@Override
	public int getQty() {
		// TODO Auto-generated method stub
		return qty;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return provider;
	}

	@Override
	public String getArrivalDate() {
		// TODO Auto-generated method stub
		return arrivalDate;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
