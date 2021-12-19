package org.example.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        readFromFile();
    }


    public static void readFromFile() {
        int sumNumber = 1;
        int previousSum = 0;
        int currentSum = 0;
        int numberOfIncreases = 0;
        try {
            String previousLine;
            String currentLine = "";
            String previousPreviousLine;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/org/example/Day1/file"));
            bufferedReader.mark(20);

            while (currentLine!=null) {
                bufferedReader.reset();
                previousPreviousLine = bufferedReader.readLine();
                bufferedReader.mark(20);
                previousLine = bufferedReader.readLine();
                System.out.println("previous previous line: " + previousPreviousLine);
                System.out.println("previous line: " + previousLine);
                currentLine = bufferedReader.readLine();
                System.out.println("current line: " + currentLine);
                if(sumNumber==1) {
                    previousSum = Integer.parseInt(previousPreviousLine) + Integer.parseInt(previousLine) + Integer.parseInt(currentLine);
                    sumNumber++;
                } else{
                    currentSum = Integer.parseInt(previousPreviousLine) + Integer.parseInt(previousLine) + Integer.parseInt(currentLine);
                    sumNumber = 1;
                }
                if(currentSum> 0 && currentSum>previousSum){
                    numberOfIncreases++;
                }
                if(bufferedReader.readLine()==null){
                    break;
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(numberOfIncreases);


    }
}
