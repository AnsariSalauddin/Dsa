package in.bst.Question;

import in.bst.Node;

public class MinimumAndMaximumElementInBinarySearchTree {
    //using iterative
    public static int maximumElement(Node root){
        if(root==null){
            return -1;
        }
        Node temp=root;
        while (temp.right!=null){
            temp=temp.right;
        }
        return temp.data;
    }
    //using recursive
    public static Node maximumElementUsingRecursive(Node root){
//        if(root==null){
//            return null;
//        }
        if(root.right!=null){
            root=maximumElementUsingRecursive(root.right);
        }
        return root;
    }


    public static void main(String[] args) {
        Node root=new Node(40);
        root.left=new Node(30);
        root.left.left=new Node(25);
        root.left.right=new Node(35);
        root.right=new Node(50);
        root.right.left=new Node(45);
        root.right.right=new Node(60);
        int i = maximumElement(root);
        System.out.println(i);
        Node node = maximumElementUsingRecursive(root);
        System.out.println(node.data);
    }
}
