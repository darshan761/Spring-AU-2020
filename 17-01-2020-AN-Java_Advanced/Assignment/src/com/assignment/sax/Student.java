package com.assignment.sax;

public class Student {
	int id;
	String first_name, last_name, email, gender, addresss, dob, number;
	double cgpi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getCgpi() {
		return cgpi;
	}
	public void setCgpi(double cgpi) {
		this.cgpi = cgpi;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", gender=" + gender + ", addresss=" + addresss + ", dob=" + dob + ", number=" + number + ", cgpi="
				+ cgpi + "]";
	}
	

}
