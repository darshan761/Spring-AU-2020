package com.construction.leaf;

import com.construction.component.PersonComponent;

public class ManagerLeaf implements PersonComponent{

	private String name;
	private int salary;
	
	public ManagerLeaf(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}

}
