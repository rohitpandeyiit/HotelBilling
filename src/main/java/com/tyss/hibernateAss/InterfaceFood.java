package com.tyss.hibernateAss;

import java.util.List;

public interface InterfaceFood {

	public List<Food> showAllFoodItems();

	public boolean addFoodItem(Food food);

	public boolean removeFood(int id);

	public boolean updateFood(int id);

	public double totalBill();

	public double userBill(int id);

}
