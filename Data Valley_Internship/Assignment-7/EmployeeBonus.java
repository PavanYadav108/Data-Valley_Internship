import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();

        System.out.print("Enter the year when the employee joined: ");
        int joinYear = scanner.nextInt();

        int serviceYears = currentYear - joinYear;
        int bonus = 0;

        if (serviceYears > 5) {
            bonus = 5000;
        } else if (serviceYears >= 3) {
            bonus = 3000;
        } else {
            System.out.println("No bonus is awarded.");
            return;
        }

        System.out.println("Bonus of Rs. " + bonus + " is awarded.");
    }
}