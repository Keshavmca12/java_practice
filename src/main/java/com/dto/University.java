package com.dto;

import java.util.HashSet;
import java.util.Set;

public class University {
	private int id;
	private String name;
	private String location;
	private Set<College> children=new HashSet<College>(0);
	public Set<College> getChildren() {
		return children;
	}


	public University(int id, String name, String location,
			Set<College> children) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.children = children;
	}


	public void setChildren(Set<College> children) {
		this.children = children;
	}

	public University(){

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", location="
				+ location + ", children=" + children + "]";
	}
}
