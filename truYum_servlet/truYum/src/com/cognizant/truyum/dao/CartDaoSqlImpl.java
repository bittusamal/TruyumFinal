package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id) values (?,?)";
	public static final String GET_ALL_CART_ITEM = "select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item inner join cart on cart.ct_me_id=menu_item.me_id where ct_us_id=?";
	public static final String GET_TOTAl_PRICE = "select sum(me_price) as Total from menu_item inner join cart on cart.ct_me_id=menu_item.me_id where ct_us_id=?";
	public static final String REMOVE_MENUITEM = "delete from cart where ct_us_id=? and ct_me_id=?  limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, menuItemId);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Cart cart = new Cart();
		try {
			preparedstatement = connection.prepareStatement(GET_ALL_CART_ITEM);
			preparedstatement.setLong(1, userId);
			resultSetList = preparedstatement.executeQuery();
			while (resultSetList.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSetList.getLong("me_id"));
				menuItem.setName(resultSetList.getString("me_name"));
				menuItem.setPrice(resultSetList.getFloat("me_price"));
				menuItem.setActive(resultSetList.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSetList.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSetList.getString("me_category"));
				menuItem.setFreeDelivery(resultSetList.getString("me_free_delivery").equals("1"));
				menuItemList.add(menuItem);
			}

			preparedStatementTotal = connection.prepareStatement(GET_TOTAl_PRICE);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuList(menuItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (preparedStatementTotal != null)
					preparedStatementTotal.close();
				if (resultSetList != null)
					resultSetList.close();
				if (resultSetTotal != null)
					resultSetList.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}

		return cart;
	}

	@Override
	public void removeCartitem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(REMOVE_MENUITEM);
			preparedstatement.setLong(1, userId);
			preparedstatement.setLong(2, menuItemId);
			int noOfRows = preparedstatement.executeUpdate();
			System.out.println("rows affected\t" + noOfRows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {

			}

		}
	}

}
