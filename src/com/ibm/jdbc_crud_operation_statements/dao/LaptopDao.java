package com.ibm.jdbc_crud_operation_statements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.jdbc_crud_operation_statements.dto.Laptop;

public class LaptopDao {

	public void insertLaptop(Laptop laptop) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
			String user = "root";
			String pass = "root";

			Connection connection = DriverManager.getConnection(url, user, pass);

			Statement statement = connection.createStatement();

			String insert = "insert into laptop values(" + laptop.getId() + ",'" + laptop.getName() + "',"
					+ laptop.getPrice() + "" + ",'" + laptop.getColor() + "')";

			statement.execute(insert);
			System.out.println("inserted ");
			System.out.println("this is dao class");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// updateLaptopMethods
	public void updateLaptop(Laptop laptop) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
			String user = "root";
			String pass = "root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String update = "update laptop set name='"+laptop.getName()+"' "
					+ "WHERE id = "+laptop.getId()+"";
			
			int id=statement.executeUpdate(update);
			
			if(id!=0) {
				System.out.println("data updated");
			}else {
				System.out.println("id is not present");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//deleteLaptop
	public void deleteLaptop(int id) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
			String user = "root";
			String pass = "root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String delete = "delete from laptop where id = "+id+"";
			
			int id1=statement.executeUpdate(delete);
			
			if(id1!=0) {
				System.out.println("data deleted");
			}else {
				System.out.println("id is not present");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//displayLaptop
	public List<Laptop> displayLaptop() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc-crud-operation-statements";
			String user = "root";
			String pass = "root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			Statement statement=connection.createStatement();
			
			String select = "SELECT * FROM laptop";
			
			ResultSet resultSet=statement.executeQuery(select);
			
			List<Laptop> laptops = new ArrayList<Laptop>();
			
			while(resultSet.next()) {
				Laptop laptop = new Laptop();
				laptop.setId(resultSet.getInt("id"));
				laptop.setName(resultSet.getString("name"));
				laptop.setPrice(resultSet.getDouble("price"));
				laptop.setColor(resultSet.getString("color"));
				
				laptops.add(laptop);
			
			}
			
			return laptops;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
