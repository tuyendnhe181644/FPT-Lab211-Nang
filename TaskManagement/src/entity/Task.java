/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author win
 */
public class Task {

    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    public Task(int id, int taskTypeID, String requirementName, Date date,
            double planFrom, double planTo, String assign,
            String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        this.id = id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        if (taskTypeID <= 0) {
            throw new IllegalArgumentException("TaskType cannot be null.");
        }
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        if (requirementName == null || requirementName.trim().isEmpty()) {
            throw new IllegalArgumentException("Requirement name cannot be empty.");
        }
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    //Dieu kien cua planFrom la tu 8 den 17 .Khong the la 17.5 vi planTo cach planFrom it nhat 0.5h
    public void setPlanFrom(double planFrom) {
        if (planFrom < 8.0 || planFrom > 17 || !isHalfHourIncrement(planFrom)) {
            throw new IllegalArgumentException("PlanFrom must be between 8.0 and 17.0, and format x.0 or x.5");
        }
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    //0.5 hieu la khoang cach thoi gian it nhat giua planTo va planFrom (Thoi gian lam viec it nhat la 0.5h)
    public void setPlanTo(double planTo) {
        if (planTo < planFrom + 0.5 || planTo > 17.5 || !isHalfHourIncrement(planTo)) {
            throw new IllegalArgumentException("PlanTo must be between" + getPlanFrom() + " and 17.5,"
                    + " and in increments of 0.5.");
        }
        this.planTo = planTo;
    }

    // Kiểm tra xem giá trị có phải là bội số của 0.5 hay không
    private boolean isHalfHourIncrement(double value) {
        return value * 10 % 5 == 0; // Nếu giá trị là bội số của 0.5, thì value * 10 % 5 sẽ bằng 0
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        if (assign == null || assign.trim().isEmpty()) {
            throw new IllegalArgumentException("Assign cannot be empty.");
        }
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        if (reviewer == null || reviewer.trim().isEmpty()) {
            throw new IllegalArgumentException("Reviewer cannot be empty.");
        }
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n", getId(), getRequirementName(),
                TaskType.getTaskTypeByID(taskTypeID).getName(),
                dateFormat.format(date), getPlanTo() - getPlanFrom(), getAssign(), getReviewer());
    }

}
