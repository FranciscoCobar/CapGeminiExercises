package utils;

import models.Order;

public class OrderReturns extends Returns {

	private Order resValues;
	private FoodStatus foodStatus;

	public Order getResValues() {
		return resValues;
	}

	public void setResValues(Order resValues) {
		this.resValues = resValues;
	}

	public FoodStatus getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(FoodStatus foodStatus) {
		this.foodStatus = foodStatus;
	}
	
}
