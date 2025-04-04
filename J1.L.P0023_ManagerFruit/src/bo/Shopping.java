/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Fruit;
import java.util.Hashtable;
import java.util.Map;
import validate.Validator;

/**
 *
 * @author win
 */
public class Shopping {

    ListFruit listFruit;
    Map<String, Order> orders;

    public Shopping() {
        listFruit = new ListFruit();
        orders = new Hashtable<>();
    }

    public ListFruit getListFruit() {
        return listFruit;
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void shoppingProcess() {
        String name = Validator.getString("Enter name:", "Invalid!", "[A-Za-z\\s]+");
        Order order;
        if (orders.containsKey(name)) {
            order = orders.get(name);
        } else {
            order = new Order(name);
        }

        while (true) {
            listFruit.displayListFruit();
            if (listFruit.numberInOfStock() == 0) {
                System.out.println("Out of stock!");
                break;
            }

            int item = Validator.getInt("Enter item(Enter 0 to exit!): ", "Error range!",
                    "Invalid!", 0, listFruit.numberInOfStock());
            if (item == 0) {
                System.out.println("See you again!");
                return;
            }
            //Select fruit by item
            Fruit selectedFruit = listFruit.getFruit(item);
            System.out.println("You selected: " + selectedFruit.getFruitName());

            int quantityOrder = Validator.getInt("Enter quantity: ", "Invalid quantity",
                    "Invalid!", 1, selectedFruit.getQuantity());

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantityOrder);
            Fruit orderFruit = new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(), selectedFruit.getPrice(),
                    quantityOrder, selectedFruit.getOrigin());
            order.addFruitToOrder(orderFruit);
            System.out.println("----------CONTINUE ADD-----------");
            String choose = Validator.getString("You want to continue (Y/N): ", "Just Y or N", "[YNyn]");
            if (choose.equalsIgnoreCase("N")) {
                System.out.println("Thank you!");
                break;
            }
        }

        if (!order.getOrderList().isEmpty()) {
            orders.put(name, order);
            System.out.println("Orders success");
        } else {
            System.out.println("No orders");
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
            return;
        }

        for (Order order : orders.values()) {
            displayOrder(order);
        }
    }

    public void displayOrder(Order order) {
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println(""
                + "+-----+--------------------+----------+-----------+------------+\n"
                + "+No.  |     Product        |  Quantity| Price     |  Amount    |\n"
                + "+-----+--------------------+----------+-----------+------------+");
        for (int i = 0; i < order.getOrderList().size(); i++) {
            System.out.printf("|%5d|    %-16s|  %8d| %10s|  %10s|\n", (i + 1), order.getOrderList().get(i).getFruitName(),
                    order.getOrderList().get(i).getQuantity(), "$" + String.format("%.1f", order.getOrderList().get(i).getPrice()),
                    "$" + String.format("%.1f", order.getOrderList().get(i).getPrice() * order.getOrderList().get(i).getQuantity()));
        }
        double total = order.calculateTotal();
        System.out.println("+-----+--------------------+----------+-----------+------------+");
        System.out.printf("|\t\t\t\t\tTotal     |%12s|\n", "$" + String.format("%.1f", total));
        System.out.println("+-----+--------------------+----------+-----------+------------+");
    }
}
