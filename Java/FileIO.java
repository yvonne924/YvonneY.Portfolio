package twentyfour.fall.oop.group2.finalproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    // Save Users to File
    public static void saveUsers(List<User> users, String filename) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            String userToString =
                    user.getUsername() + "," +
                            user.getPassword() + "," +
                            user.getRole() + "," +
                            user.getAge() + "," +
                            user.getSex() + "," +
                            user.getWeight() + "," +
                            user.getHeight() + "," +
                            user.getGoalIntake() + "," +
                            user.getGoalBurn();
            sb.append(userToString).append(System.lineSeparator());
        }
        writeToFile(filename, sb.toString());
    }

    // Save Meals to File
    public static void saveMeals(List<Meal> meals, String filename) {
        StringBuilder sb = new StringBuilder();
        for (Meal meal : meals) {
            String mealToString =
                    meal.getUsername() + "," +
                            meal.getMealName() + "," +
                            meal.getCalories() + "," +
                            meal.getDateTime();
            sb.append(mealToString).append(System.lineSeparator());
        }
        writeToFile(filename, sb.toString());
    }

    // Save Activities to File
    public static void saveActivities(List<Activity> activities, String filename) {
        StringBuilder sb = new StringBuilder();
        for (Activity activity : activities) {
            String activityToString =
                    activity.getUsername() + "," +
                            activity.getActivityType() + "," +
                            activity.getDuration() + "," +
                            activity.getCaloriesBurned() + "," +
                            activity.getDateTime();
            sb.append(activityToString).append(System.lineSeparator());
        }
        writeToFile(filename, sb.toString());
    }

    // Load Users from File
    public static List<User> loadUsers(String filename) {
        List<User> users = new ArrayList<>();
        String content = readFromFile(filename);
        String[] lines = content.split(System.lineSeparator());

        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                try {
                    User user = new User(
                            parts[0], // username
                            parts[1], // password
                            parts[2], // role
                            Integer.parseInt(parts[3]), // age
                            parts[4], // sex
                            Double.parseDouble(parts[5]), // weight
                            Double.parseDouble(parts[6]), // height
                            Integer.parseInt(parts[7]), // goalIntake
                            Integer.parseInt(parts[8])  // goalBurn
                    );
                    users.add(user);
                } catch (Exception e) {
                    System.out.println("Error parsing user data: " + line + " -> " + e.getMessage());
                }
            }
        }
        return users;
    }

    // Load Meals from File
    public static List<Meal> loadMeals(String filename) {
        List<Meal> meals = new ArrayList<>();
        String content = readFromFile(filename);
        String[] lines = content.split(System.lineSeparator());

        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                try {
                    Meal meal = new Meal(
                            parts[0],  // username
                            parts[1],  // mealName
                            Integer.parseInt(parts[2]), // calories
                            parts[3]   // dateTime
                    );
                    meals.add(meal);
                } catch (Exception e) {
                    System.out.println("Error parsing meal data: " + line + " -> " + e.getMessage());
                }
            }
        }
        return meals;
    }

    // Load Activities from File
    public static List<Activity> loadActivities(String filename) {
        List<Activity> activities = new ArrayList<>();
        String content = readFromFile(filename);
        String[] lines = content.split(System.lineSeparator());

        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                try {
                    Activity activity = new Activity(
                            parts[0],   // username
                            parts[1],   // activityType
                            Integer.parseInt(parts[2]), // duration
                            parts[4]    // dateTime
                    );
                    activities.add(activity);
                } catch (Exception e) {
                    System.out.println("Error parsing activity data: " + line + " -> " + e.getMessage());
                }
            }
        }
        return activities;
    }

    // Write Content to File
    private static void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename + " -> " + e.getMessage());
        }
    }

    // Read Content from File
    private static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename + " -> " + e.getMessage());
        }
        return content.toString();
    }
}
