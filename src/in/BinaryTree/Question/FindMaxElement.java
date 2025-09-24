package in.BinaryTree.Question;

public class FindMaxElement {
    public static int findMaxElement(Node head){
        if(head==null)return Integer.MIN_VALUE;
        return Math.max(head.val,Math.max(findMaxElement(head.left),findMaxElement(head.right)));
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        System.out.println(findMaxElement(head));

    }
}
