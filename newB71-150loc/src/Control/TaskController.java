/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Task;
import java.util.ArrayList;
import newb71.Validation;

/**
 *
 * @author buidu
 */
public class TaskController {

    TaskManage taskmanage = new TaskManage();

    public void addTask() {
        System.out.println("------------Add Task---------------");
        int id = 1;
        if (!taskmanage.getListTask().isEmpty()) {
            id = taskmanage.getListTask().get(taskmanage.getListTask().size() - 1).getId() + 1;
        }
        String name = Validation.getString("Requirement Name: ");
        int typeId = Validation.getInt("Task Type: ", 1, 4);
        String date = Validation.getDate("Date: ");
        double from = Validation.getDouble("From: ", 8, 17.5);
        double to = Validation.getDouble("To: ", 8, 17.5);
        String ass = Validation.getString("Assignee: ");
        String rev = Validation.getString("Reviewer: ");
        try {
            taskmanage.addCourse(new Task(id, name, typeId, date, from, to, ass, rev));
        } catch (Exception e) {
            System.err.println("Add Fail");
        }
    }

//    public void deleteTask() {
//        System.out.println("---------Del Task------");
//        int id = Validation.getInt("ID: ", 1, Integer.MAX_VALUE);
//        try {
//            taskmanage.deleteTask(id);
//        } catch (Exception e) {
//            System.err.println("Delete Fail");
//        }
//    }
    public void deleteTask() {
        System.out.println("---------Del Task------");
        int id = Validation.getInt("ID: ", 1, Integer.MAX_VALUE);
        try {
            taskmanage.deleteTask(id);
            System.out.println("Delete successful");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void display() {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        if (taskmanage.getListTask().isEmpty()) {
            System.err.println("List Empty");
        }
        System.out.printf("%s%20s%20s%20s%20s%20s%20s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        ArrayList<Task> listTast = taskmanage.getListTask();
        for (Task task : listTast) {
            task.output();
        }
    }
}
