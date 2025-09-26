package in.BinaryTree.Question;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTree {
    public static boolean identicalTree(Node head1,Node head2){
        if(head1==null && head2==null){
            return true;
        }
        if(head1==null || head2==null){
            return false;
        }
            return ((head1.val==head2.val)&&identicalTree(head1.left,head2.left)&&identicalTree(head1.right,head2.right));
    }
    public static boolean identicalTree2(Node head1, Node head2){
        if(head1==null && head2==null){
            return true;
        }
        if(head1==null ||head2==null){
            return false;
        }
        Queue<Node> queue1=new LinkedList<>();
        Queue<Node> queue2=new LinkedList<>();
        queue1.add(head1);
        queue2.add(head2);

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            Node poll = queue1.poll();
            Node poll1 = queue2.poll();
            if(poll.val!=poll1.val){
                return false;
            }
            if(poll.left!=null && poll1.left!=null){
                queue1.add(poll.left);
                queue2.add(poll1.left);
            }else if(poll.left!=null || poll1.left!=null){
                return false;
            }

            if(poll.right!=null && poll1.right!=null){
                queue1.add(poll.right);
                queue2.add(poll1.right);
            }else if(poll.right!=null || poll1.right!=null){
                return false;
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
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

        // Representation of input binary tree 2
        //        1
        //       / \
        //      2   3
        //     /
        //    4

        Node head2=new Node(1);
        head2.left=new Node(2);
        head2.right=new Node(3);
        head2.left.left=new Node(4);
        head2.left.right=new Node(5);

        if (identicalTree2(head1,head2)){
            System.out.println("Identical tree");
        }else {
            System.out.println("Not identical tree");
        }
    }
}
