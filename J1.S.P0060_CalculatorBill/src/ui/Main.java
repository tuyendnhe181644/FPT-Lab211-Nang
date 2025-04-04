/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Person;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Khởi tạo đối tượng Person 
        Person person = new Person();
        // Tính tổng số tiền từ các hóa đơn
        int total = person.calculateTotal();
        System.out.println("This is total of bill: " + total);

        // Kiểm tra xem có đủ tiền để thanh toán hay không
        if (person.canPay()) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can’t buy it.");
        }
    }
}
