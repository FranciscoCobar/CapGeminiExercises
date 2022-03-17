package pt.restaurant.Entregas.models;

import javax.persistence.*;

@Entity
@Table(name = "orders_fco")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;
    //private String order_status;
    private String order_delivery_address;
    private String customer_name;
    private String transactionID;
    private Integer quantity;
    private String dish_name;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_delivery_address='" + order_delivery_address + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", transactionID='" + transactionID + '\'' +
                ", quantity=" + quantity +
                ", dish_name='" + dish_name + '\'' +
                '}';
    }

    public Order(Integer order_id, String order_delivery_address, String customer_name, String transactionID, Integer quantity, String dish_name) {
        this.order_id = order_id;
        this.order_delivery_address = order_delivery_address;
        this.customer_name = customer_name;
        this.transactionID = transactionID;
        this.quantity = quantity;
        this.dish_name = dish_name;
    }

    public Order() {
    }
}