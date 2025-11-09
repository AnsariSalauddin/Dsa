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
    public boolean inOrderTraversal(Node root,int[] prev){
        if(root==null){
            return true;
        }
        if(!inOrderTraversal(root.left,prev)){
            return false;
        }
        if(prev[0]>=root.data){
            return false;
        }
        prev[0]=root.data;
        return inOrderTraversal(root.right,prev);
    }
    public static void main(String[] args) {
        ValidatedBST validatedBST=new ValidatedBST();
        Node node=new Node(4);
        node.left=new Node(2);
        node.left.left=new Node(1);
        node.left.right=new Node(3);
        node.right=new Node(6);
        node.right.left=new Node(8);
        node.right.right=new Node(7);
        boolean b = checkValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(b);
        boolean b1 = validatedBST.inOrderTraversal(node, new int[]{Integer.MIN_VALUE});
        System.out.println(b1);

    }
}
