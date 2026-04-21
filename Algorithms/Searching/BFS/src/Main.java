import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        tree.insert(19);
        tree.insert(14);
        tree.insert(2);
        tree.insert(1);
        tree.insert(60);

        System.out.println(tree.root.value);
        System.out.println(tree.root.left.value); // 4
        System.out.println(tree.root.right.value); // 20
        System.out.println("000000000000000000000000000000");
        tree.bfs();
        if (tree.contains(4)){
            System.out.println("We have it");
        }else {
            System.out.println("We don't");
        }
        System.out.println(tree.level());
        System.out.println(tree.leaf());
    }


}