import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Arman Hatami
 * @version 1.0
 * source class which loads all information and write them again
 */
public class Source{
    private ArrayList<Teacher> teacherArrayList;
    private ArrayList<Student> studentsArrayList;
    private ArrayList<Food> foodsArrayList;
    private ArrayList<Course> courseArrayList;
    private String adminUsername = "admin";
    private String adminPassword = "admin";
    private writeToFile writeToFileAdmin;
    private writeToFile writeToFileTeacher;
    private writeToFile writeToFileStudent;
    private writeToFile writeToFileFood;
    private writeToFile writeToFileCourse;
    private readToFile readToFileAdmin;
    private readToFile readToFileTeacher;
    private readToFile readToFileStudents;
    private readToFile readToFileFood;
    private readToFile readToFileCourse;
    private Admin admin;
    private Student student;
    private Teacher teacher;
    private String announcement;

    /**
     * constructor method
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Source() throws IOException, ClassNotFoundException {
        set();
    }

    /**
     * read admin from file
     * @return admin
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Admin getAdmin() throws IOException, ClassNotFoundException {
        readToFileAdmin = new readToFile("admin.ser");
        try {
            admin = (Admin) readToFileAdmin.readFromFile();
            readToFileAdmin.closeConnection();
        }
        catch (Exception e){
            admin = new Admin(adminUsername,adminPassword);
        }
        return admin;
    }

    /**
     * write admin and every thing that admin added to file
     * @param admin
     * @throws IOException
     */
    public void setAdmin(Admin admin) throws IOException {
        // write admin
        writeToFileAdmin = new writeToFile("admin.ser");
        writeToFileAdmin.writeObjectToFile(admin);
        writeToFileAdmin.closeFile();
        // write teachers
        writeToFileTeacher = new writeToFile("teachers.ser");
        for(ArrayList temp : admin.getTeachers()){
            int flag = 0;
            Teacher teacher = new Teacher();
            teacher.setName((String)temp.get(0));
            teacher.setPassword((String)temp.get(1));
            for(Teacher tch : teacherArrayList)
                if(tch.getName().equals(teacher.getName()) && tch.getPassword().equals(teacher.getPassword())) {
                    flag = 1;
                    break;
                }
            if(flag == 0)
                teacherArrayList.add(teacher);
        }
        writeToFileTeacher.writeObjectToFile(teacherArrayList);
        writeToFileTeacher.closeFile();
        // write students
        writeToFileStudent = new writeToFile("students.ser");
        for(ArrayList temp : admin.getStudents()){
            int flag = 0;
            Student student = new Student();
            student.setName((String)temp.get(0));
            student.setPassword((String)temp.get(1));
            for(Student std : studentsArrayList)
                if(std.getName().equals(student.getName()) && std.getPassword().equals(student.getPassword())){
                    flag = 1;
                    break;
                }
            if(flag == 0)
                studentsArrayList.add(student);
        }
        writeToFileStudent.writeObjectToFile(studentsArrayList);
        writeToFileStudent.closeFile();
        // write foods
        writeToFileFood = new writeToFile("foods.ser");
        for(ArrayList temp : admin.getFoods()){
            Food food = new Food();
            food.setFoodName((String)temp.get(0));
            food.setDay((String)temp.get(1));
            food.setCost((int)temp.get(2));
            food.setCapacity((int)temp.get(3));
            foodsArrayList.add(food);
        }
        writeToFileFood.writeObjectToFile(foodsArrayList);
        writeToFileFood.closeFile();
    }

    /**
     * read students from file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getStudentsArrayList() throws IOException, ClassNotFoundException {
        readToFileStudents = new readToFile("students.ser");
        try {
            studentsArrayList = (ArrayList<Student>) readToFileStudents.readFromFile();
            readToFileStudents.closeConnection();
        }
        catch (Exception e){
            studentsArrayList = new ArrayList<>();
        }
    }

    /**
     * read teachers from file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getTeacherArrayList() throws IOException, ClassNotFoundException {
        readToFileTeacher = new readToFile("teachers.ser");
        try {
            teacherArrayList = (ArrayList<Teacher>) readToFileTeacher.readFromFile();
            readToFileTeacher.closeConnection();
        }
        catch (Exception e){
            teacherArrayList = new ArrayList<>();
        }
    }

    /**
     * read foods from file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getFoodsArrayList() throws IOException, ClassNotFoundException {
        readToFileFood = new readToFile("foods.ser");
        try {
            foodsArrayList = (ArrayList<Food>) readToFileFood.readFromFile();
            readToFileFood.closeConnection();
        }
        catch (Exception e){
            foodsArrayList = new ArrayList<>();
        }
    }

    /**
     * read courses from file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getCourseArrayList() throws IOException, ClassNotFoundException {
        readToFileCourse= new readToFile("courses.ser");
        try {
            courseArrayList = (ArrayList<Course>) readToFileCourse.readFromFile();
            readToFileCourse.closeConnection();
        }
        catch (Exception e){
            courseArrayList = new ArrayList<>();
        }
    }

    /**
     * update teachers and write it to file
     * @throws IOException
     */
    public void setTeacherArrayList() throws IOException {
        teacherArrayList.add(teacher);
        writeToFileTeacher = new writeToFile("teachers.ser");
        writeToFileTeacher.writeObjectToFile(teacherArrayList);
        writeToFileTeacher.closeFile();
    }

