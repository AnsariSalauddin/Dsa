package in.BinaryTree.Question;

import java.util.LinkedList;
import java.util.Queue;

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

public class Traversal {

    //inOrder Traversal using recursion
    public static void inOrderTraversal(Node head){
        if (head==null){
            return;
        }
        inOrderTraversal(head.left);
        System.out.println(head.val);
        inOrderTraversal(head.right);
    }

    //preOrderTraversal Traversal using recursion
    public static void preOrderTraversal(Node head){
        if (head==null){
            return;
        }
        System.out.println(head.val);
        preOrderTraversal(head.left);
        preOrderTraversal(head.right);
    }

    //inOrder Traversal using recursion
    public static void postOrderTraversal(Node head){
        if (head==null){
            return;
        }
        postOrderTraversal(head.left);
        postOrderTraversal(head.right);
        System.out.println(head.val);
    }

    //LevelOrder Traversal
    public static void levelOrderTraversal(Node head) {
        if (head == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.val);

            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
    //LevelOrder Traversal Second method
    public static void levelOrderTraversal1(Node head){
        if(head==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(head);
        queue.add(null);
        while (!queue.isEmpty()){
            Node remove = queue.remove();
            if(remove==null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }else {
                    queue.add(null);
                }
            }else {
                System.out.print(remove.val+" ");
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
        }
    }
    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
               /   \
              4     5
         */
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        levelOrderTraversal1(head);


    }
}
