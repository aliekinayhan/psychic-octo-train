import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 2, 5, 6};
        int[] arr3 = {7, 1, 5, 3, 1, 7, 9};

        // PUT — eleman ekle
        map.put("apple", 5);
        map.put("grapes", 10);
        map.put("banana", 3);

        // GET — değeri getir
        System.out.println(map.get("apple")); // 5

        // GET OR DEFAULT — yoksa default dön
        System.out.println(map.getOrDefault("orange", 0)); // 0

        // CONTAINS KEY — key var mı?
        System.out.println(map.containsKey("apple")); // true

        // CONTAINS VALUE — value var mı?
        System.out.println(map.containsValue(10)); // true

        // REMOVE — sil
        map.remove("banana");

        // SIZE
        System.out.println(map.size()); // 2

        // IS EMPTY
        System.out.println(map.isEmpty()); // false

        // KEY SET — tüm keyleri gez
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // VALUES — tüm valueleri gez
        for (int value : map.values()) {
            System.out.println(value);
        }

        // ENTRY SET — key ve value birlikte gez
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // TÜM KEYLERI BIRLESTIR
        String allKeys = "";
        for (String key : map.keySet()) {
            allKeys += key + " ";
        }
        System.out.println(allKeys); // apple grapes

        // TÜM VALUELERI TOPLA
        int total = 0;
        for (int value : map.values()) {
            total += value;
        }
        System.out.println(total); // 15

        // ===== HASHSET =====
        HashSet<String> set = new HashSet<>();

        // ADD
        set.add("apple");
        set.add("grapes");
        set.add("apple"); // tekrar — eklenmez

        // CONTAINS
        System.out.println(set.contains("apple")); // true

        // REMOVE
        set.remove("grapes");

        // SIZE
        System.out.println(set.size()); // 1

        // LOOP
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("************************");
        System.out.println(firstRepeat(arr1));
        System.out.println(firstRepeat(arr2));
        System.out.println(firstRepeat(arr3));
    }
    public static int firstRepeat (int [] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) {
                return num;
            }
        }
        return 0;
    }
}
