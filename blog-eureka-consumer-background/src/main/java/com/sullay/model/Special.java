package com.sullay.model;

public class Special {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Special(String name) {
		super();
		this.name = name;
	}
	public Special() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Special [name=" + name + "]";
	}
}
