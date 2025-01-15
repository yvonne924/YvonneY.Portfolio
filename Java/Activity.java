package twentyfour.fall.oop.group2.finalproject;

public class Activity {
    private String username;
    private String activityType;
    private int duration;
    private double caloriesBurned;
    private String dateTime;

    public Activity(String username, String activityType, int duration, String dateTime) {
        this.username = username;
        this.activityType = activityType;
        this.duration = duration;
        this.caloriesBurned = calculateCaloriesBurned(activityType, duration);
        this.dateTime = dateTime;
    }

    // Calculate calories burned
    private double calculateCaloriesBurned(String type, int duration) {
        String normalizedType = type.trim().toUpperCase(); // Normalize input to uppercase
        return switch (normalizedType) {
            case "RUNNING" -> duration * 10;       // 10 calories per minute
            case "SWIMMING" -> duration * 8.8;    // 8.8 calories per minute
            case "WALKING" -> duration * 3;       // 3 calories per minute
            case "CYCLING" -> duration * 7;       // 7 calories per minute
            default -> 0;                         // Default for unsupported activities
        };
    }

    public String getUsername() {
        return username;
    }

    public String getActivityType() {
        return activityType;
    }

    public int getDuration() {
        return duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getDateTime() {
        return dateTime;
    }
}
