package labs.lab2;


public class IntegerArray implements Comparable<IntegerArray>{
    private int[] digits;
    private String number;
    private boolean isNegative = false;
    private boolean isSubstract = false;


    public IntegerArray(String intFile){
        if(isNegative){
            intFile = "-" + intFile;
        }
        if(isNegative ||String.valueOf(intFile.charAt(0)).equals("-")){
            isNegative = true;
            intFile = intFile.substring(1,intFile.length());
        }
        number = intFile;
        short b = 0;
        while(String.valueOf(intFile.charAt(b)).equals("0")){
            intFile = intFile.substring(b+1, intFile.length());
            number = intFile;
        }

        digits = new int[intFile.length()];
        for(short a = 0; a < intFile.length();a++){
            digits[a] = Integer.parseInt(String.valueOf(intFile.charAt(a)));
        }
        if(isNegative){
            number = "-" + number;
        }
    }
    public IntegerArray(){
    }

    public void setNegative(boolean n){
        if(n){
            isNegative = true;
        }
    }
    public int numberOfDigits(){return digits.length;}
    public int MID(){return digits[0];}
    public int LID(){return digits[digits.length - 1];}
    public int getDigit(int index){
        index = digits.length - index - 1;
        if(index == digits.length-1){return LID();}
        return digits[index];
    }
    public void createIntegerArray(int[] arr){
        digits = arr;
        number = "";
        for(int a = 0; a < digits.length; a++){
            number = number + digits[a];
        }
        if(isNegative){
            number = "-" + number;
        }
    }
    public IntegerArray add(IntegerArray otherIntegerArray){

        /**
         * start adding from lenght-1 
         * take modulo of the addition and store the remainder in a varible
         * make a array that is lenght + 1 of the longer array
         * make the modulo the lenght -1 th of the new array
         */


        /**
         * in substract if the bigger number's digit is smaller 
         * than it will take 1 from before and make the current one +10
         */
        int max = this.numberOfDigits();
        //IntegerArray maxInt = this;
        if(otherIntegerArray.numberOfDigits() > this.numberOfDigits()){
            max = otherIntegerArray.numberOfDigits();
        //    maxInt = otherIntegerArray;
        }
        int[] newArray = new int[max + 1];

        int remainder = 0;
        int temp;
        for(int a = 0;a < max;a++){
            if(this.digits.length > a && otherIntegerArray.digits.length > a){
                temp = this.digits[this.digits.length - a -1] + otherIntegerArray.digits[otherIntegerArray.digits.length - a -1] + remainder;
                if(temp < 0){
                    temp +=10;
                    this.digits[this.digits.length -a -2] -=1;
                }
                remainder = temp / 10;
                temp %= 10;
                newArray[max - a] = temp;
            }
            else{
                if(this.numberOfDigits() > a){
                    temp = this.digits[this.digits.length - a -1] + remainder;
                    remainder = temp / 10;
                    temp %= 10;
                    newArray[max - a] = temp;
                }
                else{
                    temp = otherIntegerArray.digits[otherIntegerArray.digits.length - a -1] + remainder;
                    remainder = temp / 10;
                    temp %= 10;
                    newArray[max - a] = temp;
                }
            } 
        }
        if(remainder != 0){
            newArray[0] = remainder;
        }
        IntegerArray tempIntegerArray = new IntegerArray();
        if(this.compareTo(otherIntegerArray) == -1 && isSubstract){
            tempIntegerArray.setNegative(true);
        }
        tempIntegerArray.createIntegerArray(newArray);
        return tempIntegerArray;
    }
    public IntegerArray subtrackIntegerArray(IntegerArray otherIntegerArray){
        isSubstract = true;

        if(this.compareTo(otherIntegerArray) == 1){
            for(int a = 0; a < otherIntegerArray.numberOfDigits(); a++){
                otherIntegerArray.digits[a] = -otherIntegerArray.digits[a];
            }
            return this.add(otherIntegerArray);
        }
        else{
            if(this.compareTo(otherIntegerArray)  == -1){
                for(int a = 0; a < this.numberOfDigits(); a++){
                    this.digits[a] = -this.digits[a];
                }
                return otherIntegerArray.add(this);
            }
            for(int a = 0; a < otherIntegerArray.numberOfDigits(); a++){
                otherIntegerArray.digits[a] = -otherIntegerArray.digits[a];
            }
            return this.add(otherIntegerArray);
        }
    }
    public int compareTo(IntegerArray obj){
        if(this.numberOfDigits() == obj.numberOfDigits()){
            int a = 0;
            while(!(this.digits[a] > obj.digits[a]) && !(this.digits[a] < obj.digits[a]) && a < this.digits.length - 1){
                a++;
            }
            if(a == this.digits.length){return 0;}
            else if(this.digits[a] > obj.digits[a]){return 1;}
            else if(this.digits[a] < obj.digits[a]){return -1;}
        }
        if(this.digits.length > obj.digits.length){return 1;}
        return -1;
    }
    public String toString(){
        return number;
    }
}
