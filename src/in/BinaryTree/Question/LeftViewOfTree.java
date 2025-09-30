package in.BinaryTree.Question;

import java.util.ArrayList;

public class LeftViewOfTree {
    public static void solveMethod(Node head, ArrayList<Integer> ans, int level){
        if(head==null){
            return;
        }
        if(level==ans.size()){
            ans.add(head.val);
        }
        solveMethod(head.left,ans,level+1);
        solveMethod(head.right,ans,level+1);
    }
    public static ArrayList<Integer> leftViewOfTree(Node head){
        ArrayList<Integer> an=new ArrayList<>();
        solveMethod(head,an,0);
        return an;
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        ArrayList<Integer> integers = leftViewOfTree(head);
        System.out.println(integers.toString());
    }
}
