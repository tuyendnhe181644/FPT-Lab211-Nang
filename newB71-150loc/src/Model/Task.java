/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import newb71.Validation;

/**
 *
 * @author buidu
 */
public class Task {

    private int id;
    private String name;
    private int typeId;
    private String date;
    private double from;
    private double to;
    private String ass;
    private String rev;

    public Task() {
    }

    public Task(int id, String name, int typeId, String date, double from, double to, String ass, String rev) {
        if (id >= 1 && !name.isEmpty() && typeId >= 1 && typeId <= 4 && Validation.checkDate(date)
                && from >= 8 && from <= 17.5 && to >= 8 && to <= 17.5 && to > from
                && !ass.isEmpty() && !rev.isEmpty()) {
            this.id = id;
            this.name = name;
            this.typeId = typeId;
            this.date = date;
            this.from = from;
            this.to = to;
            this.ass = ass;
            this.rev = rev;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 1) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        if (typeId >= 1 && typeId <= 4) {
            this.typeId = typeId;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (Validation.checkDate(date)) {
            this.date = date;
        }
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        if (from >= 8 && from <= 17.5) {
            this.from = from;
        }
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        if (to >= 8 && to <= 17.5) {
            this.to = to;
        }
    }

    public String getAss() {
        return ass;
    }

    public void setAss(String ass) {
        if (!ass.isEmpty()) {
            this.ass = ass;
        }
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        if (!rev.isEmpty()) {
            this.rev = rev;
        }
    }

    public double getTime() {
        double time = 0;
        if (to > from) {
            time = to - from;
        }
        return time;
    }

    public String taskName() {
        String taskName = "";
        if (typeId == 1) {
            taskName = "Code";
        }
        if (typeId == 2) {
            taskName = "Test";
        }
        if (typeId == 3) {
            taskName = "Design";
        }
        if (typeId == 4) {
            taskName = "Review";
        }
        return taskName;
    }

    public void output() {
        System.out.printf("%d%20s%20s%20s%20.1f%20s%20s\n",
                id, name, taskName(), date, getTime(), ass, rev);
    }

}
