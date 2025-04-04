package p0021;

/**
 *
 * @author ADMIN
 */
public class Student implements Comparable<Student> {
//yêu cầu lớp phải định nghĩa phương thức compareTo để hỗ trợ so sánh các đối tượng.
    private String id, studentName, semester, courseName;

    public Student() {
    }

    public Student(String id, String studentName, String semester, String courseName) throws Exception {
        if (id.matches("[0-9]+")
                && studentName.matches("^[A-Z][a-z]+(?: [A-Z][a-z]+)*$")
                && semester.matches("^Spring\\d{4}$|^Sum\\d{4}$|^Fall\\d{4}$")
                && courseName.matches("^Java$|^.Net$|^C/C\\+\\+$")) {
            //(?: ...):gom các ký tự vào một đơn vị nhưng không lưu vào bộ nhớ
            //*: Không hoặc nhiều lần lặp lại
            this.id = id;
            this.studentName = studentName;
            this.semester = semester;
            this.courseName = courseName;
        } else {
            throw new Exception("Khong the khoi tao doi tuong");
        }
    }

    public void setId(String id) throws Exception {
        if (id.matches("[0-9]+")) {
            this.id = id;
        } else {
            throw new Exception("ID sai dinh dang");
        }
    }

    public void setStudentName(String studentName) throws Exception {
        if (studentName.matches("^[A-Z][a-z]+(?: [A-Z][a-z]+)*$")) {
            this.studentName = studentName;
        } else {
            throw new Exception("Ten sai sinh dang");
        }
    }

    public void setSemester(String semester) throws Exception {
        if (semester.matches("^Spring\\d{4}$|^Sum\\d{4}$|^Fall\\d{4}$")) {
            this.semester = semester;
        }
    }

    public void setCourseName(String courseName) throws Exception {
        if (courseName.matches("^Java$|^.Net$|^C/C\\+\\+$")) {
            this.courseName = courseName;
        }
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    //so sanh 2 doi tuong theo lastname
    public int compareTo(Student t){
        //studenName: fullname cua doi tuong hien tai
        String [] part1 = studentName.split(" ");
        //t.getStuNam: tra ve fullName cua doi tuong truyen vao
        //split: tách tên đầy đủ thành 1 mảng chuỗi, tách theo khoảng trắng
        String [] part2 = t.getStudentName().split(" ");
        String last1 = part1[part1.length -1];
        //part1: tên hiện tại
        String last2 = part2[part2.length -1];
        //tên truyền vào
        return last1.compareTo(last2);
    }
    
    
    
}
