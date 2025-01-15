package twentyfour.fall.oop.group2.finalproject;
/**
 * Id: M23W0573
 * Name:Yeung Lai
 * Assignment: KCGI/OOP
 * Final project - Fitness Tracking System
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String PATH = "./";  //should refer to the current working directory of the program
//    public static final String PATH = "src/twentyfour/fall/oop/group2/finalproject/";
    private static List<User> users = new ArrayList<>();
    private static List<Meal> meals = new ArrayList<>();
    private static List<Activity> activities = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private static User currentUser;

    public static void main(String[] args) {
        loadData();
        while (running) {
            showMainMenu();
        }
    }

    //Main Menu
    private static void showMainMenu(){
        System.out.println("\n===== Welcome to Fitness Tracking System =====");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                displayLoginMenu();
                break;
            case 2:
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    //Login Menu
    // ADMIN: username: admin, adminpass
    // TRAINER: username: trainer, trainerpass
    // USER: username: test, test
    private static void displayLoginMenu() {
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Logged in successfully!");
                    currentUser = user;
                    navigate();
                    return;
                }
            }
            System.out.println("Invalid username or password! Please try again.");
        }
    }

    //Navigate base on Role
    private static void navigate() {
        switch (currentUser.getRole()) {
            case "TRAINER":
                displayTrainerMenu();
                break;
            case "ADMIN":
                displayAdminMenu();
                break;
            case "USER":
                displayUserMenu();
                break;
            default:
                System.out.println("Unknown role. Please check the user configuration.");
                break;
        }
    }

    // Invalid choice
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
            return -1;
        }
    }

    // User menu
    private static void displayUserMenu() {
        System.out.println("\n===== User =====");
        System.out.println("Logged user: "+currentUser.getUsername());
        System.out.println("1. Log Meal");
        System.out.println("2. Log Activity");
        System.out.println("3. Generate Report");
        System.out.println("4. Save and Exit");
        System.out.print("Enter your choice: ");
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                logMeal();
                break;
            case 2:
                logActivity();
                break;
            case 3:
                generateReport();
                break;
            case 4:
                currentUser = null;
                System.out.println("Data saved and Logged out.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                navigate();
        }
    }

    // Trainer menu
    private static void displayTrainerMenu() {
        System.out.println("\n===== Trainer =====");
        System.out.println("Logged user: "+currentUser.getUsername());
        System.out.println("1. Generate Report");
        System.out.println("2. Save and Exit");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice();
        switch (choice) {
            case 1 :
                generateTrainerOrAdminReport();
            case 2 : {
                currentUser = null;
                System.out.println("Data saved and Logged out.");
                break;
            }
            default : System.out.println("Invalid choice. Please try again.");
            navigate();
        }
    }

    // Admin menu
    private static void displayAdminMenu() {
        System.out.println("\n===== Admin =====");
        System.out.println("Logged user: "+currentUser.getUsername());

        System.out.println("1. Create new user");
        System.out.println("2. Generate Report");
        System.out.println("3. Save and Exit");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                createNewUser();
                break;
            case 2:
                generateTrainerOrAdminReport();
                break;
            case 3:
                FileIO.saveUsers(users, PATH + "users.txt");
                System.out.println("Data saved and Logged out.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void createNewUser() {
        System.out.println("\n===== Create new user =====");
        System.out.println("Create username:");
        String username = scanner.nextLine();

        System.out.println("Create password:");
        String password = scanner.nextLine();

        System.out.println("Enter role (USER, TRAINER, ADMIN)");
        String role = scanner.nextLine().toUpperCase();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter sex (Male/Female): ");
        String sex = scanner.nextLine();

        System.out.print("Enter weight (kg): ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter height (cm): ");
        double height = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter goal for daily calorie intake: ");
        int goalIntake = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter goal for daily calorie burning: ");
        int goalBurn = Integer.parseInt(scanner.nextLine());

        User newUser = new User(username, password, role, age, sex, weight, height, goalIntake, goalBurn);

        users.add(newUser);

        FileIO.saveUsers(users, "users.txt");
        System.out.println("New user created successfully!");
        navigate();
    }

    private static void logMeal() {
        System.out.print("Enter meal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter calories: ");
        int calories = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter date and time (YYYY-MM-DD HH:mm): ");
        String dateTime = scanner.nextLine();

        // Add meal to the list
        meals.add(new Meal(currentUser.getUsername(), name, calories, dateTime));
        System.out.println("Meal logged successfully!");

        String currentDate = dateTime.split(" ")[0];

        // Calculate total calories consumed for the day
        int totalCaloriesConsumedDaily = meals.stream()
                .filter(meal -> meal.getUsername().equals(currentUser.getUsername())) // Filter meals for the current user
                .filter(meal -> meal.getDateTime().startsWith(currentDate))           // Filter meals for the same day
                .mapToInt(Meal::getCalories)
                .sum();

        // Calculate remaining calories
        int remainingCal = currentUser.getGoalIntake() - totalCaloriesConsumedDaily;

        // Display status
        if (remainingCal > 0) {
            System.out.println("You have consumed a total of " + totalCaloriesConsumedDaily + " kcal today.");
            System.out.println("You have " + remainingCal + " kcal left to reach your daily intake goal.");
        } else if (remainingCal == 0) {
            System.out.println("You have consumed exactly " + totalCaloriesConsumedDaily + " kcal and hit your daily intake goal!");
        } else {
            System.out.println("You have exceeded your daily intake goal by " + Math.abs(remainingCal) + " kcal!");
        }

        FileIO.saveMeals(meals, PATH + "meals.txt");
        navigate();
    }

    private static void logActivity() {
        System.out.println("Available activities: Running, Swimming, Walking, Cycling");
        System.out.print("Enter activity type: ");
        String type = scanner.nextLine();
        System.out.print("Enter duration (minutes): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter date and time (YYYY-MM-DD HH:mm): ");
        String dateTime = scanner.nextLine();

        Activity activity = new Activity(currentUser.getUsername(), type, duration, dateTime);
        activities.add(activity);

        System.out.println("Activity logged successfully!");
        System.out.println("Calories burned: " + activity.getCaloriesBurned() + " kcal");

        // Total calories burned per day
        double totalCaloriesBurnedDaily = activities.stream()
                .filter(a -> a.getUsername().equals(currentUser.getUsername()))
                .mapToDouble(Activity::getCaloriesBurned)
                .sum();
        // Calculate remaining calories
        double remainingCalToBurn = currentUser.getGoalBurn() - totalCaloriesBurnedDaily;
        if (remainingCalToBurn > 0) {
            System.out.println("You have " + remainingCalToBurn + " kcal left to reach your daily burn goal.");
        } else if (remainingCalToBurn == 0) {
            System.out.println("You have hit your daily burn goal!");
        } else {
            System.out.println("You have exceeded your daily burn goal by " + Math.abs(remainingCalToBurn) + " kcal!");
        }

        FileIO.saveActivities(activities, PATH+"activities.txt");
        navigate();
    }

    private static void generateReport() {
        ReportService.generateReport(currentUser, currentUser.getUsername(), users, meals, activities);
        navigate();
    }

    private static void generateTrainerOrAdminReport() {
        System.out.print("Enter username to generate a report (or type 'all' for all users): ");
        String targetUsername = scanner.nextLine();
        ReportService.generateReport(currentUser, targetUsername, users, meals, activities);
        navigate();
    }

    private static void loadData() {
        users = FileIO.loadUsers(PATH+"users.txt");
        meals = FileIO.loadMeals(PATH+"meals.txt");
        activities = FileIO.loadActivities(PATH+"activities.txt");
    }
}
