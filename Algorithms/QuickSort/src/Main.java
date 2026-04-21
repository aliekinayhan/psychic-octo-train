import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 5};
        // controller
        int pivot = arr[arr.length - 1];
        // pointer
        int i = -1;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        System.out.println(Arrays.toString(arr));
        System.out.println("i = " + i);
        int[] arr2 = {3, 7, 2, 5};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        System.out.println("*********************************");
        int[][] tests = {
                {8, 3, 1, 5, 2, 7, 4, 6},
                {-3, 0, -1, 5, 2},
                {1},
                {2, 1}
        };

        for (int[] t : tests) {
            quickSort(t, 0, t.length - 1);
            System.out.println(Arrays.toString(t));
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1); // sol
        quickSort(arr, pivotIndex + 1, high); // sağ
    }
}