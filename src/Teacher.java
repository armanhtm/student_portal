import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.StreamSupport;
/**
 * @author Arman Hatami
 * @version 1.0
 * teacher class for perform teacher logic
 */
public class Teacher implements Serializable {
    private ArrayList<Course> courseArrayList = new ArrayList<>();
    private String userName;
    private String password;
    private List listCourses;
    private List listStudents;
    private ArrayList<ArrayList>students ;
    private ArrayList<ArrayList>courses ;

    /**
     * constructor method
     */
    public Teacher(){
        students = new ArrayList<>();
        courses = new ArrayList<>();
        String[] tempListCourses = new String[]{"name","time"
                ,"first session","second session","units","capacity","check"};
        String[] tempListStudent = new String[]{"username","course","grade","check"};
        listCourses = new List(tempListCourses,courses);
        listStudents = new List(tempListStudent,students);
        setStudents();
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

    /**
     * get name of teacher
     * @return name
     */
    public String getName() {
        return userName;
    }

    /**
     * change password of teacher
     * @param newPassword
     * @return boolean
     */
    public boolean changePassword(String newPassword){
        if(newPassword.length() < 8)
            return false;
        this.password = newPassword;
        return true;
    }

    /**
     * get password of teacher
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     * set name of teacher
     * @param name
     */
    public void setName(String name) {
        this.userName = name;
    }

    /**
     * set password of teacher
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get list of courses
     * @return Jtable
     */
    public List getListCourses() {
        return listCourses;
    }

    /**
     * get list of students
     * @return Jtable
     */
    public List getListStudents() {
        return listStudents;
    }

    /**
     * get username of teacher
     * @return string
     */
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

    /**
     * get courses that teacher added
     * @return Arraylist
     */
    public ArrayList<Course> getCourse () {
        courseArrayList = new ArrayList<>();
        for (ArrayList temp : listCourses.getObjects()) {
            Course course = new Course();
            course.setNameField((String) temp.get(0));
            course.setTime((String) temp.get(1));
            course.setFirstSession((String) temp.get(2));
            course.setSecondSession((String) temp.get(3));
            course.setUnits((int) temp.get(4));
            course.setCapacity((int) temp.get(5));
            course.setTeacher(userName);
            courseArrayList.add(course);
        }
        return courseArrayList;
    }

    /**
     * set students for teacher for grading
     */
    public void setStudents() {
        ArrayList temp = new ArrayList();
        for (Course course : courseArrayList)
            for (Student student : course.getStudents()) {
                temp.add(student.getName());
                temp.add(course.getName());
                temp.add("");
            }
        students.add(temp);
    }
}

