package com.construction.composite;

import java.util.ArrayList;
import java.util.List;

import com.construction.component.RawMaterialComponent;

// It will consists of 3 Leaf: Sand, Brick, Cement.
public class RawMaterialsComposite implements RawMaterialComponent {

	List <RawMaterialComponent> cementList = new ArrayList<>();
	List <RawMaterialComponent> brickList = new ArrayList<>();
	List <RawMaterialComponent> sandList = new ArrayList<>();
	
	public List<RawMaterialComponent> getCementList() {
		return cementList;
	}

	public void setCementList(List<RawMaterialComponent> cementList) {
		this.cementList = cementList;
	}

	public List<RawMaterialComponent> getBrickList() {
		return brickList;
	}

	public void setBrickList(List<RawMaterialComponent> brickList) {
		this.brickList = brickList;
	}

	public List<RawMaterialComponent> getSandList() {
		return sandList;
	}

	public void setSandList(List<RawMaterialComponent> sandList) {
		this.sandList = sandList;
	}

	@Override // get total quantity of all raw materials
	public int getQty() {
		
		int totalQty = 0;
		
		for(RawMaterialComponent c: cementList) totalQty += c.getQty();
		for(RawMaterialComponent s: sandList) totalQty += s.getQty();
		for(RawMaterialComponent b: brickList) totalQty += b.getQty();
		
		return totalQty;
	}

	@Override // get total price of all raw materials
	public int getPrice() {
		
		int totalPrice = 0;
		
		for(RawMaterialComponent c: cementList) totalPrice += c.getQty()*c.getPrice();
		for(RawMaterialComponent s: sandList) totalPrice += s.getQty()*s.getPrice();
		for(RawMaterialComponent b: brickList) totalPrice += b.getQty()*b.getPrice();
		
		return totalPrice;
	}

	@Override // get total price of all raw materials
	public String getProvider() {
		
		String providers = "";
		for(RawMaterialComponent c: cementList) providers += c.getProvider()+"\n";
		for(RawMaterialComponent s: sandList) providers += s.getProvider()+"\n";
		for(RawMaterialComponent b: brickList) providers += b.getProvider()+"\n"; 
		
		return providers;
	}

	@Override // get arrival date of all raw materials
	public String getArrivalDate() {
		String arrivals = "";
		for(RawMaterialComponent c: cementList) arrivals += c.getName() +" "+ c.getArrivalDate()+"\n";
		for(RawMaterialComponent s: sandList) arrivals += s.getName() +" "+  s.getArrivalDate()+"\n";
		for(RawMaterialComponent b: brickList) arrivals += b.getName() +"  "+  b.getArrivalDate()+"\n"; 
		
		return arrivals;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


}
