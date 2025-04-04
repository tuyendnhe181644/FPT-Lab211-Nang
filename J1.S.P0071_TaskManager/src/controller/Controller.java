/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.ManagerTask;
import utils.TaskInputer;
import entity.Task;
import utils.Validator;

/**
 *
 * @author win
 */
public class Controller {

    private ManagerTask managerTask;

    public Controller() {
        managerTask = new ManagerTask();
    }

    public ManagerTask getManagerTask() {
        return managerTask;
    }

    public void setManagerTask(ManagerTask managerTask) {
        this.managerTask = managerTask;
    }

    public int add() throws Exception {
        Task task = TaskInputer.input();
        return managerTask.add(task.getTaskType(),task.getRequirementName(),
                task.getDate(),task.getPlanFrom(),task.getPlanTo(),task.getAssign(),task.getReviewer());
    }

    public void delete() throws Exception {
        int ID = Validator.getInt("Task ID: ", "Invalid!", "Invalid!",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        managerTask.deleteTaskById(ID);
    }

    public void show() throws Exception {
        String str= managerTask.toString();
        if(str==null){
            throw new Exception("This list task is empty!");
        }
        System.out.println(str);
    }
}
