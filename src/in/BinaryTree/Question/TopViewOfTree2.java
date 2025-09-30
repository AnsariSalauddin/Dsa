package in.BinaryTree.Question;

import java.util.*;

class Info2{
    int hd;
    Node head;
    public Info2(int hd,Node head){
        this.hd=hd;
        this.head=head;
    }
}
public class TopViewOfTree2 {
    public static ArrayList<Integer> topView(Node head){
        ArrayList<Integer> ans=new ArrayList<>();
        if(head==null){
            return ans;
        }
        Map<Integer, Integer> temp=new TreeMap<>();
        Queue<Info2> queue=new LinkedList<>();
        queue.add(new Info2(0,head));
        while (!queue.isEmpty()){
            Info2 poll = queue.poll();
            int hd = poll.hd;
            Node head2 = poll.head;
            int head1 = poll.head.val;

            if(!temp.containsKey(hd)){
                temp.put(hd,head1);
            }
            if(head2.left!=null){
                queue.add(new Info2(hd-1,head2.left));
            }
            if(head2.right!=null){
                queue.add(new Info2(hd+1,head2.right));
            }

        }

       ans.addAll(temp.values());

        return ans;
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        head.right.left=new Node(6);
        head.right.right=new Node(7);
        ArrayList<Integer> integers = topView(head);
        System.out.println(integers.toString());

        {}
    }
}
