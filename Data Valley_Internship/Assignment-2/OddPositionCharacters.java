public class OddPositionCharacters {
    public static void main(String[] args) {
        String text = "type here to search";
        
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0 && text.charAt(i) != ' ') {
                System.out.print(text.charAt(i));
            }
        }
    }
}