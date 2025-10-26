package in.bst.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeFromBinarySearchTree {
    public static Node deleteNode(Node root, int data){
        if (root == null) {
            return null;
        }
        if(root.data<data){
            root.right=deleteNode(root.right,data);
        }else if(root.data>data){
            root.left=deleteNode(root.left,data);
        }else {
            //case1-when  leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }
            Node is=findInOrderSuccessor(root.right);
            root.data=is.data;
            root.right=deleteNode(root.right, is.data);
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root){
        while (root.left!=null){
            root= root.left;
        }
        return root;
    }
    public static void levelOrderTraversal(Node node){
        Queue<Node> temp= new LinkedList<>();
        temp.add(node);
        temp.add(null);
        while (!temp.isEmpty()){
            Node remove = temp.remove();
            if(remove==null){
                System.out.println();
                if(temp.isEmpty()){
                    break;
                }else {
                    temp.add(null);
                }
            }else {
                System.out.print(remove.data+" ");
                if(remove.left!=null){
                    temp.add(remove.left);
                }
                if(remove.right!=null){
                    temp.add(remove.right);
                }
            }
        }
    }

    public static void main(String[] args) {
       Node node=new Node(40);
        node.left=new Node(30);
        node.left.left=new Node(25);
        node.left.right=new Node(35);

        node.right=new Node(50);
        node.right.left=new Node(45);
        node.right.right=new Node(60);
        System.out.println("Original Tree:");
        levelOrderTraversal(node);
        Node node1 = deleteNode(node, 45);
        System.out.println("\nTree after deleting 45:");
        levelOrderTraversal(node);
    }
}
