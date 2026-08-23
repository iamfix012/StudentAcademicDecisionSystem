package studentacademicdecisionsystem;

import javax.swing.JOptionPane;

/**
 * Group ICE Task - Student Academic Decision System
 *
 * Group Members & Contributions:
 * Ovayo  - Requirement 1 (Age / Adult-Minor), Requirement 2 (Mark Validation), Exercise 1 (5-tier grading)
 * Unathi Kolweni - Requirement 3 (Attendance eligibility), Exercise 2 (Fee discount)
 * Tatum  - Requirement 4 (Academic Result), Requirement 5 (Combined Decision), Exercise 3 (Admission condition)
 * Vuyo   - Requirement 6 (Special Category), Requirement 7 (Service Menu / switch),
 *          Exercise 4 (Emergency academic support), Exercise 5 (Operator precedence)
 */

// Step 1 - Create the Class - Implemented by Group
public class StudentAcademicSystem {

    public static void main(String[] args) {

        // Step 2 - Capture Student Information - Implemented by Group
        String studentName = JOptionPane.showInputDialog("Welcome, student. Please enter your name.");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter your age."));
        String studentCategoryInput = JOptionPane.showInputDialog("Please enter your student category (e.g. Regular / International).");
        int attendance = Integer.parseInt(JOptionPane.showInputDialog("Please enter your attendance percentage (0-100)."));
        double mark = Double.parseDouble(JOptionPane.showInputDialog("Please enter your mark (0-100)."));

        // Step 3 - Display Student Information - Implemented by Group
        String details = "Name: " + studentName
                + "\nAge: " + age
                + "\nCategory: " + studentCategoryInput
                + "\nAttendance: " + attendance + "%"
                + "\nMark: " + mark;
        JOptionPane.showMessageDialog(null, details, "Student Details", JOptionPane.INFORMATION_MESSAGE);

        // Requirement 1 - Implemented by Ovayo
        // Step 4 - Age Decision: determine Adult vs Minor using if-else
        boolean isAdult;
        String ageStatus;
        if (age >= 18) {
            isAdult = true;
            ageStatus = "Adult";
        } else {
            isAdult = false;
            ageStatus = "Minor";
        }
        JOptionPane.showMessageDialog(null, "You are classified as: " + ageStatus);

        // Requirement 6 - Implemented by Vuyo
        // Step 5 - Special Category using OR (||): age < 18 OR age > 60
        boolean specialCategory = (age < 18 || age > 60);
        JOptionPane.showMessageDialog(null, "Special Category Status: " + (specialCategory ? "Yes" : "No"));

        // Requirement 2 - Implemented by Ovayo
        // Step 6 - Validate the Mark (must be between 0 and 100, using &&)
        boolean validMark = (mark >= 0 && mark <= 100);
        if (!validMark) {
            JOptionPane.showMessageDialog(null, "Invalid mark entered (" + mark + "). Mark must be between 0 and 100.\nExiting program.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Mark validation passed: " + mark + " is within range 0-100.");

        // Requirement 4 - Implemented by Tatum
        // Step 7 - Determine Academic Result (base 3-tier scale)
        // 75-100 -> Distinction | 50-74 -> Pass | 0-49 -> Fail
        String baseAcademicResult;
        if (mark >= 75 && mark <= 100) {
            baseAcademicResult = "Distinction";
        } else if (mark >= 50 && mark < 75) {
            baseAcademicResult = "Pass";
        } else {
            baseAcademicResult = "Fail";
        }
        JOptionPane.showMessageDialog(null, "Base Academic Result: " + baseAcademicResult);

        // Exercise 1 - Implemented by Ovayo
        // Refines Requirement 4 into a 5-tier grading scale (if-else-if).
        // This refined result is used later in the Service Menu.
        // 90-100 -> Excellent | 75-89 -> Very Good | 60-74 -> Good | 50-59 -> Pass | Below 50 -> Fail
        String academicResult;
        if (mark >= 90 && mark <= 100) {
            academicResult = "Excellent";
        } else if (mark >= 75 && mark <= 89) {
            academicResult = "Very Good";
        } else if (mark >= 60 && mark <= 74) {
            academicResult = "Good";
        } else if (mark >= 50 && mark <= 59) {
            academicResult = "Pass";
        } else {
            academicResult = "Fail";
        }
        JOptionPane.showMessageDialog(null, "Refined Academic Result (5-tier): " + academicResult);

        // Requirement 3 - Implemented by Unathi Kolweni
        // Attendance must be at least 75% for examination eligibility
        boolean attendanceOk = (attendance >= 75);
        JOptionPane.showMessageDialog(null, "Attendance Requirement (>=75%) Met: " + (attendanceOk ? "Yes" : "No"));

        // Requirement 5 - Implemented by Tatum
        // Step 8 - Combined Decision using AND (&&): mark >= 50 AND attendance >= 75
        boolean examEligible = (mark >= 50 && attendance >= 75);
        JOptionPane.showMessageDialog(null, "Exam Eligibility: " + (examEligible ? "Eligible" : "Not Eligible"));

        // Exercise 3 - Implemented by Tatum
        // Step 9 - Nested/Boolean Decision Making: Admission condition
        // A student may be admitted when: age >= 18 AND mark >= 50 AND attendance >= 75
        boolean admitted = (age >= 18 && mark >= 50 && attendance >= 75);
        JOptionPane.showMessageDialog(null, "Admission Decision: " + (admitted ? "Admitted" : "Not Admitted"));

        // Exercise 4 - Implemented by Vuyo
        // A student qualifies for emergency academic support if mark < 40 OR attendance < 50
        boolean supportRequired = (mark < 40 || attendance < 50);
        if (supportRequired) {
            JOptionPane.showMessageDialog(null, "Academic support required.");
        } else {
            JOptionPane.showMessageDialog(null, "Academic support not required.");
        }

        // Exercise 2 - Implemented by Unathi Kolweni
        // Fee discount decision (if-else): Special category -> 20% discount, otherwise -> 5% discount
        int feeDiscount;
        if (specialCategory) {
            feeDiscount = 20;
        } else {
            feeDiscount = 5;
        }
        JOptionPane.showMessageDialog(null, "Fee Discount Applied: " + feeDiscount + "%");

        // Exercise 5 - Implemented by Vuyo
        // Operator Precedence demonstration
        // In Java, && takes priority over ||, so "true || false && false" is evaluated
        // as "true || (false && false)", which gives true regardless of the second half.
        boolean result1 = true || false && false;

        // Adding brackets around "true || false" forces that part to be
        // evaluated first, and the outcome then depends on the && with false,
        // giving a different result: false.
        boolean result2 = (true || false) && false;

        String precedenceExplanation =
                "Without brackets, && is evaluated before ||, so the expression short-circuits to true "
                + "because the OR condition is already satisfied. Result without parentheses: " + result1
                + "With parentheses forcing the OR to be evaluated first, the outcome then depends on "
                + "the AND with false, which changes the result. Result with parentheses: " + result2
                + "This shows how operator precedence can change the final outcome of a boolean expression.";
        JOptionPane.showMessageDialog(null, precedenceExplanation, "Operator Precedence", JOptionPane.INFORMATION_MESSAGE);

        // Requirement 7 - Implemented by Vuyo
        // Step 10 - Create the Service Menu
        int choice;
        try {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "Service Menu\n"
                    + "1. Academic Results\n"
                    + "2. Attendance\n"
                    + "3. Fees\n"
                    + "4. Student Support\n"
                    + "5. Exit"));
        } catch (NumberFormatException e) {
            choice = -1; // forces the default/invalid case in the switch below
        }

        // Requirement 7 - Implemented by Vuyo
        // Step 11 - Implement switch for the Service Menu selection
        switch (choice) {
            case 1:
                JOptionPane.showMessageDialog(null, "Academic Result: " + academicResult + " (Base Result: " + baseAcademicResult + ")");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Attendance: " + attendance + "%");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Fee Discount: " + feeDiscount + "%");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Student Support: " + (supportRequired ? "Support required." : "No support needed."));
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 5.");
                break;
        }
    }
}
