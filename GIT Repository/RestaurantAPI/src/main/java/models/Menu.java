package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_fco")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dish_id;
	private String dish_name;
	private Boolean dish_availability;
	private Boolean dish_on_sale;
	private Date starting_selling_period;
	private Date end_selling_period;

	public Date getEnd_selling_period() {
		return end_selling_period;
	}

	public void setEnd_selling_period(Date end_selling_period) {
		this.end_selling_period = end_selling_period;
	}

	public Integer getDish_id() {
		return dish_id;
	}

	public void setDish_id(Integer dish_id) {
		this.dish_id = dish_id;
	}

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

	public Date getStarting_selling_period() {
		return starting_selling_period;
	}

	public void setStarting_selling_period(Date starting_selling_period) {
		this.starting_selling_period = starting_selling_period;
	}

	@Override
	public String toString() {
		return "Menu{" +
				"dish_id=" + dish_id +
				", dish_name='" + dish_name + '\'' +
				", dish_availability=" + dish_availability +
				", dish_on_sale=" + dish_on_sale +
				", starting_selling_period=" + starting_selling_period +
				", end_selling_period=" + end_selling_period +
				'}';
	}

	public Menu(Integer dish_id, String dish_name, Boolean dish_availability, Boolean dish_on_sale, Date starting_selling_period, Date end_selling_period) {
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_availability = dish_availability;
		this.dish_on_sale = dish_on_sale;
		this.starting_selling_period = starting_selling_period;
		this.end_selling_period = end_selling_period;
	}

	public Menu() {
	}

}
