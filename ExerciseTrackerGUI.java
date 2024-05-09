/**
 * Gregorio Olivares
 * The purpose of this program is to create an Exercise Tracker GUI that will hold information such as:
 * 			-The type of work out
 * 			-Calories burned
 * 			-Name
 * 			-Extra comments
 * CPSC 24500 - Object Oriented Programming - Section 3
 * 2024-05-08
 */


package m;

// Imports 
import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * This will be the Exercise class that will be the main driver 
 * Will do the following according to the rubric:
 * 		The Exercise class defines what is common to all exercises. It has constructors, get and
		set functions, a toString function, abstract functions for getType() and
		getCaloriesBurned(), and whatever other functions you think would be helpful. It also
		implements the Comparable<Exercise> interface so that we can easily sort exercises
		by date.
 */
abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private String comment;
    private Date date;
    private int duration; // in minutes

    public Exercise(String name, String comment, String date, int duration) throws ParseException {
        this.name = name;
        this.comment = comment;
        setDate(date);
        this.duration = duration;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
        this.date = sdf.parse(date);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Abstract methods
    public abstract String getType();

    public abstract double getCaloriesBurned();

    // Implementing Comparable interface
    @Override
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }

    // ToString method
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
        return getType() + "\t" + name + "\t" + sdf.format(date) + "\t" + getCaloriesBurned();
    }
}

/**
 * The RunWalk class will have constructors as well as get the calories burned for the exercise
 */
class RunWalk extends Exercise {
    private double distance; // in miles

    public RunWalk(String name, String comment, String date, int duration, double distance) throws ParseException {
        super(name, comment, date, duration);
        this.distance = distance;
    }

    // Getter and setter for distance
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Implementing abstract methods
    @Override
    public String getType() {
        return "Run/Walk";
    }

    @Override
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }
}

/**
 * The weightlifting class will have its own constructors along with be able to generate the total calories burned
 */
class WeightLifting extends Exercise {
    private int weightLifted; // in pounds

    public WeightLifting(String name, String comment, String date, int duration, int weightLifted) throws ParseException {
        super(name, comment, date, duration);
        this.weightLifted = weightLifted;
    }

    // Getter and setter for weightLifted
    public int getWeightLifted() {
        return weightLifted;
    }

    public void setWeightLifted(int weightLifted) {
        this.weightLifted = weightLifted;
    }

    // Implementing abstract methods
    @Override
    public String getType() {
        return "Weightlifting";
    }

    @Override
    public double getCaloriesBurned() {
        return (weightLifted / getDuration()) * 50;
    }
}

/**
 * This rockclimbing class will have its own constructors and get the calories burned
 */
class RockClimbing extends Exercise {
    private int wallHeight;
    private int repetitions;

    public RockClimbing(String name, String comment, String date, int duration, int wallHeight, int repetitions) throws ParseException {
        super(name, comment, date, duration);
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }

    // Getter and setter for wallHeight and repetitions
    public int getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    // Implementing abstract methods
    @Override
    public String getType() {
        return "Rock Climbing";
    }

    @Override
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / getDuration()) * 100;
    }
}

/**
 * Will implement the compare() function that will be able to sort the list by calories burned
 */
class ExerciseCompareByCalories implements Comparator<Exercise> {
    @Override
    public int compare(Exercise e1, Exercise e2) {
        return Double.compare(e1.getCaloriesBurned(), e2.getCaloriesBurned());
    }
}

/**
 * This class will include two static functions that will tab-delimit toString 
 * representations of a list to the screen and prints the exercise with specific columns respectively 

 */
class ExerciseWriter {
    public static void writeExercisesToFile(List<Exercise> exercises, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Exercise exercise : exercises) {
                writer.println(exercise);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tabulateSummary(List<Exercise> exercises) {
        System.out.println("Type\tName\tDate\tCalories Burned");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }
}

/**
 * Main class that will be used to create the implementation of the graphical user interface (GUI)
 * Includes the login, logout, add exercise, file saver, about, and show the added exercises
 */
public class ExerciseTrackerGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton logoutButton;
    private JTextArea exerciseTextArea;
    private JButton addExerciseButton;
    private JButton saveButton;
    private JButton aboutButton;
    private JButton exitButton;
    private List<Exercise> exercises = new ArrayList<>();
    private boolean loggedIn = false;

