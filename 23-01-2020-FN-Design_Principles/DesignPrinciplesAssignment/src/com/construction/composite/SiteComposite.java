package com.construction.composite;

import com.construction.component.SiteComponent;

// It will consist Two composite classes: RawMaterial and Person
public class SiteComposite implements SiteComponent{
	
	String name;
	String address;
	String developers;
	
	public RawMaterialsComposite rawMaterial = new RawMaterialsComposite();
	public PersonComposite person = new PersonComposite();
	

	public SiteComposite(String name, String address, String developers, RawMaterialsComposite rawMaterial,
			PersonComposite person) {
		super();
		this.name = name;
		this.address = address;
		this.developers = developers;
		this.rawMaterial = rawMaterial;
		this.person = person;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public String getDevelopers() {
		// TODO Auto-generated method stub
		return developers;
	}
	
}
