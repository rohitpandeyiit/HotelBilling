package com.tyss.hibernateAss;


	import javax.persistence.*;

	@Entity
	@Table
	 class Food {
		@Id
		@Column
		private int itemCode;
		@Column
		private String FoodName;
		@Column
		private double price;

		public int getItemCode() {
			return itemCode;
		}

		public void setItemCode(int itemCode) {
			this.itemCode = itemCode;
		}

		public String getFoodName() {
			return FoodName;
		}

		public void setFoodName(String foodName) {
			FoodName = foodName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

	}



