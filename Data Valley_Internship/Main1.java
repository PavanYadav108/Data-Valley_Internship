import java.util.Scanner;

class CustomValidationException extends Exception {
    public CustomValidationException(String message) {
        super(message);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        try {
            validateNumber(number);
            System.out.println("Number is valid.");
        } catch (CustomValidationException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        scanner.close();
    }

    public static void validateNumber(int number) throws CustomValidationException {
        if (number < 0) {
            throw new CustomValidationException("Number cannot be negative");
        }
    }
}
