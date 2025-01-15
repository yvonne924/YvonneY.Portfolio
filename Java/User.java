package twentyfour.fall.oop.group2.finalproject;

public class User {
    private String username;
    private String password;
    private String role; // this represents user's role in the system ("USER", "TRAINER", "ADMIN")
    private int age;
    private String sex;
    private double weight;
    private double height;
    private int goalIntake;
    private int goalBurn;

    public User(String username, String password, String role, int age,String sex, double weight, double height, int goalIntake,int goalBurn) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.goalIntake = goalIntake;
        this.goalBurn = goalBurn;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public int getAge() { return age; }
    public String getSex() { return sex;}
    public double getWeight() { return weight; }
    public double getHeight() { return height; }
    public int getGoalIntake() {return goalIntake; }
    public int getGoalBurn() {return goalBurn; }

}
