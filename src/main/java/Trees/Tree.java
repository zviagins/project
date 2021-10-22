package Trees;

public class Tree {

    Node root;




    private class Node {
        String data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(String data) {
            this.data = data;
        }
    }
}
