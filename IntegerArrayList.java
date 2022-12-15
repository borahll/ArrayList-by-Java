package labs.lab2;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerArrayList {

    ArrayList<IntegerArray> numbers = new ArrayList<>();

    public IntegerArrayList(){
        System.out.println("ENTER FILE NAME CORRECT");
    }

    public IntegerArrayList(ArrayList<String> strings){
        for(int a = 0; a < strings.size(); a++){
            IntegerArray temp = new IntegerArray(strings.get(a));
            numbers.add(temp);
        }
    }

    public int getSize(){return numbers.size();}
    public IntegerArray getIntegerArrayAt(int index){
        if(index > numbers.size()){
            System.err.println("INDEX OUT OF BOUNDS ERROR");
        }
        return numbers.get(index);
    }    
    public void setIntegerArrayAt(int index, IntegerArray intArr){
        numbers.set(index, intArr);
    }
    public void addIntegerArray(String number){
        numbers.add(new IntegerArray(number));
    }
    public void removeIntegerArray(IntegerArray intArr){
        numbers.remove(intArr);
    }
    public IntegerArray min(int start, int end){
        ArrayList<IntegerArray> temp = new ArrayList<>();
        IntegerArray newArray;
        for(int a = start; a <= end; a++){
            temp.add(numbers.get(a));
        }
        Collections.sort(temp);
        newArray = temp.get(0);
        return newArray;
    }
}
