public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 22, 23, 38, 45, 67, 89};
        int target = 22;
        if (binarySearch(arr, target)) {
            System.out.println("We have it");
        } else {
            System.out.println("We don't");
        }
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}