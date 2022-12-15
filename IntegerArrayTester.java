package labs.lab2;

public class IntegerArrayTester {
    public static void main(String[] args) {
        IntegerArray array1 = new IntegerArray("1");
        IntegerArray array2 = new IntegerArray("1");

        System.out.println(array1.LID());
        System.out.println(array2.LID());

        System.out.println(array1.MID());
        System.out.println(array2.MID());

        System.out.println(array2.compareTo(array1));
        System.out.println(array1.getDigit(0));

        System.out.println(array1.add(array2).toString());
        System.out.println(array1.subtrackIntegerArray(array2).toString());

        System.out.println(array1.numberOfDigits());
    }
}
