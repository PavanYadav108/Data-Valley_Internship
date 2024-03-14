import java.util.Scanner;

public class String_Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.print("Enter the index of the character to replace (0-based): ");
        int index = scanner.nextInt();

        if (index < 0 || index >= str.length()) {
            System.out.println("Invalid index.");
            return;
        }

        System.out.print("Enter the new character: ");
        char newChar = scanner.next().charAt(0);

        String newStr = replaceCharAtIndex(str, index, newChar);
        System.out.println("String after replacement: " + newStr);

        scanner.close();
    }

    public static String replaceCharAtIndex(String str, int index, char newChar) {
        char[] charArray = str.toCharArray();
        charArray[index] = newChar;
        return new String(charArray);
    }
}