    /**
     * update teachers and write it to file
     * @throws IOException
     */
    public void setStudentsArrayList() throws IOException {
        studentsArrayList.add(student);
        writeToFileStudent = new writeToFile("students.ser");
        writeToFileStudent.writeObjectToFile(studentsArrayList);
        writeToFileStudent.closeFile();
    }

    /**
     * update courses and write it to file
     * @throws IOException
     */
    public void setCourseArrayList() throws IOException {
        for(Teacher tch : teacherArrayList) {
            for (int i = 0; i < tch.getCourse().size(); i++) {
                courseArrayList.add(tch.getCourse().get(i));
            }
        }
        writeToFileCourse = new writeToFile("courses.ser");
        writeToFileCourse.writeObjectToFile(courseArrayList);
        writeToFileCourse.closeFile();
    }
    /*
    public boolean searchCourse(int code){
        for(Course course : courses)
            if(course.getCode() == code)
                return true;
        return false;
    }
    public boolean addTeacher(Teacher teacher){
        if(searchUser(teacher.getName()))
            return false;
        teachers.add(teacher);
        return true;
    }
    public boolean addStudent(Student student){
        if(searchUser(student.getName()))
            return false;
        students.add(student);
        return true;
    }
    public boolean addCourse(Course course){
        if(searchCourse(course.getCode()))
            return false;
        return true;
    }
    public void addFood(Food food){
        foods.add(food);
    }
    //public void addAdmin(txt){
        //this.admin =
   //}
     */

    /**
     * get teachers
     * @return Arraylist
     */
    public ArrayList getTeacher(){
        return teacherArrayList;
    }

    /**
     * get students
     * @return Arraylist
     */
    public ArrayList getStudent(){
        return studentsArrayList;
    }

    /**
     * find user and show its user interface
     * @param username
     * @param password
     * @return boolean
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public boolean findUser(String username,String password) throws IOException, ClassNotFoundException {
        set();
        admin.setListCourses(courseArrayList);
        if(admin.getName().equals(username) && admin.getPassword().equals(password)) {
            new AdminUi(this);
            return true;
        }
        for(Teacher tch : teacherArrayList)
            if(tch.getName().equals(username) && tch.getPassword().equals(password)){
                this.teacher = tch;
                teacherArrayList.remove(tch);
                new TeacherUi(this);
                return true;
            }
        for(Student std : studentsArrayList)
            if(std.getName().equals(username) && std.getPassword().equals(password)){
                student = std;
                student.setCourses(admin.getListCourses());
                student.setFoods(admin.getListFoods());
                studentsArrayList.remove(std);
                new StudentUi(this);
                return true;
            }
        return false;
    }

    /**
     * get current teacher
     * @return teacher
     */
    public Teacher teacher(){
        return teacher;
    }

    /**
     * get current student
     * @return student
     */
    public Student student(){
        return student;
    }

    /**
     * load all data from file to ram memory
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void set() throws IOException, ClassNotFoundException {
        getFoodsArrayList();
        getStudentsArrayList();
        getTeacherArrayList();
        getCourseArrayList();
        getAdmin();
        setAnnouncement();
    }

    /**
     * get announce
     * @return string
     */
    public String getAnnouncement() {
        return announcement;
    }

    /**
     * set announce
     */
    public void setAnnouncement() {
        this.announcement = admin.getAnnoucements();
    }

    /**
     * get current admin
     * @return admin
     */
    public Admin Admin(){
        return admin;
    }

    /**
     * add student to courses that they had picked up
     * @param temp
     */
    public void addStudentToCourse(ArrayList temp){
        for(Course course : courseArrayList){
            if(temp.get(0).equals(course.getTeacher()) && temp.get(1).equals(course.getName()) && temp.get(2).equals(course.getTime()))
                course.addStudent(student);
        }
    }
}
