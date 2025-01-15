package twentyfour.fall.oop.group2.finalproject;

public class Meal {
    private String mealName;
    private int calories;
    private String dateTime;
    private String username;

    public Meal(String username,String mealName, int calories, String dateTime) {
        this.username = username;
        this.mealName = mealName;
        this.calories = calories;
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }
    public String getMealName() {
        return mealName;
    }
    public int getCalories() {
        return calories;
    }
    public String getDateTime() {
        return dateTime;
    }
}
