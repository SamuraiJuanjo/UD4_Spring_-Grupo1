package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Servicio;

import lombok.Data;

@Data
public class BusinessModel extends UserDTO{
	
	private String name, address,phone;
	private String logo;
	private List<Servicio> servicioList;
	private int deleted;
	
	

	public BusinessModel() {
		super();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Servicio> getServicioList() {
		return servicioList;
	}

	public void setServicioList(List<Servicio> servicioList) {
		this.servicioList = servicioList;
	}
	
	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public BusinessModel(int id, String username, String password, int enabled, String role, String token,
			String name, String address, String phone, String logo, List<Servicio> servicioList, int deleted) {
		super(id, username, password, enabled, role, token);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.logo = logo;
		this.servicioList = servicioList;
		this.deleted = deleted;
	}
	
	
}