import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        // ADD — sona ekle O(1)
        list.add(10);
        list.add(20);
        list.add(30);

        // ADD FIRST — başa ekle O(1)
        list.addFirst(5);

        // ADD LAST — sona ekle O(1)
        list.addLast(40);

        // ADD by index — ortaya ekle O(n)
        list.add(2, 99);

        // GET — O(n)
        System.out.println(list.get(0)); // 5
        System.out.println(list.getFirst()); // 5
        System.out.println(list.getLast()); // 40

        // REMOVE — O(1) baştan/sondan, O(n) ortadan
        list.removeFirst();
        list.removeLast();
        list.remove(1); // index ile sil

        // SIZE
        System.out.println(list.size());

        // CONTAINS — O(n)
        System.out.println(list.contains(10)); // true

        // LOOP
        for (int num : list) {
            System.out.print(num + " ");
        }

        System.out.println(list);
    }
}