package in.BinaryTree.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BoundryTraversal {
    public static void leftPartTraversal(Node head,ArrayList<Integer> ans){
        if(head==null ||(head.left==null && head.right==null)){
            return;
        }
        ans.add(head.val);
        if(head.left!=null){
            leftPartTraversal(head.left,ans);
        }else {
            leftPartTraversal(head.right,ans);
        }
    }
    public  static void leafNodeTraversal(Node head, ArrayList<Integer> ans){
        if(head==null){
            return;
        }
        if(head.left==null && head.left==null){
            ans.add(head.val);
        }
        leafNodeTraversal(head.left,ans);
        leafNodeTraversal(head.right,ans);
    }
     public static void rightTraversal(Node head,ArrayList<Integer> ans){

        if(head==null ||(head.left==null && head.right==null)){
            return;
        }
        if(head.right!=null){
            rightTraversal(head.right,ans);
        }else {
            rightTraversal(head.left,ans);
        }
        ans.add(head.val);

     }
    public static ArrayList<Integer> bountryTraversal(Node head){
        ArrayList<Integer> al=new ArrayList<>();
        al.add(head.val);
        leftPartTraversal(head.left,al);
        leafNodeTraversal(head.left,al);
        leafNodeTraversal(head.right,al);
        rightTraversal(head.right,al);

        return al;
    }

    public static void main(String[] args) {

        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        head.left.right.left=new Node(8);
        head.left.right.right=new Node(9);

        head.right.left=new Node(6);
        head.right.right=new Node(7);
        ArrayList<Integer> integers = bountryTraversal(head);
        System.out.println(integers.toString());


    }
}
