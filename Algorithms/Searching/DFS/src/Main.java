import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
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
        System.out.println(tree.traverseInOrder(tree.root,list));
        System.out.println(tree.traversePostOrder(tree.root,list2));
        System.out.println(tree.traversePreOrder(tree.root,list3));
    }
}