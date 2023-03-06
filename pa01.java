import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class pa01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyFileInput = new Scanner(System.in);
        String keyFileName = keyFileInput.next();
        Scanner plaintextFileInput = new Scanner(System.in);
        String plaintextFileName = plaintextFileInput.next();
        File inputFile = new File(plaintextFileName);

        // Create a Scanner object to read from the text file
        Scanner scanner = new Scanner(inputFile);

        // Use a StringBuilder to accumulate only the alphabetical characters
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (char c : line.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    builder.append(c);
                }
            }
        }
        scanner.close();

        // Convert the StringBuilder to a char array
        char[] charArray = builder.toString().toLowerCase().toCharArray();

        // Print the char array
        System.out.println(charArray);
    }
}
