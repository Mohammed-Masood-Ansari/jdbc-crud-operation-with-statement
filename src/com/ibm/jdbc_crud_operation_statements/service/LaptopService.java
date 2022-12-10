package com.ibm.jdbc_crud_operation_statements.service;

import java.util.List;

import com.ibm.jdbc_crud_operation_statements.dao.LaptopDao;
import com.ibm.jdbc_crud_operation_statements.dto.Laptop;


public class LaptopService {

	LaptopDao dao = new LaptopDao();

	public void insertLaptop(Laptop laptop) {

		if (laptop.getPrice() <= 40000) {
			dao.insertLaptop(laptop);
			System.out.println("Data inserted");
		} else {
			System.out.println("Id is not present");
		}
	}

	// updateLaptopMethods
	public void updateLaptop(Laptop laptop) {
		dao.updateLaptop(laptop);
	}

	// deleteLaptop
	public void deleteLaptop(int id) {
		dao.deleteLaptop(id);
	}

	// displayLaptop
	public List<Laptop> displayLaptop() {
		List<Laptop> laptops= dao.displayLaptop();
		return laptops;
	}

}
