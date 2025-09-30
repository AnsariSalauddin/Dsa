package in.BinaryTree.Question;

import java.util.*;

public class BottomViewOfTree {
    public static ArrayList<Integer> bottomView(Node head){
        ArrayList<Integer> an=new ArrayList<>();
        if(head==null){
            return an;
        }
        Map<Integer, Integer> tr=new TreeMap<>();
        Queue<Info2> queue=new LinkedList<>();
        queue.add(new Info2(0,head));
        while (!queue.isEmpty()){
            Info2 poll = queue.poll();
            int hd = poll.hd;
            tr.put(hd,poll.head.val);
            if(poll.head.left!=null){
                queue.add(new Info2(hd-1,poll.head.left));
            }
            if(poll.head.right!=null){
                queue.add(new Info2(hd+1,poll.head.right));
            }
        }
        an.addAll(tr.values());
        return an;
    }
    public static void main(String[] args) {
        Node head=new Node(10);
        head.left=new Node(20);
        head.right=new Node(30);
        head.left.left=new Node(40);
        head.left.right=new Node(60);
        ArrayList<Integer> integers = bottomView(head);
        System.out.println(integers.toString());

    }
}
