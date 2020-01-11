package com.cognizant.truyum.dao;



import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it to CartDao reference
		// variable cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.addCartItem()
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);
		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 4L);
		Cart cart = cartDao.getAllCartItems(2);
		System.out.println("User Added Cart List for Checkout");
		for (MenuItem menuItem : cart.getMenuList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it CartDao reference variable
		// cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.removeCartItem()
		try {
			cartDao.removeCartitem(1, 2L);
			cartDao.removeCartitem(2, 1L);
			cartDao.removeCartitem(1, 5L);
			// 3. Invoke cartDao.getAllCartItems() with userId as 1 and 2
			Cart cart = cartDao.getAllCartItems(1);
			System.out.println("Items Afer deleting");
			for (MenuItem menuItem : cart.getMenuList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllCartItems() {

	}

	public static void main(String[] arg) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}

}
