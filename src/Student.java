import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Student implements Serializable {
    private String name;
    private String password;
    private double credit;
    private double average;
    private List listCourses;
    private List listFoods;
    private List listSelectedFoods;
    private List listSelectedCourses;
    private int unitsCounter = 0;
    private ArrayList<ArrayList>selectedCourses ;
    private ArrayList<ArrayList>selectedFoods ;
    private ArrayList<ArrayList>courses ;
    private ArrayList<ArrayList>foods ;
    public Student(){
        foods = new ArrayList<>();
        courses = new ArrayList<>();
        String[] tempListCourses = new String[]{"teacher","name","time"
                ,"first session","second session","capacity","units","check"};
        String[] tempListFoods = new String[]{"name", "day", "cost", "capacity", "check"};
        listCourses = new List(tempListCourses,courses);
        String[] tempListSelectedCourses = new String[]{"teacher","name","time"
                ,"first session","second session","units","grade"};
        String[] tempListSelectedFoods = new String[]{"name", "day", "cost", "capacity", "check"};
        listSelectedCourses = new List(tempListSelectedCourses,selectedCourses);
        listSelectedFoods = new List(tempListSelectedFoods,selectedFoods);
    }

    public String getName() {
        return name;
    }
    //public boolean addCourse(){
       // Course course = display.addCourse();
        //if(average < 17 && unitsCounter + course.getUnit() > 20)
                //return false;
        //if(average > 17 && unitsCounter + course.getUnit() > 24)
                //return false;
       // for(Course course1 : courses.keySet())
          //  if(course1.getTime().equals(course.getTime()))
             //   return false;
        //unitsCounter += course.getUnit();
        //courses.put(course,0);
        //return true;
    //}

    //public HashMap<Course, Integer> getCourses() {
      //  return courses;
    //}
    //public void setAverage(){
      //  average = 0;
        //for(Course course : courses.keySet())
          //  average += courses.get(course);
        //average /= unitsCounter;
    //}

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    public int numberOfUnits(){
        return 0;
       // int units = 0;
        //for(Course course : courses.keySet())
          //  units += course.getUnit();
        //return units;
    }

    public double getAverage() {
        return average;
    }
    public boolean addCredit(int amount){
        if(amount > 0) {
            this.credit += amount;
            return true;
        }
        return false;
    }
    public boolean subCredit(int cost){
        if(cost > this.credit)
            return false;
        this.credit -= cost;
        return true;
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
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCourses(ArrayList<ArrayList> Courses) {
        this.courses = Courses;
    }

    public void setFoods(List Foods) {
        this.listFoods = Foods;
    }

    public List getListCourses() {
        return listCourses;
    }

    public List getListFoods() {
        return listFoods;
    }

    public List getListSelectedCourses() {
        return listSelectedCourses;
    }

    public List getListSelectedFoods() {
        return listSelectedFoods;
    }
}
