/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import newb21_2.Validation;

public class StudentController {

    StudentManage studentManage = new StudentManage();

    public void create() {
        while (true) {
            int id = Validation.getInt("Student id: ", 1, Integer.MAX_VALUE);
            String stuName = Validation.getString("Student name: ");
            int semester = Validation.getInt("Semester: ", 1, Integer.MAX_VALUE);
            String couName = Validation.getCourse("Course name: ");
            try {
                studentManage.addStudent(id, stuName, semester, couName);
                System.out.println("Add Successful");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (Validation.getYN("Do you want to continue input student(Y/N): ").equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void findAndSort() {
        String name = Validation.getString("Input search name: ");
        ArrayList<Student> findName = studentManage.findByName(name);
        if (findName.isEmpty()) {
            System.err.println("Can't find");
        } else {
            Collections.sort(findName, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getStuName().compareTo(o2.getStuName());
                }

            });
            System.out.printf("%s%15s%15s%15s\n", "ID", "Student Name", "Semester", "Course Name");
            for (Student student : findName) {
                System.out.printf("%d%15s%15d%15s\n", student.getId(), student.getStuName(), student.getSemester(), student.getCouName());
            }
        }
    }

    public void upAndDel() {
        int id = Validation.getInt("Input search id: ", 1, Integer.MAX_VALUE);
        ArrayList<Student> findId = studentManage.findById(id);
        if (findId.isEmpty()) {
            System.err.println("Can't find");
        } else {
            int number = 1;
            System.out.printf("%10s%15s%15s%15s\n", "Number", "Student Name", "Semester", "Course Name");
            for (Student student : findId) {
                System.out.printf("%10d%15s%15d%15s\n", number, student.getStuName(), student.getSemester(), student.getCouName());
                number++;
            }
            int choice = Validation.getInt("Choice number student: ", 1, findId.size());
            String ud = Validation.getUD("Update or Delete student(U/D): ");
            if (ud.equalsIgnoreCase("u")) {
                int idUp = Validation.getInt("Id: ", 1, Integer.MAX_VALUE);
                String stuName = Validation.getString("Student Name: ");
                int semester = Validation.getInt("Semester: ", 1, Integer.MAX_VALUE);
                String couName = Validation.getCourse("Course Name: ");
                try {
                    studentManage.updateStudent(findId, idUp, stuName, semester, couName, choice);
                    System.out.println("Update successful");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } else {
                try {
                    studentManage.deleteStudent(id, choice);
                    System.out.println("Delete successful");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    public void printReport() {
        try {
            // Gọi phương thức generateReport để tạo danh sách báo cáo
            ArrayList<Report> listReport = studentManage.generateReport();

            // In danh sách báo cáo
            System.out.printf("%-15s%-15s%-15s%-10s\n", "ID", "Student Name", "Course Name", "Total");
            for (Report report : listReport) {
                System.out.printf("%-15d%-15s%-15s%-10d\n",
                        report.getStuId(), report.getStuName(), report.getCouName(), report.getTotal());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
