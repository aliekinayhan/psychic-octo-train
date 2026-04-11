import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 1, 9, 2, 6, 5, 4, 0};
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            int largestIndex = 0;

            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[largestIndex]) {
                    largestIndex = j;
                }
            }

            int temp = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = numbers[largestIndex];
            numbers[largestIndex] = temp;
        }

        System.out.println(Arrays.toString(numbers));
    }
}