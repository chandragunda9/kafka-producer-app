package com.learning.dto;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor  //all three annotations not working i think
public class Student {

	long id;
	String name;
	String college;
	String city;

	public Student(long id, String name, String college, String city) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", city=" + city + "]";
	}

}
