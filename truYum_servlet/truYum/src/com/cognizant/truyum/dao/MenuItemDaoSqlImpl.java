package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public static final String MENU_ITEM_DETAILS = "select * from menu_item";
	
	public static final String UPDATE_MENU_ITEM = "update menu_item set "
			+ "me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? where me_id=?";
	
	public static final String SELECT_MENUITEM = "select * from menu_item where me_id=?";
	
	public static final String MENU_ITEM_LIST_CUSTOMER = "select * from menu_item where me_active='1' and me_date_of_launch>(select curdate())";

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		try {
			preparedstatement = connection.prepareStatement(MENU_ITEM_DETAILS);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				// System.out.println("----");
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		try {
			preparedstatement = connection.prepareStatement(MENU_ITEM_LIST_CUSTOMER);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {

			}
		}
		return menuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(UPDATE_MENU_ITEM);
			preparedstatement.setString(1, menuItem.getName());
			preparedstatement.setFloat(2, menuItem.getPrice());
			preparedstatement.setBoolean(3, menuItem.getActive());
			preparedstatement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			preparedstatement.setString(5, menuItem.getCategory());
			preparedstatement.setBoolean(6, menuItem.getFreeDelivery());
			preparedstatement.setLong(7, menuItem.getId());
			int noOfRows = preparedstatement.executeUpdate();
			if (noOfRows > 0) {
				System.out.println("\n\nUpdate Successfully!!");

			} else {
				System.out.println("\n\nNOT Updated");
			}
		} catch (SQLException e) {
			System.out.println("\n\nUpdate Not Done");

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
	public MenuItem getMenuItem(Long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		MenuItem menuItem = null;
		try {
			preparedstatement = connection.prepareStatement(SELECT_MENUITEM);
			preparedstatement.setLong(1, menuItemId);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedstatement != null)
					preparedstatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {

			}
		}
		return menuItem;
	}

}