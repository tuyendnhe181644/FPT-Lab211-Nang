/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Report;
import Model.Student;
import java.util.ArrayList;

public class StudentManage {

    private ArrayList<Student> listStudent;

    public StudentManage() {
        listStudent = new ArrayList<Student>();
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public ArrayList<Student> findById(int id) {
        ArrayList<Student> findId = new ArrayList<Student>();
        Student stu;
        for (int i = 0; i < listStudent.size(); i++) {
            stu = listStudent.get(i);
            if (stu.getId() == id) {
                findId.add(stu);
            }
        }
        return findId;
    }

    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> findName = new ArrayList<Student>();
        Student stu;
        for (int i = 0; i < listStudent.size(); i++) {
            stu = listStudent.get(i);
            if (stu.getStuName().equalsIgnoreCase(name)) {
                findName.add(stu);
            }
        }
        return findName;
    }

    public boolean checkIdExist(int id, String name) {
        for (Student student : listStudent) {
            if (student.getId() == id && !student.getStuName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkStuExist(int id, String name, int semester, String couName) {
        for (Student student : listStudent) {
            if (student.getId() == id && student.getStuName().equalsIgnoreCase(name)
                    && student.getSemester() == semester && student.getCouName().equalsIgnoreCase(couName)) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(int id, String name, int semester, String couName) throws Exception {
        if (checkIdExist(id, name)) {
            throw new Exception("Id exist");
        }
        if (checkStuExist(id, name, semester, couName)) {
            throw new Exception("Student exist");
        }
        listStudent.add(new Student(id, name, semester, couName));
    }

    public void deleteStudent(int id, int choice) throws Exception {
        ArrayList<Student> findId = findById(id);
        if (!findId.isEmpty()) {
            listStudent.remove(findId.get(choice - 1));
        } else {
            throw new Exception("id not exist");
        }
    }

    public void updateStudent(ArrayList<Student> findId, int id, String name, int semester, String couName, int choice) throws Exception {
        if (!findId.isEmpty()) {
            if (findId.get(choice - 1).getId() == id
                    && findId.get(choice - 1).getStuName().equalsIgnoreCase(name)
                    && findId.get(choice - 1).getSemester() == semester
                    && findId.get(choice - 1).getCouName().equalsIgnoreCase(couName)) {
                throw new Exception("Changle nothing!");
            }
            if (!checkStuExist(id, name, semester, couName) && !checkIdExist(id, name)) {
                findId.get(choice - 1).setId(id);
                findId.get(choice - 1).setStuName(name);
                findId.get(choice - 1).setSemester(semester);
                findId.get(choice - 1).setCouName(couName);
            } else {
                throw new Exception("Update fail!");
            }
        } else {
            throw new Exception("id not exist");
        }
    }

    public ArrayList<Report> generateReport() throws Exception {
        if (listStudent.isEmpty()) {
            throw new Exception("List empty!");
        } else {
            ArrayList<Report> listReport = new ArrayList<>();
            for (Student s : listStudent) {
                int count = 0;
                int stuId = s.getId();
                String studentName = s.getStuName();
                String courseName = s.getCouName();
                for (Student stu : listStudent) {
                    if (stuId == stu.getId()
                            && studentName.equalsIgnoreCase(stu.getStuName())
                            && courseName.equalsIgnoreCase(stu.getCouName())) {
                        count++;
                    }
                }
                // Kiểm tra xem báo cáo đã tồn tại hay chưa
                boolean reportExists = false;
                for (Report report : listReport) {
                    if (report.getStuId() == stuId && report.getStuName().equalsIgnoreCase(studentName)
                            && report.getCouName().equalsIgnoreCase(courseName)) {
                        reportExists = true;
                        break;
                    }
                }
                if (reportExists == false) {
                    listReport.add(new Report(stuId, studentName, courseName, count));
                }
            }
            return listReport;
        }
    }
}
