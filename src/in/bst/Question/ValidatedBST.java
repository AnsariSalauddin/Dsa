package in.bst.Question;

import in.bst.Node;

public class ValidatedBST {
    public static boolean checkValidBST(Node node, int min, int max){
        if(node==null){
            return true;
        }
        if(node.data>min && node.data<max){
            boolean left=checkValidBST(node.left, min,node.data);
            boolean right=checkValidBST(node.right, node.data,max);
            return left&& right;
        }
        return false;
    }
    public static void main(String[] args) {
        Node node=new Node(4);
        node.left=new Node(2);
        node.left.left=new Node(1);
        node.left.right=new Node(3);
        node.right=new Node(6);
        node.right.left=new Node(8);
        node.right.right=new Node(7);
        boolean b = checkValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(b);
    }
}
