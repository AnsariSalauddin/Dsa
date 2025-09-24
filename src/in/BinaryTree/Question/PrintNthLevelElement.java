package in.BinaryTree.Question;

public class PrintNthLevelElement {
    public static void printNthLevelElement(Node head, int level){
        if (head==null)return;
        if(level==1){
            System.out.println(head.val);
        }
        printNthLevelElement(head.left,level-1);
        printNthLevelElement(head.right,level-1);

    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        printNthLevelElement(head,3);
    }
}
