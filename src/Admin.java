import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {
    private String annoucements = null;
    private String userName;
    private String password;
    private List listFoods;
    private List listTeachers;
    private List listStudents;
    private ArrayList<ArrayList> foods = new ArrayList<>();
    private ArrayList<ArrayList> students = new ArrayList<>();
    private ArrayList<ArrayList> teachers = new ArrayList<>();

    private Source source;

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


    public String getName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean changePassword(String newPassword) {
        if (newPassword.length() < 8)
            return false;
        this.password = newPassword;
        return true;
    }

    public boolean checkUsername(String username) {
//        if(userName.equals(username))
//            return false;
//        for(Student student : source.getStudents())
//            if(student.getName().equals(username))
//                return false;
//        for (Teacher teacher : source.getTeachers())
//            if(teacher.getName().equals(username))
//                return false;
        return true;
    }


    public void deleteFood(Food food) {
        foods.remove(food);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void deleteTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public List getListFoods() {
        return listFoods;
    }

    public List getListStudents() {
        return listStudents;
    }

    public List getListTeachers() {
        return listTeachers;
    }
    public ArrayList<ArrayList> getStudents(){
        return listStudents.getObjects();
    }
    public ArrayList<ArrayList> getTeachers(){
        return listTeachers.getObjects();
    }
    public ArrayList<ArrayList> getFoods(){
        return listFoods.getObjects();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAnnoucements() {
        return annoucements;
    }

    public void setAnnoucements(String annoucements) {
        this.annoucements = annoucements;
    }
}
