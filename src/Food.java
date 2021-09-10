import java.io.Serializable;
/**
 * @author Arman Hatami
 * @version 1.0
 * a class for store foods information
 */
public class Food implements Serializable {
    private String day;
    private String FoodName;
    private int cost;
    private int capacity;
    enum Meal {
        DINNER,
        LUNCH,
        BREAKFAST
    }
    private Meal meal;

    /**
     * get name of food
     * @return string name
     */
    public String getFoodName() {
        return FoodName;
    }

    /**
     * set name of food
     * @param foodName
     */
    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    /**
     * get capacity of food
     * @return int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set capacity of food
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * get meal of food
     * @return meal
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * set meal of food
     * @param meal
     */
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    /**
     * get cost of food
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     * set cost of food
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * get day of food
     * @return
     */
    public String getDay() {
        return day;
    }

    /**
     * set day of food
     * @param day
     */
    public void setDay(String day) {
        this.day = day;
    }
}
