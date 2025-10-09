package in.BinaryTree.Question;

import java.util.*;

public class TopViewOfBinaryTree<T> {
    static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Info<T>{
        int hd;
        Node<T> node;
        Info(Node<T> node, int data){
            this.hd=data;
            this.node=node;
        }
    }

    public void topView(Node<T> root){
        Queue<Info<T>> queue=new LinkedList<>();
        queue.add(new Info<>(root,0));
        queue.add(null);
        Map<Integer,Node<T>> map=new HashMap<>();
        int min=0;
        int max=0;

        while (!queue.isEmpty()){
            Info<T> remove = queue.remove();
            if(remove==null){
                if(queue.isEmpty()){
                    break;
                }else {
                    queue.add(null);
                }
            }else {
                if(!map.containsKey(remove.hd)){
                    map.put(remove.hd,remove.node);
                }
                if(remove.node.left!=null){
                    queue.add(new Info<>(remove.node.left,remove.hd-1));
                    min=Math.min(min,remove.hd-1);
                }
                if (remove.node.right!=null){
                    queue.add(new Info<>(remove.node.right,remove.hd+1));
                    max=Math.max(max,remove.hd+1);
                }
            }
        }

        for (int i=min; i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        TopViewOfBinaryTree<Integer> topViewOfBinaryTree=new TopViewOfBinaryTree<>();
        Node<Integer> node=new Node<>(1);
        node.left=new Node<>(2);
        node.left.left=new Node<>(4);
        node.left.right=new Node<>(5);
        node.right=new Node<>(3);
        node.right.right=new Node<>(7);
        node.right.left=new Node<>(6);
        topViewOfBinaryTree.topView(node);
    }
}
