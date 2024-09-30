import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        char vertex;
        Node left;
        Node right;

        public Node(char vertex) {
            this.vertex = vertex;
        }
    }

    private static class Tree {
        Node root;

        void insert(Node node, char vertex, char leftVertex, char rightVertex) {
            if (node == null) return;

            if (node.vertex == vertex) {
                if (leftVertex != '.') {
                    node.left = new Node(leftVertex);
                }
                if (rightVertex != '.') {
                    node.right = new Node(rightVertex);
                }
            } else {
                if (node.left != null) {
                    insert(node.left, vertex, leftVertex, rightVertex);
                }
                if (node.right != null) {
                    insert(node.right, vertex, leftVertex, rightVertex);
                }
            }
        }
        void preOrder(Node node) {
            if (node == null) return;
            System.out.print(node.vertex);
            preOrder(node.left);
            preOrder(node.right);
        }

        void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(node.vertex);
            inOrder(node.right);
        }
        void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.vertex);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
// root 설정
        tree.root = new Node('A');


        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);
            tree.insert(tree.root, parent, leftChild, rightChild);
        }

        tree.preOrder(tree.root);
        System.out.println();

        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
        System.out.println();

    }
}
