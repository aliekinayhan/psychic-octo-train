import java.util.ArrayList;

public class Tree {
    Node root;

    public void insert(int value) {
        if (root == null) {
            this.root = new Node(value);
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            }

        }
    }

    public ArrayList<Integer> DFSInOrder() {
        return traverseInOrder(root, new ArrayList<Integer>());
    }

    public ArrayList<Integer> DFSPostOrder() {
        return traversePostOrder(root, new ArrayList<Integer>());
    }

    public ArrayList<Integer> DFSPreOrder() {
        return traversePreOrder(root, new ArrayList<Integer>());
    }

    public ArrayList<Integer> traverseInOrder(Node node, ArrayList<Integer> list) {
        if (node == null) return list;
        // This is how we are going to all the way down on the left
        if (node.left != null) {
            traverseInOrder(node.left, list);
        }
        // when there is no node in left take the last value
        list.add(node.value);
        if (node.right != null) {
            traverseInOrder(node.right, list);
        }
        return list;
    }

    public ArrayList<Integer> traversePostOrder(Node node, ArrayList<Integer> list) {
        if (node == null) return list;
        // This is how we are going to all the way down on the left
        if (node.left != null) {
            traversePostOrder(node.left, list);
        }
        if (node.right != null) {
            traversePostOrder(node.right, list);
        }
        list.add(node.value);
        return list;
    }

    public ArrayList<Integer> traversePreOrder(Node node, ArrayList<Integer> list) {
        if (node == null) return list;
        list.add(node.value);
        // This is how we are going to all the way down on the left
        if (node.left != null) {
            traversePreOrder(node.left, list);
        }
        if (node.right != null) {
            traversePreOrder(node.right, list);
        }
        return list;
    }
}