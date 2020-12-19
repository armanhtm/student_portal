import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private String teacher;
    private String nameField;
    private String time;
    private String firstSession;
    private String secondSession;
    private int units;
    private int capacity;
    /*
    public Course(){
        this.name = name;
        this.teacher = teacher;
        this.capacity = capacity;
        this.unit = unit;
    }
    public boolean addStudent(Student student){
        if(capacity == students.size())
            return false;
        students.add(student);
        return true;
    }
    public boolean setTime(int startTime,int finishTime){
        if(startTime > 8 || finishTime < 16)
            if(startTime % 2 == 0 && finishTime % 2 == 0)
                if(finishTime - startTime == 2 && finishTime != 2) {
                    this.startTime = startTime;
                    this.finishTime = finishTime;
                    return true;
                }
        return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public boolean searchStudent(Student student){
        if(students.contains(student))
            return true;
        return false;
    }

    public int getUnit() {
        return unit;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime()
}
     */

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFirstSession(String firstSession) {
        this.firstSession = firstSession;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public void setSecondSession(String secondSession) {
        this.secondSession = secondSession;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public String getFirstSession() {
        return firstSession;
    }

    public String getSecondSession() {
        return secondSession;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTime() {
        return time;
    }

    public int getUnits() {
        return units;
    }

    public int getCapacity() {
        return capacity;
    }
}


