package com.construction.composite;

import java.util.ArrayList;
import java.util.List;

import com.construction.component.PersonComponent;

//It will consists of four Leaf: Architect, Engineer, Manager, Labour
public class PersonComposite implements PersonComponent{

	List<PersonComponent> architects = new ArrayList<>();
	List<PersonComponent> managers = new ArrayList<>();
	List<PersonComponent> labours = new ArrayList<>();
	List<PersonComponent> engineers = new ArrayList<>();
	
	
	public List<PersonComponent> getArchitects() {
		return architects;
	}

	public void setArchitects(List<PersonComponent> architects) {
		this.architects = architects;
	}

	public List<PersonComponent> getManagers() {
		return managers;
	}

	public void setManagers(List<PersonComponent> managers) {
		this.managers = managers;
	}

	public List<PersonComponent> getLabours() {
		return labours;
	}

	public void setLabours(List<PersonComponent> labours) {
		this.labours = labours;
	}

	public List<PersonComponent> getEngineers() {
		return engineers;
	}

	public void setEngineers(List<PersonComponent> engineers) {
		this.engineers = engineers;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	public int getAllArchitectSalary() {
		
		int totalSalarySpent = 0;
		for(PersonComponent a : architects) totalSalarySpent+= a.getSalary();
		return totalSalarySpent;
	}
	
	public int getAllEngineertSalary() {
			
			int totalSalarySpent = 0;
			for(PersonComponent a : engineers) totalSalarySpent+= a.getSalary();
			return totalSalarySpent;
		}

	public int getAllManagerSalary() {
		
		int totalSalarySpent = 0;
		for(PersonComponent a : managers) totalSalarySpent+= a.getSalary();
		return totalSalarySpent;
	}
	
	public int getAllLabourSalary() {
			
			int totalSalarySpent = 0;
			for(PersonComponent a : labours) totalSalarySpent+= a.getSalary();
			return totalSalarySpent;
		}
	
	public int getEmployeeCount() {
		return architects.size()+engineers.size()+managers.size()+labours.size();
	}
	

	@Override // to get salary of all employees
	public int getSalary() {
		// TODO Auto-generated method stub
		int totalSalarySpent = 0;
		
		for(PersonComponent a : architects) totalSalarySpent+= a.getSalary();
		for(PersonComponent m : managers) totalSalarySpent+= m.getSalary();
		for(PersonComponent e : engineers) totalSalarySpent+= e.getSalary();
		for(PersonComponent l : labours) totalSalarySpent+= l.getSalary();
		
		return totalSalarySpent;
		
	}
	
	

}
