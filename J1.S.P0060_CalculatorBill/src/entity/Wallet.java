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
public class Wallet {

    private int amount;

    public Wallet() {
        input();
    }

    public Wallet(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int calcTotal(int[] bills) {
        int total = 0;
        for (int bill : bills) {
            total += bill;
        }
        return total;
    }

    public boolean payMoney(int total) {
        return this.amount >= total;
    }

    private void input() {
        // Nhập số tiền trong ví
        amount = Validator.getInt("Input value of wallet: ",
                "Out of range! Please enter a valid wallet value.",
                "Invalid input! Please enter an integer number.",
                0, Integer.MAX_VALUE);
    }
}
