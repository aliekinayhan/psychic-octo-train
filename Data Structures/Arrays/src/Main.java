import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ===== STATIC ARRAY =====
        int[] staticArr = {1, 2, 3, 4, 5};

        // Lookup
        System.out.println(staticArr[2]); // 3

        // Update
        staticArr[0] = 99;
        System.out.println(staticArr[0]); // 99

        // Length
        System.out.println(staticArr.length); // 5

        // Loop
        for (int num : staticArr) {
            System.out.print(num + " ");
        }

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
    }
}