package labs.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayListTester extends IntegerArrayTester {

    public static IntegerArrayList readIntegerArraysFromFile(String filename){
        ArrayList<String> strings = new ArrayList<>();
        IntegerArrayList temp;
        try{
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                strings.add(line);
            }
            temp = new IntegerArrayList(strings);
            reader.close();
        }
        catch(FileNotFoundException f){
            temp = new IntegerArrayList();
            f.printStackTrace();
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter file location: ");
        IntegerArrayList tester1 = readIntegerArraysFromFile(sc.next());

        System.out.println("start index = 0 \n" + "middle index = " + (int)((tester1.getSize()-1)/2) + "\n" +  "end index = " + (tester1.getSize()-1));
        System.out.println("Minimum of all the numbers  : " + tester1.min(0,tester1.getSize()-1).toString());
        System.out.println("Minimum of the fist half  : " + tester1.min(0,(int)(tester1.getSize()-1)/2).toString());
        System.out.println("Minimum of the last half  : " + tester1.min((int)((tester1.getSize()-1)/2) + 1, tester1.getSize() - 1).toString());

        sc.close();
    }
}