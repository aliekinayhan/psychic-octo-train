import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 1, 9, 2, 6, 5, 4, 0};
        int control = numbers.length;
        int temp = 0;
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < control; i++) {
            for (int j = 0; j < control - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}