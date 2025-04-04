/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newb21_2;

import Control.StudentController;

/**
 *
 * @author buidu
 */
public class NewB21_2 {

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                    + "1.	Create\n"
                    + "2.	Find and Sort\n"
                    + "3.	Update/Delete\n"
                    + "4.	Report\n"
                    + "5.	Exit");
            int op = Validation.getInt("Your choice: ", 1, 5);
            switch (op) {
                case 1:
                    studentController.create();
                    break;
                case 2:
                    studentController.findAndSort();
                    break;
                case 3:
                    studentController.upAndDel();
                    break;
                case 4:
                    studentController.printReport();
                    break;
                case 5:
                    return;
            }
        }
    }

}
