public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 67, 89};
        int target = -2;
        if (linearSearch(arr,target)) {
            System.out.println("We have it");
        }else {
            System.out.println("We don't");
        }


    }
    public static boolean linearSearch(int [] arr, int target) {
        for (int j : arr) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }
}