// LambdaSummer.java
// D. Singletary
// 5/1/20
// Implement an addition interface method using a lambda expression

import java.io.*;  
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

interface ArraySummer {
    // sum method sums an array of integers
    public int summer(Integer[] array);
}

public class LambdaSummer {

    public static void main(String[] args) {
        // test data
        Integer[] testArray = { 1, 3, 5, 7, 9 };
        
        // declare ArraySummer lambda expression
        ArraySummer as = (array) -> 
        {
            int sum = 0;
            for (Integer i : array)
                sum += i;
            return sum;
        };

        // use java.util.Arrays.toString to cleanly print the Integer test data
        System.out.println("The sum of " + java.util.Arrays.toString(testArray) + 
                " is " + as.summer(testArray));
           
        // now read in a list of values from a CSV file and add them     
        ArrayList<String> list = CSVReader.readCSV("integers.csv");
        testArray = NumberCollection.toIntegerArray(list);
        System.out.println("The sum of " + java.util.Arrays.toString(testArray) + 
                " is " + as.summer(testArray));            
    }
}

 
class CSVReader {
    // read tokens from a CSV file
    public static ArrayList<String> readCSV(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        String token = "";
        
        try {
            Scanner sc = new Scanner(new File(fileName));  
            sc.useDelimiter(",");    
            while (sc.hasNext()) {
                token = sc.next();
                list.add(token);
            }
            sc.close();
        } catch(Exception e) {}
        
        return list;
    }  
}

class NumberCollection {
    public static Integer[] toIntegerArray(ArrayList<String> sList) {
        int size = sList.size();
        Integer[] iArray = new Integer[size];
        int index = 0;
        
        for (String s : sList) {
            try {
                iArray[index++] = Integer.parseInt(s);
            } catch(NumberFormatException nfe) {
                System.err.println("Parsing failed for s");
            }
        }
            
        return iArray;
    }
}