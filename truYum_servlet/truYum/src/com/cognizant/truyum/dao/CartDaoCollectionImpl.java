package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// 1. Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 2. Get the menuItem using menuItemDao.getMenuItem(menuItemId) method
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		// 3. Check existence of user in userCarts based on userId
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuList().add(menuItem);
		} else {
			// a. Create a new Cart instance with new ArrayList
			Cart cart = new Cart();
			ArrayList<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuItem);
			cart.setMenuList(menuItemList);
			// c. Put the userId and ArrayList of MenuItem into the userCarts
			userCarts.put(userId, cart);
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		//List<MenuItem> menuItemList = userCarts.get(userId).getMenuList();
		Cart cart = userCarts.get(userId);
		double total = 0.0;
		if (userCarts.get(userId) == null || cart.getMenuList().isEmpty()) {
			throw new CartEmptyException();
		} /*else {
			for (MenuItem menuItem : menuItemList) {
				total += menuItem.getPrice();
			}*/
		List<MenuItem>menuItemList=cart.getMenuList();
		for (MenuItem menuItem : menuItemList) {
			total+=menuItem.getPrice();
		}
		//userCarts.get(userId).setTotal(total);
		cart.setTotal(total);
		return cart;
	}

	@Override
	public void removeCartitem(long userID, long menuItemId) {
		// 1. Get the List<MenuItem> from userCarts based on userId
		List<MenuItem> menuItemList = userCarts.get(userID).getMenuList();
		// 2. Iterate through the List of MenuItem
		for (int i = 0; i < menuItemList.size(); i++) {
			// a. Check if the menuItemId of each menu item from the list matches with this
			// methods input parameter
			if (menuItemList.get(i).getId() == menuItemId) {
				// b. If menuItemId matches then remove the menu item from the list
				menuItemList.remove(i);
				return;
			}

		}
	}

}
