package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;


public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		String active, freeDelivery;
		System.out.println("Items List for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "YES";
			} else {
				active = "NO";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "YES";
			} else {
				freeDelivery = "NO";
			}
			
			
			
			System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), active, sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(), freeDelivery);
		}
	}

	public static void testGetMenuItemListCustomer() {
		String active,freeDelivery;
		System.out.println("\n\n\nItem List for Customer");
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "YES";
			} else {
				active = "NO";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "YES";
			} else {
				freeDelivery = "NO";
			}
			System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), active, sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(), freeDelivery);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem=new MenuItem(1L, "Sandwich", 99.00f, true, new DateUtil().convertToDate("15/03/2020"),
				"Main course", true);
		MenuItemDaoSqlImpl menuItemSqlImpl=new MenuItemDaoSqlImpl();
		
		menuItemSqlImpl.modifyMenuItem(menuItem);
	}

	public static void testGetMenuItem() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df=new DecimalFormat("####.00");
		
		MenuItemDaoSqlImpl menuItemDaoSqlImpl=new MenuItemDaoSqlImpl();
		long menuItemId=3;
		MenuItem menuItem=menuItemDaoSqlImpl.getMenuItem(menuItemId);
		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		@SuppressWarnings("unused")
		String date=sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
		@SuppressWarnings("unused")
		String price=df.format(menuItem.getPrice());
		
		
	}

	public static void main(String[] args) {
		// Print connection object
		// Connection connection= ConnectionHandler.getConnection();
		// System.out.println("Connection->"+connection);
//		testGetMenuItemListAdmin();// Admin
//		testModifyMenuItem();//Modify
//		testGetMenuItemListAdmin();// Admin
		testGetMenuItemListCustomer();//Customer
		
	}

}
