package dtos;

public class OrderDto {

	private String order_status;
	private String order_delivery_adress;
	private String customer_name;

	public OrderDto(String order_status, String order_delivery_adress, String customer_name) {
		super();
		this.order_status = order_status;
		this.order_delivery_adress = order_delivery_adress;
		this.customer_name = customer_name;
	}

	public OrderDto() {
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_delivery_adress() {
		return order_delivery_adress;
	}

	public void setOrder_delivery_adress(String order_delivery_adress) {
		this.order_delivery_adress = order_delivery_adress;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Override
	public String toString() {
		return "OrderDto [order_status=" + order_status + ", order_delivery_adress=" + order_delivery_adress
				+ ", customer_name=" + customer_name + "]";
	}

}
