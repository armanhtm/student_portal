import java.io.Serializable;
import java.util.ArrayList;

public class Teacher implements Serializable {
    private ArrayList<Course> courseArrayList;
    private String userName;
    private String password;
    private List listCourses;
    private List listStudents;
    private ArrayList<ArrayList>students ;
    private ArrayList<ArrayList>courses ;
    public Teacher(){
        students = new ArrayList<>();
        courses = new ArrayList<>();
        courseArrayList = new ArrayList<>();
        String[] tempListCourses = new String[]{"name","time"
                ,"first session","second session","capacity","units","check"};
        String[] tempListStudent = new String[]{"username","course","grade","check"};
        listCourses = new List(tempListCourses,courses);
        listStudents = new List(tempListStudent,students);
    }

/*
    public boolean changeNamePass(String newName,String newPass){
        if (Source.checkRepetetary(newName)){
            userName=newName;
            passWord=newPass;
            return true;
        }
        return false;
    }

    public Boolean addGrade(int code,Student student,int grade){
            for (Course course : courses){
                if (course.searchStudent(student) && course.getCode() == code){
                   // student.setGrade(course);
                    return true;
                }
            }
        return false;
    }

    public Boolean addCourse(){
        Course course = display.addCourse();
        for(Course course1 : courses)
            if(course.getCode() == course1.getCode())
                return false;
        courses.add(course);
        return true;
    }
*/
    public String getName() {
        return userName;
    }
    public boolean changePassword(String newPassword){
        if(newPassword.length() < 8)
            return false;
        this.password = newPassword;
        return true;
    }
    public String getPassword(){
        return password;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List getListCourses() {
        return listCourses;
    }

    public List getListStudents() {
        return listStudents;
    }

    public String getUserName() {
        return userName;
    }
    //public void removeClass(){
      //  Course course = display.removeCourse();
        //for (Student student : course.getStudents())
        //    student.getCourses().remove(course);
        //courses.remove(course);
        //source.removeClass(course);
    //}
    public ArrayList<Course> getCourse () {
        for (ArrayList temp : this.listCourses.getObjects()) {
            Course course = new Course();
            course.setNameField((String) temp.get(0));
            course.setTime((String) temp.get(1));
            course.setFirstSession((String) temp.get(2));
            course.setSecondSession((String) temp.get(3));
            course.setUnits((int) temp.get(4));
            course.setCapacity((int) temp.get(5));
            course.setTeacher(this.userName);
            courseArrayList.add(course);
        }
        return courseArrayList;
    }
}

