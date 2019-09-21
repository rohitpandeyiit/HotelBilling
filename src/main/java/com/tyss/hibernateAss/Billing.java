package com.tyss.hibernateAss;
import java.util.List;
import java.util.Scanner;

public class Billing {

	public static void main(String[] args) {


		 Implementation fi = new  Implementation();
		Food food = new Food();

		System.out.println("Press 1 to show all food items...");
		System.out.println("Press 2 to take order from customers...");
		System.out.println("Press 3 to operate on food items...");
		System.out.println("Press 4 to see total bill of the day...");

		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		do {
		switch (i) {
		case 1:
			List<Food> al = fi.showAllFoodItems();
			for (Food food2 : al) {
				System.out.print(food2.getItemCode());
				System.out.print("      " + food2.getFoodName());
				System.out.print("      " + food2.getPrice());
				System.out.println();
			}
			break;
		case 2:

			System.out.println("Enter item code of the food you want to have..");
			int id2 = sc.nextInt();
			double sum2 = 0;
			do {
			double d2 = fi.userBill(id2);
			sum2 = sum2+d2; 
			System.out.println("Enter item code of the food you want to have and press 0 to stop..");
			 id2 = sc.nextInt();
			}while(id2  != 0);

			System.out.println("your bill is " + sum2);

			break;
		case 3:
			System.out.println("Press 1 to add food items...");
			System.out.println("Press 2 to remove food item...");
			System.out.println("Press 3 to modify food item...");
			int i2 = sc.nextInt();
			switch (i2) {
			case 1:
				System.out.println("Add food details");
				System.out.println("Add item code");
				food.setItemCode(sc.nextInt());
				System.out.println("Add food name");
				food.setFoodName(sc.next());
				System.out.println("Add food price");
				food.setPrice(sc.nextDouble());
				boolean b = fi.addFoodItem(food);
				if (b) {
					System.out.println("item inserted....");
				}
				break;
			case 2:
				System.out.println("Enter Food id You Want to remove");
				boolean b2 = fi.removeFood(sc.nextInt());
				if (b2) {
					System.out.println("item removed....");
				}
				break;
			case 3:
				System.out.println("Enter Food id You Want to Update...");
				boolean b3 = fi.updateFood(sc.nextInt());
				if (b3) {
					System.out.println("item updated....");
				}
			}
			break;

		case 4:
			System.out.println("total bill is");
			double d = fi.totalBill();
			System.out.println(d);
			break;
			
			default:
				System.out.println("Run the program again and Press Valid key");

		}
		System.out.println();
		System.out.println("Press 1 to show all food items...");
		System.out.println("Press 2 to take order from customers...");
		System.out.println("Press 3 to operate on food items...");
		System.out.println("Press 4 to see total bill of the day...");

		i = sc.nextInt();
	}while(i<6);

	}


	}


