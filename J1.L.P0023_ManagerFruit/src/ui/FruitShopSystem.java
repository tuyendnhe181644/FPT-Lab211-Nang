/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author win
 */
import bo.ListFruit;
import bo.Shopping;
import validate.Validator;

public class FruitShopSystem {

    public static void main(String[] args) {
        Shopping shopping = new Shopping();  // Khởi tạo đối tượng Shopping
        ListFruit listFruit = shopping.getListFruit();
        listFruit.generateFruit();
        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");

            int choice = Validator.getInt("Enter your choice: ", "Invalid input!", "Out of range!", 1, 4);

            switch (choice) {
                case 1:
                    listFruit.createFruit();
                    break;

                case 2:
                    // Xem các đơn hàng đã đặt
                    shopping.viewOrders();
                    break;

                case 3:
                    // Mua sắm cho người mua
                    shopping.shoppingProcess();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
