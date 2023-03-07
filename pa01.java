import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*=============================================================================
| Assignment: pa01 - Encrypting a plaintext file using the Hill cipher
|
| Author: Daniel Gonzalez
| Language: c, c++, Java, go, python
|
| To Compile: javac pa01.java
| gcc -o pa01 pa01.c
| g++ -o pa01 pa01.cpp
| go build pa01.go
|
| To Execute: java -> java pa01 kX.txt pX.txt
| or c++ -> ./pa01 kX.txt pX.txt
| or c -> ./pa01 kX.txt pX.txt
| or go -> ./pa01 kX.txt pX.txt
| or python -> python3 pa01.py kX.txt pX.txt
| where kX.txt is the keytext file
| and pX.txt is plaintext file
|
| Note: All input files are simple 8 bit ASCII input
|
| Class: CIS3360 - Security in Computing - Spring 2023
| Instructor: McAlpin
| Due Date: per assignment
|
+=============================================================================*/



public class pa01 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner keyFileInput = new Scanner(System.in);
        String keyFileName = args[0];
        File keyFile = new File(keyFileName);
        Scanner keyFileScanner = new Scanner(keyFile);
        String rows = keyFileScanner.next();
        int matrixSize = Integer.parseInt(rows);
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i<matrixSize; i++){
            for (int k = 0; k<matrixSize; k++){
            String matrixString = keyFileScanner.next();
            int number = Integer.parseInt(matrixString);
            matrix[i][k] = number;
            }

        }
        System.out.println("Key matrix:");
        for (int i = 0; i<matrixSize; i++){
            for (int k = 0; k < matrixSize; k++){

                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            
                System.out.print(matrix[i][k] + " ");
                if (k == matrixSize - 1){
                    System.out.println();
                }
                
            }
        }
        System.out.println();



        //System.out.println(keyFileName);
        //Scanner plaintextFileInput = new Scanner(System.in);
        String plaintextFileName = args[1];
        //System.out.println(plaintextFileName);
        File inputFile = new File(plaintextFileName);

        // Create a Scanner object to read from the text file
        Scanner scanner = new Scanner(inputFile);

        // Use a StringBuilder to accumulate only the alphabetical characters
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (char c : line.toCharArray()) {
                if (c >= 'A' && c <= 'z') {
                    builder.append(c);
                }
            }
        }
        while ((builder.length() % matrixSize) != 0){
                builder.append('x');
            }
        
        scanner.close();

        // Convert the StringBuilder to a char array
        char[] charArray = builder.toString().toLowerCase().toCharArray();
        
        



        // Print the char array
        System.out.println("Plaintext:");
        for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
			if ((i + 1) % 80 == 0) {
				System.out.println();
			}
		}
        System.out.println();
        String cipherText = "";
        for (int i = 0; i < charArray.length; i+= matrixSize){
            int[] plainArray = new int[matrixSize];
            int[] cipherArray = new int[matrixSize];
            for (int j = 0; j < matrixSize; j++) {
				plainArray[j] = charArray[i+j] - 'a';
			}
            for (int j = 0; j<matrixSize; j++){
                for (int k = 0; k<matrixSize; k++){
                    cipherArray[j] += matrix[j][k] * plainArray[k];
                }
                cipherArray[j] %= 26;
                cipherText += (char)(cipherArray[j] + 'a');
            }
        }
        System.out.println();
        System.out.println("Ciphertext:");
        for (int i = 0; i < cipherText.length(); i++) {
			System.out.print(cipherText.charAt(i));
			if ((i + 1) % 80 == 0) {
				System.out.println();
			}
        }
        System.out.println();
    }
}
/*=============================================================================
| I Daniel Gonzalez da810538 affirm that this program is
| entirely my own work and that I have neither developed my code together with
| any another person, nor copied any code from any other person, nor permitted
| my code to be copied or otherwise used by any other person, nor have I
| copied, modified, or otherwise used programs created by others. I acknowledge
| that any violation of the above terms will be treated as academic dishonesty.
+=============================================================================*/
