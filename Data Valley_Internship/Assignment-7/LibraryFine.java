import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days late: ");
        int daysLate = scanner.nextInt();
        double fine = 0;
        if (daysLate > 0 && daysLate <= 7) {
            fine = 0.5 * daysLate;
        } else if (daysLate > 7 && daysLate <= 14) {
            fine = 1 * daysLate;
        } else if (daysLate > 14) {
            fine = 5 * daysLate;
        }
        if (daysLate > 21) {
            System.out.println("Your library membership has been cancelled.");
        }
        System.out.printf("The fine for returning the book late is: Rs. %.2f%n", fine);
    }
}