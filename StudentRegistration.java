import java.util.Scanner;

class Student {
    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to check eligibility
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    // Method to calculate total course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    // Method to calculate scholarship amount
    public double calculateScholarship() {
        double totalFee = calculateFee();
        if (this.marks >= 85) {
            return totalFee * 0.20; // 20% scholarship
        } else if (this.marks >= 70) {
            return totalFee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after deducting scholarship
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display student and fee details
    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility Status: Eligible");
        System.out.println("Total Course Fee: Rs. " + calculateFee());
        System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
        System.out.println("Final Fee Payable: Rs. " + calculateFinalFee());
    }
}

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading student details
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        // Creating Student object using parameterized constructor
        Student student = new Student(name, rollNumber, marks, courseName, courseCredits);

        // Checking eligibility and executing registration process
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent " + name + " (Roll No: " + rollNumber + ") is NOT eligible for course registration. Minimum required marks: 50.");
        }

        scanner.close();
    }
}