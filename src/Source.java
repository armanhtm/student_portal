import java.io.*;
import java.util.ArrayList;

public class Source {
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

    public Source() throws IOException, ClassNotFoundException {
        set();
    }
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
    public void setAdmin(Admin admin) throws IOException {
        writeToFileAdmin = new writeToFile("admin.ser");
        writeToFileAdmin.writeObjectToFile(admin);
        writeToFileAdmin.closeFile();
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
    public void getCourseArrayList() throws IOException, ClassNotFoundException {
        readToFileFood = new readToFile("courses.ser");
        try {
            courseArrayList = (ArrayList<Course>) readToFileCourse.readFromFile();
            readToFileCourse.closeConnection();
        }
        catch (Exception e){
            courseArrayList = new ArrayList<>();
        }
    }
    public void setTeacherArrayList() throws IOException {
        teacherArrayList.add(teacher);
        writeToFileTeacher = new writeToFile("teachers.ser");
        writeToFileTeacher.writeObjectToFile(teacherArrayList);
        writeToFileTeacher.closeFile();
    }
    public void setStudentsArrayList() throws IOException {
        studentsArrayList.add(student);
        writeToFileStudent = new writeToFile("students.ser");
        writeToFileStudent.writeObjectToFile(studentsArrayList);
        writeToFileStudent.closeFile();
    }
    public void setCourseArrayList() throws IOException {
        courseArrayList = new ArrayList<>();
        for(Teacher tch : teacherArrayList)
            for(int i = 0 ; i < tch.getCourse().size() ; i++)
                courseArrayList.add(tch.getCourse().get(i));
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
    public ArrayList getTeacher(){
        return teacherArrayList;
    }
    public ArrayList getStudent(){
        return studentsArrayList;
    }
    public boolean findUser(String username,String password) throws IOException, ClassNotFoundException {
        set();
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
                student.setCourses(setCourseForStudent());
                student.setFoods(admin.getListFoods());
                studentsArrayList.remove(std);
                new StudentUi(this);
                return true;
            }
        return false;
    }
    public Teacher teacher(){
        return teacher;
    }
    public Student student(){
        return student;
    }
    public ArrayList<ArrayList> setCourseForStudent(){
        ArrayList<ArrayList> courses = new ArrayList<>();
        for(Course course : courseArrayList){
            ArrayList tempCourse = new ArrayList();
            tempCourse.add(course.getTeacher());
            tempCourse.add(course.getName());
            tempCourse.add(course.getTime());
            tempCourse.add(course.getFirstSession());
            tempCourse.add(course.getSecondSession());
            tempCourse.add(course.getUnits());
            tempCourse.get(course.getCapacity());
            courses.add(tempCourse);
        }
        return courses;
    }
    public void set() throws IOException, ClassNotFoundException {
        getFoodsArrayList();
        getStudentsArrayList();
        getTeacherArrayList();
        getCourseArrayList();
        getAdmin();
        setAnnouncement();
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement() {
        this.announcement = admin.getAnnoucements();
    }
}
