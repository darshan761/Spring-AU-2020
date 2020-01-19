package com.assignment.database;

public class Employee {
	int emp_id, project_id;
	double score;
	String name, email, project_name, project_manager, client;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_manager() {
		return project_manager;
	}
	public void setProject_manager(String project_manager) {
		this.project_manager = project_manager;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "emp_id:" + emp_id + "  project_id : " + project_id + "  score : " + score + "   name : " + name
				+ "  email : " + email + "  project_name : " + project_name + "  project_manager : " + project_manager
				+ "  client : " + client;
	}
	

}
