package bo;

import entity.Task;
import entity.TaskType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author win
 */
public class ManagerTask {

    private ArrayList<Task> list;
    private int lastId;

    public ManagerTask() {
        list = new ArrayList<>();
    }

    // Yeu cau co Nang la chi duoc anh xa danh sach ,ko tra ve truc tiep danh sach trong getList
    // Khong duoc khai bao setList
    public ArrayList<Task> getList() {
        return new ArrayList<>(list);
    }

    private boolean isExisted(TaskType taskType, String requirementName, Date date,
            double planFrom, double planTo, String assign, String reviewer) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Task task : list) {
            if (task.getTaskType().getName().equals(taskType.getName())
                    && task.getRequirementName().equalsIgnoreCase(requirementName)
                    && dateFormat.format(task.getDate()).equalsIgnoreCase(dateFormat.format(date))
                    && task.getPlanFrom() == planFrom && task.getPlanTo() == planTo
                    && task.getAssign().equalsIgnoreCase(assign)
                    && task.getReviewer().equalsIgnoreCase(reviewer)) {
                return true;
            }
        }
        return false;
    }

    // Yeu cau them 1: Kiem tra xem khung thoi gian co bi trung voi cac nhiem vu khac cua cung mot nguoi trong cung ngay khong
    // Vi du neu giao viec trong khoang tu 8 -> 10 h thi khong the giao tiep tu 9h->10h duoc 
    private boolean isOverlappingTask(Date date, double planFrom, double planTo, String assign) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Task task : list) {
            if (task.getAssign().equalsIgnoreCase(assign)
                    && dateFormat.format(task.getDate()).equalsIgnoreCase(dateFormat.format(date))) {
                // Kiem tra trung khung thoi gian
                if (!(planTo <= task.getPlanFrom() || planFrom >= task.getPlanTo())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Yeu cau them 2: Kiem tra xem tong so gio lam viec cua mot nguoi trong ngay co vuot qua 8 tieng khong
    private boolean isOverworked(Date date, double planFrom, double planTo, String assign) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        double totalHours = 0;
        for (Task task : list) {
            if (task.getAssign().equalsIgnoreCase(assign)
                    && dateFormat.format(task.getDate()).equalsIgnoreCase(dateFormat.format(date))) {
                totalHours += task.getPlanTo() - task.getPlanFrom();
            }
        }
        // Tinh tong so gio lam viec, bao gom ca nhiem vu moi dang duoc them
        totalHours += planTo - planFrom;
        return totalHours > 8;
    }

    public int add(TaskType taskType, String requirementName, Date date,
            double planFrom, double planTo, String assign, String reviewer) throws Exception {
        // Kiem tra xem task da ton tai hay chua
        if (isExisted(taskType, requirementName, date, planFrom, planTo, assign, reviewer)) {
            throw new Exception("This task is existed!!!");
        }
        // Kiem tra xem nguoi duoc giao co nhiem vu nao bi trung khung thoi gian hay khong
        if (isOverlappingTask(date, planFrom, planTo, assign)) {
            throw new Exception("The assign person already has a task in this time range.");
        }
        // Kiem tra tong so gio lam viec cua nguoi do trong ngay co vuot qua 8 tieng khong
        if (isOverworked(date, planFrom, planTo, assign)) {
            throw new Exception("The assign person will work more than 8 hours in this day.");
        }
        if(list.isEmpty()){
            lastId=0;
        }else{
            lastId=list.get(list.size()-1).getId();
        }
        // Them nhiem vu moi vao danh sach
        Task newTask = new Task(++lastId, taskType, requirementName, date, planFrom, planTo, assign, reviewer);
        list.add(newTask);
        return newTask.getId();
    }

    public void deleteTaskById(int id) throws Exception {
        int index = getIndexByID(id);
        if (index == -1) {
            throw new Exception("Candidate does not exist!");
        }
        list.remove(index);
    }

    private int getIndexByID(int id) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if (list.isEmpty()) {
            return null;
        }
        String str = String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : list) {
            double time = task.getPlanTo() - task.getPlanFrom();
            str += String.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskType().getName(),
                    dateFormat.format(task.getDate()),
                    time,
                    task.getAssign(),
                    task.getReviewer()
            );
        }
        return str;
    }

}
