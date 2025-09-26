package in.BinaryTree.Question;

import java.util.*;

public class SpiralTraversal {
    public static ArrayList<Integer> spiralTraversal(Node root){

        ArrayList<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Queue<Node> res=new LinkedList<>();
        res.add(root);
        boolean leftToRight=true;

        while (!res.isEmpty()){
            int size = res.size();
            List<Integer> level=new ArrayList<>();
            for (int i=0; i<size;i++){
                Node poll = res.poll();
                level.add(poll.val);
                if(poll.left!=null)res.add(poll.left);
                if (poll.right!=null)res.add(poll.right);
            }
            if(!leftToRight){
                Collections.reverse(level);
            }
            result.addAll(level);
            leftToRight=!leftToRight;

        }
        return result;
    }
    public static Vector<Integer> zigZag(Node root){
        Vector<Integer> res=new Vector<>();
        if(root==null)return res;
        Queue<Node> temp=new LinkedList<>();
        temp.add(root);
        boolean leftToRight=true;
        while (!temp.isEmpty()){
            int size = temp.size();
            Vector<Integer> tempV = new Vector<>(Collections.nCopies(size, 0));
            for (int i=0; i<size; i++){
                Node poll = temp.poll();
                int index=leftToRight?i:size-i-1;
                assert poll != null;
                tempV.set(index, poll.val);
                if(poll.left!=null)temp.add(poll.left);
                if(poll.right!=null)temp.add(poll.right);
            }
            res.addAll(tempV);
            leftToRight=!leftToRight;
        }
        return res;
    }


    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.right.left=new Node(4);
        head.right.right=new Node(5);
        //1->3->2->4->5
        Vector<Integer> integers = zigZag(head);
        integers.stream().forEach((s)-> System.out.print(s+" "));
    }


}
