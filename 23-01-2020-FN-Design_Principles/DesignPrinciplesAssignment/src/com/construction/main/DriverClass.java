package com.construction.main;

import java.util.ArrayList;
import java.util.List;

import com.construction.component.PersonComponent;
import com.construction.component.RawMaterialComponent;
import com.construction.composite.PersonComposite;
import com.construction.composite.RawMaterialsComposite;
import com.construction.composite.SiteComposite;
import com.construction.leaf.ArchitectLeaf;
import com.construction.leaf.BrickLeaf;
import com.construction.leaf.CementLeaf;
import com.construction.leaf.EngineerLeaf;
import com.construction.leaf.LabourLeaf;
import com.construction.leaf.ManagerLeaf;
import com.construction.leaf.SandLeaf;

public class DriverClass {

		public static void main(String[] args) {
			
			// Initializing Raw Materials
			RawMaterialComponent cement1 = new CementLeaf("Ambuja Cement", 2, 500, "Ratan Cement", "22-02-2020");
			RawMaterialComponent cement2 = new CementLeaf("Bharat Cement", 3, 100, "Mittal Cement", "23-02-2020");
			
			RawMaterialComponent brick1 = new BrickLeaf("Sonata brick",200, 10, "Ratan Bricks", "12-02--2020");
			RawMaterialComponent brick2 = new BrickLeaf("Black Swan brick", 500, 15, "Mittal Bricks", "13-02-2020");
			
			RawMaterialComponent sand1 = new SandLeaf("china sand ", 4, 200, "Ratan Sand"," 18-02-2020");
			RawMaterialComponent sand2 = new SandLeaf("gravel sand", 9, 100, "Mittal sand", "19-02-2020");
			
			// Initializing Employee
			PersonComponent architect1 = new ArchitectLeaf("Steve", 85000);
			PersonComponent architect2 = new ArchitectLeaf("Robert", 80000);
			PersonComponent architect3 = new ArchitectLeaf("Thor", 75000);
			
			PersonComponent engineer1 = new EngineerLeaf("Peter P", 75000);
			PersonComponent engineer2 = new EngineerLeaf("Stephen",70000 );
			PersonComponent engineer3 = new EngineerLeaf("Nataasha", 70000);
			
			PersonComponent manager1 = new ManagerLeaf("Nick", 60000);
			PersonComponent manager2 = new ManagerLeaf("Peter Q", 55000);
			PersonComponent manager3 = new ManagerLeaf("Lang", 58000);
			
			PersonComponent labour1 = new LabourLeaf("Hulk",10000);
			PersonComponent labour2 = new LabourLeaf("Drax", 12000);
			PersonComponent labour3 = new LabourLeaf("Thanos", 8000);
			
			List<RawMaterialComponent> cementList = new ArrayList<>() {
				{
					add(cement1);
					add(cement2);
				}		
			};
			List<RawMaterialComponent> sandList = new ArrayList<>() {
				{
					add(sand1);
					add(sand2);
				}
			};
			List<RawMaterialComponent> brickList = new ArrayList<>() {
				{
					add(brick1);
					add(brick2);
				}
			};
			
			List<PersonComponent> architect_list = new ArrayList<>() {
				{
					add(architect1);
					add(architect2);
					add(architect3);
				}
			};
			
			List<PersonComponent> engineer_list = new ArrayList<>() {
				{
					add(engineer1);
					add(engineer2);
					add(engineer3);
				}		
			};
			
			List<PersonComponent> manager_list = new ArrayList<>() {
				{
					add(manager1);
					add(manager2);
					add(manager3);
				}
			};
			
			List<PersonComponent> labour_list = new ArrayList<>() {
				{
					add(labour1);
					add(labour2);
					add(labour3);
				}
			};
			
			// Adding Leaf component to respective component
			RawMaterialsComposite rawMaterial = new RawMaterialsComposite();
			rawMaterial.setCementList(cementList);
			rawMaterial.setBrickList(brickList);
			rawMaterial.setSandList(sandList);
			
			PersonComposite person = new PersonComposite();
			person.setArchitects(architect_list);
			person.setEngineers(engineer_list);
			person.setLabours(labour_list);
			person.setManagers(manager_list);
			
			// Adding All composite to Site composite
			SiteComposite site = new SiteComposite("Serenity Palace","20th Street Koramangala Bengaluru"," Lodha Constructions",rawMaterial, person );
			
			System.out.println("\nSite Name: "+site.getName());
			System.out.println("Site Address: "+ site.getAddress());
			System.out.println("By: "+site.getDevelopers());
			
			System.out.println("\nTotal Raw Material Qty: "+site.rawMaterial.getQty());
			System.out.println("\nTotal Raw Material Price: "+site.rawMaterial.getPrice());
			System.out.println("\nAll Raw Material Providers:\n"+site.rawMaterial.getProvider());
			System.out.println("\nAll Raw Material Arrival Dates:\n"+site.rawMaterial.getArrivalDate());
			
			System.out.println("All Architects Salary: "+site.person.getAllArchitectSalary());
			System.out.println("All Engineers Salary: "+site.person.getAllEngineertSalary());
			System.out.println("All Managers Salary: "+site.person.getAllManagerSalary());
			System.out.println("All Labours Salary: "+site.person.getAllLabourSalary());
			
			System.out.println("\nAll Employees Salary: "+site.person.getSalary());
			System.out.println("\nEmployee Count: "+site.person.getEmployeeCount());
			
		}
	
}
