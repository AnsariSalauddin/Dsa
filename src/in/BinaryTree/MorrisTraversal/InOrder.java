package in.BinaryTree.MorrisTraversal;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class InOrder {
    public static List<Integer> morrisInOrderTraversal(Node head){
        List<Integer> res=new ArrayList<>();
        Node cur=head;
        while (cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur=cur.right;
            }else {
                Node ip=cur.left;
                while (ip.right!=null && ip.right!=cur){
                    ip=ip.right;
                }

                if(ip.right==null){
                    ip.right=cur;
                    cur=cur.left;
                }else {
                    ip.right=null;
                    res.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Representation of input binary tree 1
        //        1
        //       / \
        //      2   3
        //     /
        //    4

        Node head1=new Node(1);
        head1.left=new Node(2);
        head1.right=new Node(3);
        head1.left.left=new Node(4);

        List<Integer> list = morrisInOrderTraversal(head1);
        list.stream().forEach(System.out::println);
    }
}
