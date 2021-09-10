import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/**
 * @author Arman Hatami
 * @version 1.0
 * student class for perform student logic
 */
public class Student implements Serializable {
    private String name;
    private String password;
    private double credit;
    private double average;
    private List listCourses;
    private List listFoods;
    private List listSelectedFoods ;
    private List listSelectedCourses;
    private int unitsCounter = 0;
    private ArrayList<ArrayList>selectedCourses = new ArrayList<>();
    private ArrayList<ArrayList>selectedFoods = new ArrayList<>();
    private ArrayList<ArrayList>courses = new ArrayList<>();
    private ArrayList<ArrayList>foods = new ArrayList<>();

    /**
     * constructor method
     */
    public Student(){
        String[] tempListSelectedCourses = new String[]{"teacher","name","time"
                ,"first session","second session","units","grade"};
        String[] tempListSelectedFoods = new String[]{"name", "day", "cost", "capacity", "check"};
        listSelectedCourses = new List(tempListSelectedCourses,selectedCourses);
        listSelectedFoods = new List(tempListSelectedFoods,selectedFoods);
    }

    /**
     * get name of student
     * @return name
     */
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

    /**
     * get credit of student
     * @return int
     */
    public double getCredit() {
        return credit;
    }

    /**
     * set credit of student
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     *
     * @return
     */
    public int numberOfUnits(){
        return 0;
       // int units = 0;
        //for(Course course : courses.keySet())
          //  units += course.getUnit();
        //return units;
    }

    /**
     * calculate average of grades
     * @return
     */
    public double getAverage() {
        return average;
    }

    /**
     * add credit to wallet
     * @param amount
     * @return boolean
     */
    public boolean addCredit(int amount){
        if(amount > 0) {
            this.credit += amount;
            return true;
        }
        return false;
    }

    /**
     * subtract credit of student
     * @param cost
     * @return boolean
     */
    public boolean subCredit(int cost){
        if(cost > this.credit)
            return false;
        this.credit -= cost;
        return true;
    }

    /**
     * change password of syudent
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
     * get password of student
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     * set the name of student
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set password of student
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * set available courses for student
     * @param Courses
     */
    public void setCourses(List Courses) {
        this.listCourses = Courses;
    }

    /**
     * set available foods for student
     * @param Foods
     */
    public void setFoods(List Foods) {
        this.listFoods = Foods;
    }

    /**
     * get Jtable of courses
     * @return Jtable
     */
    public List getListCourses() {
        return listCourses;
    }

    /**
     * get Jtable of foods
     * @return Jtable
     */
    public List getListFoods() {
        return listFoods;
    }

    /**
     * get selected courses
     * @return Jtable
     */
    public List getListSelectedCourses() {
        return listSelectedCourses;
    }

    /**
     * get selected foods
     * @return Jtable
     */
    public List getListSelectedFoods() {
        return listSelectedFoods;
    }

    /**
     * check if pick up a new course is valid
     * @param time
     * @param first
     * @param second
     * @return boolean
     */
    public boolean checkForNewCourse(String time,String first,String second) {
        for (ArrayList temp : selectedCourses) {
            if ((temp.get(2).equals(time) && temp.get(3).equals(first)) || (temp.get(2).equals(time) && temp.get(4).equals(second)))
                return false;
        }
        return true;
    }

    /**
     * return cost of canceled foods
     * @param cost
     */
    public void payBack(int cost){
        this.credit += cost;
    }
}
