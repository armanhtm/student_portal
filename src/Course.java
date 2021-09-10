import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * course class that teacher create
 */
public class Course implements Serializable {
    private ArrayList<Student> students = new ArrayList<>();
    private String teacher;
    private String nameField;
    private String time;
    private String firstSession;
    private String secondSession;
    private int units;
    private int capacity;


    /**
     * set capacity of class
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * set first session of class
     * @param firstSession
     */
    public void setFirstSession(String firstSession) {
        this.firstSession = firstSession;
    }

    /**
     * set name of course
     * @param nameField
     */
    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    /**
     * set second session of class
     * @param secondSession
     */
    public void setSecondSession(String secondSession) {
        this.secondSession = secondSession;
    }

    /**
     * set teacher od class
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * set time of course
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * set units of course
     * @param units
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * get the name of course
     * @return string
     */
    public String getName() {
        return nameField;
    }

    /**
     * get first session
     * @return string
     */
    public String getFirstSession() {
        return firstSession;
    }

    /**
     * get second session
     * @return string
     */
    public String getSecondSession() {
        return secondSession;
    }

    /**
     * get tne name of teacher of this course
     * @return string
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * get time of course
     * @return string
     */
    public String getTime() {
        return time;
    }

    /**
     * get units of course
     * @return int
     */
    public int getUnits() {
        return units;
    }

    /**
     * get capacity of course
     * @return int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * add a student to course
     * @param student
     */
    public void addStudent(Student student){
        students.add(student);
    }

    /**
     * get student of this course
     * @return Array list of students
     */
    public ArrayList<Student> getStudents(){
        return students;
    }
}


