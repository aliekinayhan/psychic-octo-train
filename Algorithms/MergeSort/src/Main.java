import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5};
        int[] arr2 = new int[]{1, 8};
        int[] test = new int[]{3, 5, 1, 2, 4, 0, 8, 9};
        int[] test1 = {8, 3, 1, 5, 2, 7, 4, 6};
        int[] test2 = {5, 1, 9, 3, 7, 2, 8, 4, 6};
        int[] test3 = {1};           // tek eleman
        int[] test4 = {2, 1};        // iki eleman
        int[] test5 = {-3, 0, -1, 5, 2}; // negatifler

        System.out.println(Arrays.toString(mergeSort(test)));
        System.out.println(Arrays.toString(mergeSort(test1)));
        System.out.println(Arrays.toString(mergeSort(test2)));
        System.out.println(Arrays.toString(mergeSort(test3)));
        System.out.println(Arrays.toString(mergeSort(test4)));
        System.out.println(Arrays.toString(mergeSort(test5)));


        System.out.println(Arrays.toString(merge(arr, arr2)));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }
}