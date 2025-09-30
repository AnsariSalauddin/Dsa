package in.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo<T> {
    static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data){
            this.data=data;
            this.left=null;
            this.right =null;
        }

    }

    int index=-1;
    public Node<T> buildTree(T[] nodes){
        index++;
        if(nodes[index].equals(-1)){
            return null;
        }
        Node<T> node = new Node<>(nodes[index]);
        node.left=buildTree(nodes);
        node.right =buildTree(nodes);
        return node;
    }
    public void preOrder(Node<T> root){
        if(root==null){
            //System.out.print("-1 ");
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(Node<T> root){
        if(root==null){
           // System.out.print("-1 ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public void inOrder(Node<T> root){
        if(root==null){
            //System.out.print("-1 ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public void levelOrder(Node<T> root){
        if(root==null){
            return;
        }
        Queue<Node<T>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node<T> curr=queue.remove();
            if(curr==null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }else {
                    queue.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right !=null){
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] node ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreeDemo<Integer> bd=new BinaryTreeDemo<>();
        Node<Integer> integerNode = bd.buildTree(node);

        bd.preOrder(integerNode);
        System.out.println();
//        bd.postOrder(integerNode);
//        System.out.println();
//        bd.inOrder(integerNode);
        bd.levelOrder(integerNode);



    }
}
