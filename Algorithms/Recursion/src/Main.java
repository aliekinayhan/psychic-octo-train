import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        System.out.println(factorial(6));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(8));
        System.out.println(reverseString("hello"));

    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);

    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return  fibonacci(n-1)+fibonacci(n-2);
    }
    public static String reverseString(String txt) {
       if (txt.isEmpty()) {
           return "";
       }
        return reverseString(txt.substring(1)) + txt.charAt(0);
    }

}