package com.cognizant.truyum.model;

import java.util.List;

public class Cart {
	private List<MenuItem> menuList;
	private double total;

	public Cart() {
		super();

	}

	public Cart(List<MenuItem> menuList, double total) {
		super();
		this.menuList = menuList;
		this.total = total;
	}

	public List<MenuItem> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuItem> menuList) {
		this.menuList = menuList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuList=" + menuList + ", total=" + total + "]";
	}

}
