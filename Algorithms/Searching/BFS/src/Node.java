public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    public void insert (int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new Node(value);
            }else {
                this.left.insert(value);
            }
        }else {
            if (this.right == null) {
                this.right = new Node(value);
            }else {
                this.right.insert(value);
            }
        }


    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
