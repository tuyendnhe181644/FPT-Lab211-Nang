/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

/**
 *
 * @author win
 */
public class Person {

    private Wallet wallet;
    private int[] bills;

    public Person() {
        input();
    }

    public Person(Wallet wallet, int[] bills) {
        this.wallet = wallet;
        this.bills = bills;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int[] getBills() {
        return bills;
    }

    public int calculateTotal() {
        return wallet.calcTotal(bills);
    }

    public boolean canPay() {
        int total = calculateTotal();
        return wallet.payMoney(total);
    }

    private void input() {
        // Sử dụng Validator để nhập số lượng hóa đơn
        int numberOfBills = Validator.getInt("Input number of bills: ",
                "Out of range! Please enter a valid number of bills.",
                "Invalid input! Please enter an integer number.",
                1, Integer.MAX_VALUE);

        // Khởi tạo mảng chứa các hóa đơn
        bills = new int[numberOfBills];

        // Nhập giá trị cho từng hóa đơn
        for (int i = 0; i < numberOfBills; i++) {
            bills[i] = Validator.getInt("Input value of bill " + (i + 1) + ": ",
                    "Out of range! Please enter a valid bill value.",
                    "Invalid input! Please enter an integer number.", 1, Integer.MAX_VALUE);
        }
        // Khởi tạo đối tượng Wallet de nhap so du tk
        wallet = new Wallet();
    }
}
