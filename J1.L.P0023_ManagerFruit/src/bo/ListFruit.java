/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Fruit;
import java.util.ArrayList;
import java.util.List;
import validate.Validator;

/**
 *
 * @author LeSyThanhLong
 */
public class ListFruit {

    List<Fruit> fruits = new ArrayList<>();

    public List<Fruit> getFruits() {
        return fruits;
    }

    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruits) {
            if (id.equals(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    private Fruit getFruitByName(String name) {
        for (Fruit fruit : fruits) {
            if (fruit.getFruitName().equalsIgnoreCase(name)) {
                return fruit;
            }
        }
        return null;
    }

    public void createFruit() {
        displayListFruit();
        while (true) {
            String fruitId = Validator.getString("Enter ID Fruit: ",
                    "Please enter string with format (Fxxxxx), x is digit", "F\\d{5}");
            Fruit fruit = getFruitById(fruitId);
            //If same ID , update new quantities of fruit
            if (fruit != null) {
                System.out.println("ID is existed");
                System.out.println(getFruitById(fruitId).toString());
                String choose = Validator.getString("You want to update quantity of fruits (Y/N): ",
                        "Just Y or N", "[YNyn]");
                if (choose.equalsIgnoreCase("Y")) {
                    int newQuantity = Validator.getInt("Enter new Quantity:", "Please enter number >0", "Invalid!", 1, Integer.MAX_VALUE);
                    fruit.setQuantity(newQuantity);
                    System.out.println("Update quantity success!");
                    return;
                }
            }
            String fruitName = Validator.getString("Enter name Fruit:", "Just be alphabet!", "[A-Za-z\\s]+");
             fruit = getFruitByName(fruitName);
            // If same name fruit then increase quantity
            if (fruit != null) {
                int quantity = Validator.getInt("Enter quantity:", "Please enter number >0", "Invalid!", 1, Integer.MAX_VALUE);
                fruit.setQuantity(fruit.getQuantity() + quantity);
            } else {
                String origin = Validator.getString("Enter origin:", "Just be alphabet!", "[A-Za-z\\s]+");
                double price = Validator.getDouble("Enter price:", "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
                int quantity = Validator.getInt("Enter quantity:", "Please enter number >0", "Invalid!", 1, Integer.MAX_VALUE);
                fruits.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            }
            System.out.println("Add success !");
            System.out.println("----------CONTINUE ADD-----------");
            String choose = Validator.getString("You want to continue (Y/N): ",
                    "Just Y or N", "[YNyn]");
            if (choose.equalsIgnoreCase("N")) {
                displayListFruit();
                break;
            }
        }
    }

    public void displayListFruit() {
        int countItem = 0;
        if (fruits.isEmpty()) {
            System.out.println("List is empty!");
        }
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                countItem++;
                if (countItem == 1) {
                    System.out.println(""
                            + "+-----+--------------------+-------------+---------------+----------\n"
                            + "|No.  |Fruit Name          |Origin       |Price          |Quantity  |\n"
                            + "+-----+--------------------+-------------+---------------+----------");
                }
                System.out.printf("|%5d|  %-18s|   %-10s|%15s|%10d|\n", countItem,
                        fruit.getFruitName(), fruit.getOrigin(),
                        ("$" + String.format("%.1f", fruit.getPrice())), fruit.getQuantity());
            }
        }
        System.out.println("+-----+--------------------+-------------+---------------+----------");
    }

    public int numberInOfStock() {
        int count = 0;
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getQuantity() != 0) {
                count++;
            }
        }
        return count;
    }

    public Fruit getFruit(int item) {
        int count = 0;
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getQuantity() != 0) {
                count++;
            }
            if (count == item) {
                return fruits.get(i);
            }
        }
        return null;
    }

    public void generateFruit() {
        fruits.add(new Fruit("F12345", "Cam", 2000, 3, "Hanoi"));
        fruits.add(new Fruit("F12346", "Quyt", 4000, 6, "Hanoi"));
        fruits.add(new Fruit("F12347", "Dua", 5000, 5, "Can Tho"));
        fruits.add(new Fruit("F41235", "Thang Long", 5000, 5, "Can Tho"));
        fruits.add(new Fruit("F51234", "Na", 5000, 5, "Can Tho"));
        fruits.add(new Fruit("F61235", "Hong Xiem", 5000, 5, "Can Tho"));
    }
}
