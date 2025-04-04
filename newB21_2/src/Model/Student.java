/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Student {

    private int id;
    private String stuName;
    private int semester;
    private String couName;

    public Student() {
    }

    public Student(int id, String stuName, int semester, String couName) {
        if (id > 0 && !stuName.isEmpty() && semester > 0
                && (couName.equalsIgnoreCase("java") || couName.equalsIgnoreCase("c/c++") || couName.equalsIgnoreCase(".net"))) {
            this.id = id;
            this.stuName = stuName;
            this.semester = semester;
            this.couName = couName;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        if (!stuName.isEmpty()) {
            this.stuName = stuName;
        }
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester > 0) {
            this.semester = semester;
        }
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        if (couName.equalsIgnoreCase("java") || couName.equalsIgnoreCase("c/c++") || couName.equalsIgnoreCase(".net")) {
            this.couName = couName;
        }
    }

}
