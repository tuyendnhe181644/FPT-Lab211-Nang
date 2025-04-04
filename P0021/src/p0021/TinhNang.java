package p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TinhNang {

    Manager m = new Manager();
    Valid v = new Valid();

    public void display() throws Exception {
        while (true) {
            System.out.println("Wellcom");
            System.out.println("1. Create: ");
            System.out.println("2. Find and Sort: ");
            System.out.println("3. Update / Delete: ");
            System.out.println("4. Report: ");
            System.out.println("5. Exit");

            int choice = v.getInt("Enter choice from 1-5: ", "[0-9]+");
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    updateOrDelete();
                    break;
                case 4:
                    reportStudent();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Only choice 1-5: ");
                    break;
            }
        }
    }
        
        

    public void createStudent() throws Exception {
        if (m.getStudentList().size() > 10) {
            String res = v.getString("Do u wanna continue (y/N)?", "[yYnN]");
            if (res.equalsIgnoreCase("N")) {
                return;
            }
        }
        String id = v.getString("Enter ID: ", "[0-9]+");
        String name = v.getString("Enter name: ", "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$");
        String semester = v.getString("Enter semester: ", "^Spring\\d{4}$|^Sum\\d{4}$|^Fall\\d{4}$");
        String course = v.getString("Enter course: ", "^Java$|^.Net$|^C/C\\+\\+$");

        try {
            Student t = new Student(id, name, semester, course);
            if (m.checkStudentExist(id, name, semester, course)) {
                m.create(t);
            } else {
                System.out.println("ID existed");
                return;
            }
            System.out.println("Add success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findAndSort() throws Exception {
        System.out.println("Enter name to find: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        ArrayList<Student> listFindByName = m.findStudentByName(name);
        try {
            sort(listFindByName);
            System.out.printf("%-5s%-15s%-15s%-15s\n", "ID", "StudentName", "Semester", "CourseName");
            for (Student t : listFindByName) {
                print(t);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateOrDelete() throws Exception {
        String id = v.getString("Enter ID to find: ", "[0-9]+");
        ArrayList<Student> listFindById = new ArrayList<>();
        try {
            listFindById = m.findStudentById(id);
            if (listFindById.isEmpty()) {
                throw new Exception("Khong tim thay sinh vien");
            }
            System.out.println("Tim thay sinh vien: ");
            for (Student t : listFindById) {
                //tra ve chi so sv in list bat dau tu 0, roi +1
                System.out.print(listFindById.indexOf(t) + 1 + ". ");
                print(t);
            }
            String res = v.getString("Choose U/u to Update or D/d to Delete: ", "[uUdD]");

            if (res.equalsIgnoreCase("d")) {
                while (true) {
                    int choice = v.getInt("Nhap so thu tu can xoa: ", "[0-9]+");
                    if (choice > 0 && choice <= listFindById.size()) {
                        
                        //listFindById bat dau tu 0
                        m.delete(id, listFindById.get(choice - 1).getStudentName(),
                                listFindById.get(choice - 1).getSemester(),
                                listFindById.get(choice - 1).getCourseName());
                        System.out.println("Delete success");
                        return;
                    } else {
                        System.out.println("Nhap so thu tu sai, khong the xoa!");
                    }
                }
            }

            if (res.equalsIgnoreCase("u")) {
                while (true) {
                    int choice = v.getInt("Nhap so thhu tu can Update: ", "[0-9]+");
                    if (choice > 0 && choice <= listFindById.size()) {
                        String semester = v.getString("Enter new Semester: ", "^Spring\\d{4}$|^Sum\\d{4}$|^Fall\\d{4}$");
                        String course = v.getString("Entter new Course: ", "^Java$|^.Net$|^C/C\\+\\+$");
                        m.update(id, listFindById.get(choice - 1).getStudentName(),
                                listFindById.get(choice - 1).getSemester(),
                                listFindById.get(choice - 1).getCourseName(), semester, course);
                        System.out.println("Update success");
                        return;
                    } else {
                        System.out.println("Nhap so thu tu sai. Nhap lai: ");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reportStudent() throws Exception {
        HashMap<String, Integer> lr = m.getListReport();
        if (lr.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        try {
            System.out.printf("%-5s|%-15s|%-10s|%-5s\n", "ID", "Name", "Course", "Total");
            for (String key : lr.keySet()) {
                String[] parts = key.split("/");
                String id = parts[0];
                String name = parts[1];
                String course = parts[2];
                int total = lr.get(key);//gia tri key trong hashM
                System.out.printf("%-5s|%-15s|%-10s|%-5s\n", id, name, course, total);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Student> sort(ArrayList<Student> lst) throws Exception {
        if (lst.isEmpty()) {
            throw new Exception("List is empty!");
        }
        Collections.sort(lst, (s1, s2) -> {
        
        //.substring(... + 1): Trích xuất chuỗi con từ sau khoảng trắng cuối cùng đến hết chuỗi.
        String lastName1 = s1.getStudentName().substring(s1.getStudentName().lastIndexOf(" ") + 1);
        String lastName2 = s2.getStudentName().substring(s2.getStudentName().lastIndexOf(" ") + 1);
        return lastName1.compareToIgnoreCase(lastName2);
    });
        return lst;
    }
    
    public void print(Student t){
        System.out.printf("%-5s%-15s%-15s%-15s\n", t.getId(),t.getStudentName(),
                t.getSemester(),t.getCourseName());
    }

}
