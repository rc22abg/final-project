//arraylist is getting imported so that we can use resizable arrays in our code
import java.util.ArrayList;
import java.util.Scanner;

//starting the main class of our code naming it FitnessClub
public class FitnessClub {
    //starting the main methods of our code. Whole code will start running from this point
    public static void main(String[] args) {
        //making an object of scanner
        Scanner scanner = new Scanner(System.in);
        ArrayList<Lesson> lessons = new ArrayList<>();
        //adding the lesson names, available spots, day and time for the lessons
        lessons.add(new Lesson("Spin", 5, "Saturday", "9:00 AM"));
        lessons.add(new Lesson("Yoga", 5, "Saturday", "10:00 AM"));
        lessons.add(new Lesson("Bodysculpt", 5, "Saturday", "11:00 AM"));
        lessons.add(new Lesson("Zumba", 5, "Sunday", "9:00 AM"));
        lessons.add(new Lesson("Aquacise", 5, "Sunday", "10:00 AM"));
        lessons.add(new Lesson("Box Fit", 5, "Sunday", "11:00 AM"));
        ArrayList<Customer> customers = new ArrayList<>();
        //making an integer named choice which will take the initial choice of the custoer like if he/she chooses 1 it should start class for viewing time table and
        //if he/she chooses 2 then it should make a booking for the user and it continues from 1 to 4 choices
        int choice;
        do {
            //printing the choices which are to be given to the user
            //the first choice is for viewing timetable
            System.out.println("   1. View timetable");
            //second choice is for making the bookings
            System.out.println("   2. Make booking");
            //third choice is for rating the classes
            System.out.println("   3. Rate class");
            //the fourth choce is for viewing your bookings
            System.out.println("   4. View bookings");
            //the fifth choice is for exiting the application
            System.out.println("   5. Exit");
            //below line is to ask user for their choices
            System.out.print("    Enter your choice: ");
            //scanning the choices made by the user
            choice = scanner.nextInt();
            //implementing a switch case to run specific code for each choice selection
            switch (choice) {
                //if the user chose 1st choice then it will run the below case
                case 1:
                    for (Lesson lesson : lessons) {
                        //calling the display method
                        lesson.display();
                        
                        
                    }
                    break;
                //if the user chose 2nd class then it will run the below 2nd case
                case 2:
                //asking for name so that we can store the booking by the name
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    //asking for lesson name so that the booking can be made
                    System.out.print("Enter the lesson name: ");
                    String lessonName = scanner.next();
                    boolean found = false;
                    for (Lesson lesson : lessons) {
                        if (lesson.getName().equalsIgnoreCase(lessonName)) {
                            if (lesson.getAvailableSpots() > 0) {
                                lesson.book(name);
                                customers.add(new Customer(name, lesson));
                                System.out.println("Booking successful!");
                            } else {
                                System.out.println("Sorry, the lesson is fully booked.");
                            }
                            found = true;
                            break;
                        }
                    }
                    //if the found is not equals to true then it should throw an error of invalid lesson name because the name is out of the list
                    if (!found) {
                        System.out.println("Invalid lesson name.");
                    }
                    break;
                //if the user chose the 3rd choice then it should run the 3rd case
                case 3:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.next();
                    boolean customerFound = false;
                    for (Customer customer : customers) {
                        if (customer.getName().equalsIgnoreCase(customerName)) {
                            customer.getLesson().rateLesson();
                            customerFound = true;
                            break;
                        }
                    }
                    if (!customerFound) {
                        System.out.println("Invalid customer name.");
                    }
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    String custName = scanner.next();
                    boolean foundCust = false;
                    for (Customer customer : customers) {
                        if (customer.getName().equalsIgnoreCase(custName)) {
                            customer.displayBooking();
                            foundCust = true;
                            break;
                        }
                    }
                    if (!foundCust) {
                        System.out.println("Invalid customer name.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our fitness club application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 5);
        scanner.close();
    }
}

class Lesson {
    private String name;
    private int availableSpots;
    private String day;
    private String time;
    private ArrayList<String> customers = new ArrayList<>();
    private double rating;

    public Lesson(String name, int availableSpots, String day, String time) {
        this.name = name;
        this.availableSpots = availableSpots;
        this.day = day;
        this.time = time;
        this.rating = 0.0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAvailableSpots() {
        return availableSpots;
    }
    
    public void book(String customerName) {
        customers.add(customerName);
        availableSpots--;
    }
    
    public void rateLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How would you rate the lesson on a scale of 1-5? ");
        int rating = scanner.nextInt();
        this.rating = (this.rating + rating) / customers.size();
        System.out.println("Thank you for your feedback!");
    }
    
    public void display() {
        System.out.println(     name + " on " + day + " at " + time + " (" + availableSpots + " spots available)");
    }
    
    public void displayRating() {
        System.out.println(name + " has an average rating of " + rating + " stars.");
    }
    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}

class Customer {
private String name;
private Lesson lesson;
public Customer(String name, Lesson lesson) {
    this.name = name;
    this.lesson = lesson;
}


public String getName() {
    return name;
}

//this will return the lesson
public Lesson getLesson() {
    return lesson;
}

//this below method is the displaybooking method which will display the booking of the user
public void displayBooking() {
    System.out.println(name + " has booked " + lesson.getName() + " on " + lesson.getDay() + " at " + lesson.getTime() + ".");
}
}

//this below is the review class
class Review {
private Lesson lesson;
private int rating;
public Review(Lesson lesson, int rating) {
    this.lesson = lesson;
    this.rating = rating;
}

//this will return the lesson 
public Lesson getLesson() {
    return lesson;
}
//this will return the rating of the customer
public int getRating() {
    return rating;
}
}
