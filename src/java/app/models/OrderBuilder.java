/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author navar
 */
public class OrderBuilder {
    private Order order;

    public OrderBuilder() {
        order = new Order();
    }

    public OrderBuilder withOrderId(int orderId) {
        order.setOrder_id(orderId);
        return this;
    }
    
    public OrderBuilder withComputerId(int computerId) {
        order.setComputer_id(computerId);
        return this;
    }
    
    public OrderBuilder withUsername(String username) {
        order.setUsername(username);
        return this;
    }
    
    public OrderBuilder withPrice(double price) {
        order.setPrice(price);
        return this;
    }
    
    
    public Order build() {
        return order;
    }
    
}
