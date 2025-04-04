/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newb71;

import Control.TaskController;

/**
 *
 * @author buidu
 */
public class NewB71 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskController tc = new TaskController();
        while (true) {
            System.out.println("========= Task program =========\n"
                    + "1.	Add Task\n"
                    + "2.	Delete task\n"
                    + "3.	Display Task\n"
                    + "4.	exit");
            int op = Validation.getInt("Choice option: ", 1, 4);
            switch (op) {
                case 1:
                    tc.addTask();
                    break;
                case 2:
                    tc.deleteTask();
                    break;
                case 3:
                    tc.display();
                    break;
                case 4:
                    return;
            }
        }
    }

}
