import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * admin class for performing admin logic
 */
public class Admin implements Serializable {
    private String annoucements = null;
    private String userName;
    private String password;
    private List listCourses;
    private List listFoods;
    private List listTeachers;
    private List listStudents;
    private ArrayList<ArrayList> foods = new ArrayList<>();
    private ArrayList<ArrayList> students = new ArrayList<>();
    private ArrayList<ArrayList> teachers = new ArrayList<>();
    private ArrayList<ArrayList> courses = new ArrayList<>();

    /**
     * constructor method
     * @param userName
     * @param password
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Admin(String userName,String password) throws IOException, ClassNotFoundException {
        this.userName = userName;
        this.password = password;
        String[] tempListFood = new String[]{"name", "day", "cost", "capacity", "check"};
        String[] tempListTeacher = new String[]{"username", "password", "check"};
        String[] tempListStudent = new String[]{"username", "password", "check"};
        listFoods = new List(tempListFood, foods);
        listTeachers = new List(tempListTeacher, teachers);
        listStudents = new List(tempListStudent, students);
    }
/*
    public boolean changeNamePass(String newName,String newPass){
        for(Student student : students)
            if(student.getName().equals(newName))
                return false;
        for(Teacher teacher : teachers)
            if(teacher.getName().equals(newName))
                return false;
        if(password.length() < 8)
            return false;
        userName=newName;
        password=newPass;
        return true;
    }

 */
/*
    public void addFoods(){
        Food food = new Food();
        food = display.setFood();
        foods.add(food);
    }

 */
/*
    public boolean addTeacher(String userName , String password){
        for(Teacher teacher : teachers)
            if(teacher.getName().equals(userName))
                return false;
        for(Student student : students)
            if(student.getName().equals(password))
                return false;
        if(password.length() < 8)
            return false;
        Teacher teacher = new Teacher();
        teachers.add(teacher);
        return true;
    }
    public boolean addStudent(String userName , String password){
        for(Teacher teacher : teachers)
            if(teacher.getName().equals(userName))
                return false;
        for(Student student : students)
            if(student.getName().equals(password))
                return false;
        if(password.length() < 8)
            return false;
        Student student = new Student(userName,password);
        students.add(student);
        return true;
    }

 */


    /**
     * get name of admin
     * @return name
     */
    public String getName() {
        return userName;
    }

    /**
     * get pass word of admin
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * change the password of admin
     * @param newPassword
     * @return boolean
     */
    public boolean changePassword(String newPassword) {
        if (newPassword.length() < 8)
            return false;
        this.password = newPassword;
        return true;
    }

    /**
     * check if user name is valid or not
     * @param username
     * @return boolean
     */
    public boolean checkUsername(String username) {
        if(userName.equals(username))
            return false;
        for(ArrayList student : students)
            if(student.get(0).equals(username))
                return false;
        for (ArrayList teacher : teachers)
            if(teacher.get(0).equals(username))
                return false;
        return true;
    }

    /**
     * get list of foods
     * @return Jtable
     */
    public List getListFoods() {
        return listFoods;
    }

    /**
     * get list of student
     * @return Jtable
     */
    public List getListStudents() {
        return listStudents;
    }

    /**
     * get list of teachers
     * @return Jtable
     */
    public List getListTeachers() {
        return listTeachers;
    }

    /**
     * get list of students
     * @return Arraylist
     */
    public ArrayList<ArrayList> getStudents(){
        return listStudents.getObjects();
    }

    /**
     * get list of teachers
     * @return Arraylist
     */
    public ArrayList<ArrayList> getTeachers(){
        return listTeachers.getObjects();
    }

    /**
     * get list of foods
     * @return Arraylist
     */
    public ArrayList<ArrayList> getFoods(){
        return listFoods.getObjects();
    }

    /**
     * return announce
     * @return string
     */
    public String getAnnoucements() {
        return annoucements;
    }

    /**
     * set announce
     * @param annoucements
     */
    public void setAnnoucements(String annoucements) {
        this.annoucements = annoucements;
    }

    /**
     * make list of courses using course Array list
     * @param courseArrayList
     */
    public void setListCourses(ArrayList<Course> courseArrayList){
        courses = new ArrayList<>();
        String[] tempListCourses = new String[]{"teacher","name","time"
                ,"first session","second session","units","capacity","check"};
        for(Course course : courseArrayList){
            ArrayList tempCourse = new ArrayList();
            tempCourse.add(course.getTeacher());
            tempCourse.add(course.getName());
            tempCourse.add(course.getTime());
            tempCourse.add(course.getFirstSession());
            tempCourse.add(course.getSecondSession());
            tempCourse.add(course.getUnits());
            tempCourse.add(course.getCapacity());
            courses.add(tempCourse);
        }
        listCourses = new List(tempListCourses,courses);
    }

    /**
     * get list of courses
     * @return Jtable
     */
    public List getListCourses() {
        return listCourses;
    }
}
