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
    private TaskType taskType;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    // Constructor use cac ham setter de dam bao dkien valid
    public Task(int id, TaskType taskType, String requirementName, Date date,
            double planFrom, double planTo, String assign, String reviewer) {
        setId(id);
        setTaskType(taskType);
        setRequirementName(requirementName);
        setDate(date);
        setPlanFrom(planFrom);
        setPlanTo(planTo);
        setAssign(assign);
        setReviewer(reviewer);
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

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        if (taskType == null) {
            throw new IllegalArgumentException("TaskType cannot be null.");
        }
        this.taskType = taskType;
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
        if (planTo < planFrom+0.5 || planTo > 17.5 || !isHalfHourIncrement(planTo)) {
            throw new IllegalArgumentException("PlanTo must be between"+ getPlanFrom()+" and 17.5,"
                    + " and in increments of 0.5.");
        }
        this.planTo = planTo;
    }

    
    //kiem tra xem gia tri co phai la boi so cua 0.5 hay khong
    private boolean isHalfHourIncrement(double value) {
        return value * 10 % 5 == 0; // Neu gia tri la boi so cua 0.5, thi value * 10 % 5 se bang 0
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
        return String.format("Task(%d,%s,%s,%s,%.1f,%s,%s)\n",
                getId(),
                getRequirementName(),
                getTaskType().getName(),
                dateFormat.format(getDate()),
                getPlanTo() - getPlanFrom(),
                getAssign(),
                getReviewer()
        );
    }
}
