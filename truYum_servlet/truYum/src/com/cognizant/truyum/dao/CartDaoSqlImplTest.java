package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void testAddCartItem() throws CartEmptyException {

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(2L, 4L);
		// Cart cart=cartDaoSqlImpl.getAllCartItems(1);
		System.out.println("User Added  Cart List for Check");
	}

	public static void testGetAllCartItems() throws CartEmptyException {
//		System.out.println("\n\nCart Items");
//		List<MenuItem> menuItemListCart = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		String active, freeDelivery;
//		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
//		Cart obj = cartDaoSqlImpl.getAllCartItems(1L);
//		menuItemListCart = obj.getMenuList();
//		System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
//				"CATEGORY", "FREE DELIVERY");
//
//		for (MenuItem menuItem : menuItemListCart) {
//			if (menuItem.getActive() == true) {
//				active = "YES";
//			} else {
//				active = "NO";
//			}
//			if (menuItem.getFreeDelivery() == true) {
//				freeDelivery = "YES";
//			} else {
//				freeDelivery = "NO";
//			}
//			System.out.format("\n%15s%15s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
//					menuItem.getPrice(), active, sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(),
//					freeDelivery);
//		}
//
//		System.out.println("\nTotal price :" + obj.getTotal());
		long userId =2L;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart obj = cartDaoSqlImpl.getAllCartItems(userId);
		System.out.println(obj.getMenuList());
		System.out.println("total price :"+obj.getTotal());

	}

	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartitem(1L, 4L);
		System.out.println("---------");
	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

}
