package in.BinaryTree.Question;

public class HieghtOfTree {
    public static int heightOfTree(Node head){
        if (head==null||(head.left==null && head.right==null))return 0;
        return 1+Math.max(heightOfTree(head.left),heightOfTree(head.right));
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        System.out.println(heightOfTree(head));
        /*
        *           1
        *         /   \
        *       2       3
        *     /           \
        *    4
        * */
    }
}
