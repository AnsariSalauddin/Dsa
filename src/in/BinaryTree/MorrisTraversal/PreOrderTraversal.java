package in.BinaryTree.MorrisTraversal;

import java.util.ArrayList;

public class PreOrderTraversal {
    public static ArrayList<Integer>  preOrderTraversal(Node head){

        ArrayList<Integer> result=new ArrayList<>();
        Node cur=head;
        while (cur!=null){
            if(cur.left==null){
                result.add(cur.val);
                cur=cur.right;
            }else {
                Node ip=cur.left;
                while (ip.right!=null && ip.right!=cur){
                    ip=ip.right;
                }
                if(ip.right==cur){
                    ip.right=null;
                    cur=cur.right;
                }else {
                    result.add(cur.val);
                    ip.right=cur;
                    cur=cur.left;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        head.left.left.left=new Node(6);
        head.right.left=new Node(7);
        head.right.left.left=new Node(8);
        ArrayList<Integer> integers = preOrderTraversal(head);
        System.out.println(integers);

    }
}
