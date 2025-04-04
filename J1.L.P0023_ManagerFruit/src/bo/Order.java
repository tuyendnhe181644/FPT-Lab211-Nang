/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author win
 */
import entity.Fruit;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<Fruit> orderList;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderList = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Fruit> getOrderList() {
        return orderList;
    }

    public void addFruitToOrder(Fruit fruitNewOrder) {
        //Kiem tra xem danh sach da mua co chua qua minh muon mua hay khong,
        //Neu co roi thi tang so luong , chua co thi them vao order list
        Fruit fruitInOrder = checkFruitInOrder(fruitNewOrder.getFruitId());
        if (fruitInOrder != null) {
            fruitInOrder.setQuantity(fruitInOrder.getQuantity() + fruitNewOrder.getQuantity());
        } else {
            orderList.add(fruitNewOrder);
        }
    }

    public Fruit checkFruitInOrder(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getFruitId().equalsIgnoreCase(id)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    public double calculateTotal() {
        double total = 0;
        for (Fruit fruit : orderList) {
            total += fruit.getPrice() * fruit.getQuantity();
        }
        return total;
    }
}
