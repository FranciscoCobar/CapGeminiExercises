package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_fco")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	private String order_status;
	private String order_delivery_address;
	private String customer_name;
	

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_delivery_address() {
		return order_delivery_address;
	}

	public void setOrder_delivery_address(String order_delivery_address) {
		this.order_delivery_address = order_delivery_address;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Order(Integer order_id, String order_status, String order_delivery_adress, String customer_name) {
		super();
		this.order_id = order_id;
		this.order_status = order_status;
		this.order_delivery_address = order_delivery_adress;
		this.customer_name = customer_name;
	}

	public Order() {}

	@Override
	public String toString() {
		return "OrderModel [order_id=" + order_id + ", order_status=" + order_status + ", order_delivery_adress="
				+ order_delivery_address + ", customer_name=" + customer_name + "]";
	}
}