    public ExerciseTrackerGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Exercise Tracker");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 30, 80, 20);
        frame.getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 150, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 60, 80, 20);
        frame.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 150, 20);
        frame.getContentPane().add(passwordField);

        loginButton = new JButton("Log in");
        loginButton.setBounds(280, 45, 100, 20);
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        logoutButton = new JButton("Log out");
        logoutButton.setBounds(280, 45, 100, 20);
        frame.getContentPane().add(logoutButton);
        logoutButton.setVisible(false);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        exerciseTextArea = new JTextArea();
        exerciseTextArea.setBounds(30, 100, 500, 200);
        frame.getContentPane().add(exerciseTextArea);

        addExerciseButton = new JButton("Add Exercise");
        addExerciseButton.setBounds(30, 320, 120, 30);
        frame.getContentPane().add(addExerciseButton);
        addExerciseButton.setEnabled(false);
        addExerciseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExercise();
            }
        });

        saveButton = new JButton("Save");
        saveButton.setBounds(170, 320, 80, 30);
        frame.getContentPane().add(saveButton);
        saveButton.setEnabled(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        aboutButton = new JButton("About");
        aboutButton.setBounds(270, 320, 80, 30);
        frame.getContentPane().add(aboutButton);
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAbout();
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setBounds(370, 320, 80, 30);
        frame.getContentPane().add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("healthy") && password.equals("donut")) {
            loggedIn = true;
            JOptionPane.showMessageDialog(frame, "Login successful!");
            loginButton.setVisible(false);
            logoutButton.setVisible(true);
            addExerciseButton.setEnabled(true);
            saveButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect username or password.");
        }
    }

    private void logout() {
        loggedIn = false;
        JOptionPane.showMessageDialog(frame, "Logged out successfully.");
        loginButton.setVisible(true);
        logoutButton.setVisible(false);
        addExerciseButton.setEnabled(false);
        saveButton.setEnabled(false);
    }

    private void addExercise() {
        try {
            String type = JOptionPane.showInputDialog(frame, "Enter exercise type (1. Run/Walk, 2. Weightlifting, 3. Rock Climbing):");
            String name = JOptionPane.showInputDialog(frame, "Enter name:");
            String comment = JOptionPane.showInputDialog(frame, "Enter comment:");
            String date = JOptionPane.showInputDialog(frame, "Enter date (MM/DD/YYYY):");
            int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter duration (in minutes):"));

            Exercise exercise = null;
            switch (type) {
                case "1":
                    double distance = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter distance (in miles):"));
                    exercise = new RunWalk(name, comment, date, duration, distance);
                    break;
                case "2":
                    int weightLifted = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter weight lifted (in pounds):"));
                    exercise = new WeightLifting(name, comment, date, duration, weightLifted);
                    break;
                case "3":
                    int wallHeight = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter wall height (in feet):"));
                    int repetitions = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number of repetitions:"));
                    exercise = new RockClimbing(name, comment, date, duration, wallHeight, repetitions);
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Invalid exercise type!");
                    return;
            }

            exercises.add(exercise);
            exerciseTextArea.append(exercise.toString() + "\n");
            JOptionPane.showMessageDialog(frame, "Exercise added successfully!");
        } catch (ParseException | NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Invalid input format.");
        }
    }

    private void saveToFile() {
        String filename = JOptionPane.showInputDialog(frame, "Enter file name to save:");
        ExerciseWriter.writeExercisesToFile(exercises, filename);
        JOptionPane.showMessageDialog(frame, "Exercises saved to file: " + filename);
    }

    private void displayAbout() {
        JOptionPane.showMessageDialog(frame, "Exercise Tracker, Spring 2024");
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ExerciseTrackerGUI window = new ExerciseTrackerGUI();
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
