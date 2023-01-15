package com.ty.one_to_one_person_pancard_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pancard {
	
	@Id
	private int pid;
	private String name;
	private String address;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Pancard [pid=" + pid + ", name=" + name + ", address=" + address + "]";
	}
	
	

}
