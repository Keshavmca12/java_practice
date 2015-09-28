package com.dto;

public class College {

	private int id;
	private String name ;
	private String location;
	@org.codehaus.jackson.annotate.JsonIgnore
	private University university;

	public College(){}

	public College(int id, String name, String location, University university){
		this.id=id;
		this.name=name;
		this.location=location;
		this.location=location;
		this.university=university;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", location="
				+ location + ", university=" + university + "]";
	}

}
