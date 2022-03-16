package dtos;

import java.sql.Date;

public class MenuDto {

	private String dish_name;
	private Boolean dish_availability;
	private Boolean dish_on_sale;
	private Date dish_selling_period;

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public Boolean getDish_availability() {
		return dish_availability;
	}

	public void setDish_availability(Boolean dish_availability) {
		this.dish_availability = dish_availability;
	}

	public Boolean getDish_on_sale() {
		return dish_on_sale;
	}

	public void setDish_on_sale(Boolean dish_on_sale) {
		this.dish_on_sale = dish_on_sale;
	}

	public Date getDish_selling_period() {
		return dish_selling_period;
	}

	public void setDish_selling_period(Date dish_selling_period) {
		this.dish_selling_period = dish_selling_period;
	}

	@Override
	public String toString() {
		return "MenuDto [dish_name=" + dish_name + ", dish_availability=" + dish_availability + ", dish_on_sale="
				+ dish_on_sale + ", dish_selling_period=" + dish_selling_period + ", getDish_name()=" + getDish_name()
				+ ", getDish_availability()=" + getDish_availability() + ", getDish_on_sale()=" + getDish_on_sale()
				+ ", getDish_selling_period()=" + getDish_selling_period() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public MenuDto(String dish_name, Boolean dish_availability, Boolean dish_on_sale, Date dish_selling_period) {
		super();
		this.dish_name = dish_name;
		this.dish_availability = dish_availability;
		this.dish_on_sale = dish_on_sale;
		this.dish_selling_period = dish_selling_period;
	}

	public MenuDto() {
	}
}
