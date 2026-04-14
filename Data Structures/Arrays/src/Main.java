import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ===== STATIC ARRAY =====
        int[] staticArr = {1, 2, 3, 4, 5};
        int[] staticArr2 = {1, 2, 3, 4, 5, 6};


        // ===== DYNAMIC ARRAY (ArrayList) =====
        ArrayList<Integer> dynArr = new ArrayList<>();

        // Add to end — O(1)
        dynArr.add(1);
        dynArr.add(2);
        dynArr.add(3);

        // Add to index — O(n)
        dynArr.add(1, 99); // index 1'e ekle

        // Get — O(1)
        System.out.println(dynArr.get(0)); // 1

        // Update — O(1)
        dynArr.set(0, 55);

        // Remove by index — O(n)
        dynArr.remove(0);

        // Size
        System.out.println(dynArr.size());

        // Contains — O(n)
        System.out.println(dynArr.contains(99)); // true

        // Loop
        for (int num : dynArr) {
            System.out.print(num + " ");
        }

        System.out.println("****************************");
        System.out.println(reverseString("Hi my name is Ali"));
        System.out.println("****************************");
        System.out.println(mergeArray(staticArr, staticArr2));
    }

    public static String reverseString(String txt) {
        char[] arr = new char[txt.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = txt.charAt(txt.length() - i - 1);
        }
        return new String(arr);
    }

    public static String mergeArray(int[] nums1, int[] nums2) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i]<nums2[j]){
                numbers.add(nums1[i++]);
            }else{
                numbers.add(nums2[j++]);
            }
            while (i < nums1.length) {
                numbers.add(nums1[i++]);
            }

            while (j < nums2.length) {
                numbers.add(nums2[j++]);
            }
        }
        return numbers.toString();
    }

}


