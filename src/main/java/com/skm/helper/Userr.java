package com.skm.helper;

import java.io.Serializable;

public class Userr implements Serializable{

	private static final long serialVersionUID = -1441656001138600881L;

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
