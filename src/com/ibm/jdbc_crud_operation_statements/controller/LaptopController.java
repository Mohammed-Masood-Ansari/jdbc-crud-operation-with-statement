package com.ibm.jdbc_crud_operation_statements.controller;

import java.util.List;
import java.util.Scanner;

import com.ibm.jdbc_crud_operation_statements.dto.Laptop;
import com.ibm.jdbc_crud_operation_statements.service.LaptopService;

public class LaptopController {

	public static void main(String[] args) {
		System.out.println("start the main method");
		Scanner scanner = new Scanner(System.in);
		Laptop laptop = new Laptop();
		LaptopService laptopService = new LaptopService();
		while (true) {
			System.out.println("1.InsertLaptop\n2.UpdateLaptop\n3.DeleteLaptop\n4.DisplayLaptop\n5.Exit");
			System.out.println("choose your choice");

			int ch = scanner.nextInt();

			switch (ch) {

			case 1: {
					System.out.println("Enter the laptopId");
					laptop.setId(scanner.nextInt());
					System.out.println("Enter the laptopName");
					laptop.setName(scanner.next());
					System.out.println("Enter the laptopPrice");
					laptop.setPrice(scanner.nextDouble());
					System.out.println("Enter the laptopColor");
					laptop.setColor(scanner.next());
					
					laptopService.insertLaptop(laptop);
					
					System.out.println("main method ended");
					
			}
				break;
			case 2: {
				System.out.println("Enter the laptopId");
				laptop.setId(scanner.nextInt());
				System.out.println("Enter the laptopName");
				laptop.setName(scanner.next());
				
				laptopService.updateLaptop(laptop);
			}
				break;
			case 3: {
				System.out.println("Enter the laptopId");
				int id = scanner.nextInt();
				
				laptopService.deleteLaptop(id);
			}
				break;
			case 4: {
				List<Laptop> laptops=laptopService.displayLaptop();
				
				for (Laptop laptop2 : laptops) {
					System.out.println(laptop2.getId());
					System.out.println(laptop2.getName());
					System.out.println(laptop2.getPrice());
					System.out.println(laptop2.getColor());
				}
			}
				break;
			case 5: {

			}
				break;
			}

		}

	}

}
