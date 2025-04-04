package p0021;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class Manager {

    ArrayList<Student> ls;

    public Manager() {
        ls = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return new ArrayList<>(ls);
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        
        //duyet all doi tuong student trong list ls
        //moi phan tu dc gan vao bien t trong moi vong lap
        for (Student t : ls) {
            //chuyen ten thanh lowcase, ktra ten co chua chuoi name hay khong
            if (t.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                listStudentFindByName.add(t);
            }
        }
        return listStudentFindByName;
    }

    public ArrayList<Student> findStudentById(String id) {
        ArrayList<Student> listFindById = new ArrayList<>();
        for (Student t : ls) {
            if (t.getId().equalsIgnoreCase(id)) {
                listFindById.add(t);
            }
        }
        return listFindById;
    }
    
    //Kiểm tra xem có sinh viên nào trong danh sách ls có tất cả các thông tin trên trùng khớp không.
    public boolean checkStudentExist(String id, String name, String semester, String course) {
        for (Student s : ls) {
            if (id.equalsIgnoreCase(s.getId())
                    && name.equalsIgnoreCase(s.getStudentName())
                    && semester.equalsIgnoreCase(s.getSemester())
                    && course.equalsIgnoreCase(s.getCourseName())) {
                return false;//svien da ton tai trong danh sach
            }

        }
        return true;
    }

    //chuc nang tao hoc sinh
    public void create(Student t) throws Exception {
        //idExisted: Là một danh sách tạm chứa các sinh viên có cùng ID với sinh viên mới t.
        //Gọi một phương thức khác (giả định đã được định nghĩa trước) để tìm tất cả sinh viên trong danh sách ls có ID giống với t.getId().
        ArrayList<Student> idExisted = findStudentById(t.getId());
        //ktra list tim duoc co svien khong?
        if (!idExisted.isEmpty()) {
            //ten svien first ko trung ten svien t,co sv cung ID, khac ten
            if (!idExisted.get(0).getStudentName().equals(t.getStudentName())) {
                throw new Exception("ID nay da ton tai nhung ten hoc sinh khac nhau!");
            }
        }
        //neu co, ktra ten svien co trung vs ten svien t khong
        if (checkStudentExist(t.getId(), t.getStudentName(), t.getSemester(), t.getCourseName())) {
            ls.add(t);
        } else {
            throw new Exception("ID Existed!");
        }
    }

    public void update(String id, String oldName, String oldSemester, String oldCourse,
            String newSemester, String newCourse) throws Exception {
        // ktra xem co svien nao trong list có newSem vs newCourse chưa
        if (!checkStudentExist(id, oldName, newSemester, newCourse)) {
            throw new Exception("Thong tin nay da ton tai!");
        }
        for (Student t : ls) {
            if (t.getId().equalsIgnoreCase(id)
                    && t.getStudentName().equalsIgnoreCase(oldName)
                    && t.getSemester().equalsIgnoreCase(oldSemester)
                    && t.getCourseName().equalsIgnoreCase(oldCourse)) {
                t.setSemester(newSemester);
                t.setCourseName(newCourse);
            }
        }
    }

    public boolean delete(String id, String name, String semester, String course) {
        for (Student t : ls) {
            if (!checkStudentExist(id, name, semester, course)) {
                return ls.remove(t);
            }
        }
        
        return false;
    }

    //tao 1 bao cao dang hashM
    public HashMap<String, Integer> getListReport() throws Exception {
        // Moi key trong hashM la 1 chuoi String
        //value la integer bieu thi so lan svien thgia khoa hoc
        
        HashMap<String, Integer> listReport = new HashMap<>();
        for (Student t : ls) {
            //tao key = id, name, course
            String key = t.getId() + "/" + t.getStudentName() + "/" + t.getCourseName();
            
            //lay now key value neu key da exist,con khong thi tra ve value defaul 0
            listReport.put(key, listReport.getOrDefault(key, 0) + 1);
            //ktra key co trong list chua
        }
        return listReport;
    }

}
