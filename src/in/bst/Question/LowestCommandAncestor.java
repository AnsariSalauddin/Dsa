package in.bst.Question;

import in.bst.Node;

public class LowestCommandAncestor {
    public static Node lowestCommanAncestor(Node node, Node a, Node b){
        if(node==null){
            return null;
        }
        if(node.data==a.data || node.data==b.data){
            return node;
        }
        Node left=lowestCommanAncestor(node.left,a,b);
        Node right=lowestCommanAncestor(node.right,a,b);
        if(left!=null && right!=null){
            return node;
        }else if(left!=null){
            return left;
        }else {
            return right;
        }
    }
    static void main() {
        Node root=new Node(6);
        root.left=new Node(4);
        root.left.left=new Node(1);
        root.left.right=new Node(5);
        root.right=new Node(8);
        root.right.left=new Node(7);
        root.right.right=new Node(9);
        Node node = lowestCommanAncestor(root, new Node(1), new Node(9));
        System.out.printf(String.valueOf(node.data));
    }
}
