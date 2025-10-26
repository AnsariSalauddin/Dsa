package in.bst.implementation;


import java.util.LinkedList;
import java.util.Queue;

 class Node {
     int data;
     Node left;
    Node right;

    public Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
public class ImplmentBinarySearchTree {


    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] value = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }

        inOrder(root);
        System.out.println();
//        boolean b = searchKey(root, 9);
//        System.out.println(b);

//        System.out.println("Level Order Traversal");
//        levelOrder(root);


        inOrder(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        levelOrder(root);

    }


}
