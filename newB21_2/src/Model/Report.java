/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Report {

    private int stuId;
    private String stuName;
    private String couName;
    private int total;

    public Report() {
    }

    public Report(int stuId, String stuName, String couName, int total) {
        if (stuId > 0 && !stuName.isEmpty()
                && (couName.equalsIgnoreCase("java") || couName.equalsIgnoreCase("c/c++") || couName.equalsIgnoreCase(".net")) && total > 0) {
            this.stuId = stuId;
            this.stuName = stuName;
            this.couName = couName;
            this.total = total;
        }
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        if (stuId > 0) {
            this.stuId = stuId;
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

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        if (couName.equalsIgnoreCase("java") || couName.equalsIgnoreCase("c/c++") || couName.equalsIgnoreCase(".net")) {
            this.couName = couName;
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        if (total > 0) {
            this.total = total;
        }
    }

}
