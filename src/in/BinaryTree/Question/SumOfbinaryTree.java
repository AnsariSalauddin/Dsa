package in.BinaryTree.Question;

public class SumOfbinaryTree {
    public static int sumOfTree(Node head){
        if(head==null)return 0;
        return head.val+sumOfTree(head.left)+sumOfTree(head.right);
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        System.out.println(sumOfTree(head));
    }
}
