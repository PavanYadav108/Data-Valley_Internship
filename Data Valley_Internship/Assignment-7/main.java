import java.util.Scanner;

public class main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine();

        int vowelCount = countVowels(str);

        if (vowelCount > 0) {
            System.out.println("The string contains " + vowelCount + " vowels.");
        } else {
            System.out.println("The string does not contain any vowels.");
        }
    }

    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ("aeiouAEIOU".indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }
}