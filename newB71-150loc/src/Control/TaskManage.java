/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Task;
import java.util.ArrayList;

/**
 *
 * @author buidu
 */
public class TaskManage {

    private ArrayList<Task> listTask;

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public TaskManage() {
        listTask = new ArrayList<Task>();
    }

    public Task findById(int id) {
        Task task;
        for (int i = 0; i < listTask.size(); i++) {
            task = listTask.get(i);
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void addCourse(Task task) {
        if (findById(task.getId()) == null) {
            listTask.add(task);
            System.out.println("Add successful");
        } else {
            System.err.println("Task Id is existed");
        }
    }

//    public void deleteTask(int id) {
//        Task task = findById(id);
//        if (task == null) {
//            System.err.println("Task Id not exist");
//        } else {
//            listTask.remove(task);
//            System.out.println("Delete successful");
//        }
//    }
    public void deleteTask(int id) throws Exception {
        Task task = findById(id);
        if (task == null) {
            throw new Exception("Task ID does not exist.");
        } else {
            listTask.remove(task);
        }
    }

}
