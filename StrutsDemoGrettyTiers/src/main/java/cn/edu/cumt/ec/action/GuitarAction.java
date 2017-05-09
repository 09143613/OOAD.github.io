package cn.edu.cumt.ec.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


import cn.edu.cumt.ec.dao.GuitarDaoJDBCImpl;

import cn.edu.cumt.ec.service.GuitarService;

public class GuitarAction extends ActionSupport{
private GuitarService guitarService=new GuitarService();
	
	
	public String search() throws Exception{
		GuitarService guitarService = new GuitarService();
		GuitarDaoJDBCImpl guitarDao=new GuitarDaoJDBCImpl();
		guitarService.setGuitarDao(guitarDao);
		guitars = guitarService.getAllGuitars(type);
		System.out.println(guitars);
		return SUCCESS;
	}
	
	private String serialNumber, builder, model, type, backWood, topWood;
	  private double price;
	  private List guitars;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List getGuitars() {
		return guitars;
	}
	public void setGuitars(List guitars) {
		this.guitars = guitars;
	}

}
