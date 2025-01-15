package twentyfour.fall.oop.group2.finalproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportService {

    // Generate reports based on user role
    public static void generateReport(User currentUser, String targetUsername, List<User> users, List<Meal> meals, List<Activity> activities) {
        if (currentUser.getRole().equals("USER")) {
            // Regular users can only generate their own reports
            generateUserReport(currentUser, meals, activities);
        } else if (currentUser.getRole().equals("TRAINER") || currentUser.getRole().equals("ADMIN")) {
            // Trainers and admins can generate reports for specific users or all users
            if (targetUsername.equalsIgnoreCase("all")) {
                generateAllUsersReport(users, meals, activities);
            } else {
                User targetUser = users.stream()
                        .filter(user -> user.getUsername().equals(targetUsername))
                        .findFirst()
                        .orElse(null);

                if (targetUser != null) {
                    generateUserReport(targetUser, meals, activities);
                } else {
                    System.out.println("User not found: " + targetUsername);
                }
            }
        }
    }

    private static void generateUserReport(User user, List<Meal> meals, List<Activity> activities) {
        System.out.println("\n===== Generate Report for " + user.getUsername() + " =====");

        // Filter meals and activities for the user
        List<Meal> userMeals = meals.stream()
                .filter(meal -> meal.getUsername().equals(user.getUsername()))
                .toList();
        List<Activity> userActivities = activities.stream()
                .filter(activity -> activity.getUsername().equals(user.getUsername()))
                .toList();

        StringBuilder report = new StringBuilder();

        // Total calories consumed and burned
        int totalCaloriesConsumed = userMeals.stream().mapToInt(Meal::getCalories).sum();
        double totalCaloriesBurned = userActivities.stream().mapToDouble(Activity::getCaloriesBurned).sum();

        report.append("Total Calories Consumed: ").append(totalCaloriesConsumed).append(" kcal\n");
        report.append("Total Calories Burned: ").append(totalCaloriesBurned).append(" kcal\n\n");

        // List of meals
        report.append("Meals:\n");
        if (userMeals.isEmpty()) {
            report.append("No meals logged.\n");
        } else {
            userMeals.forEach(meal ->
                    report.append("- ").append(meal.getMealName()).append(", ")
                            .append(meal.getCalories()).append(" kcal, logged at ")
                            .append(meal.getDateTime()).append("\n")
            );
        }

        // List of activities
        report.append("\nActivities:\n");
        if (userActivities.isEmpty()) {
            report.append("No activities logged.\n");
        } else {
            userActivities.forEach(activity ->
                    report.append("- ").append(activity.getActivityType()).append(", ")
                            .append(activity.getCaloriesBurned()).append(" kcal burned, logged at ")
                            .append(activity.getDateTime()).append("\n")
            );
        }

        // Summary for goals
        report.append("\nDaily Goal Summary:\n");
        report.append("Daily Intake Goal: ").append(user.getGoalIntake()).append(" kcal\n");
        report.append("Daily Burn Goal: ").append(user.getGoalBurn()).append(" kcal\n");

        // Display the report in the console
        System.out.println(report);

        File directory = new File("./"); // Use "./" for the current directory

        // Ensure the directory exists
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory: " + directory.getAbsolutePath());
            }
        }

        // Write the report to a new file\
//        String reportFilename = "src/twentyfour/fall/oop/group2/finalproject/" + user.getUsername() + "_report.txt";
        String reportFilename = "./" + user.getUsername() + "_report.txt";
        try (FileWriter writer = new FileWriter(reportFilename)) {
            writer.write(report.toString());
            System.out.println("Report successfully saved as: " + reportFilename);
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }

        System.out.println("\n===== End of Report for " + user.getUsername() + " =====");
    }

    // Generate a report for all users (ADMIN/TRAINER)
    private static void generateAllUsersReport(List<User> users, List<Meal> meals, List<Activity> activities) {
        System.out.println("\n===== All Users Report =====");
        List<User> regularUsers = users.stream()
                .filter(user -> user.getRole().equalsIgnoreCase("USER"))
                .toList();
        for (User user : regularUsers) {
            generateUserReport(user, meals, activities);
            System.out.println("--------------------------------------");
        }
    }
}
