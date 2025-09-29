package in.BinaryTree.Question;

import java.util.HashMap;

public class DiameterOfTree {
    public static int heightOfTree(Node head){
        if(head==null || (head.left==null  && head.right==null))return 0;
        return Math.max(heightOfTree(head.left) ,heightOfTree(head.right))+1;
    }
    public static int diameterOfTree(Node head){
        if(head==null|| (head.left==null  && head.right==null))return 0;
        int left = diameterOfTree(head.left);
        int right=diameterOfTree(head.right);
        int mid=heightOfTree(head.left)+heightOfTree(head.right);
        if(head.left!=null)mid++;
        if(head.right!=null)mid++;
        int max = Math.max(left, Math.max(right, mid));
        return max;

    }

    public  static Info diameterOfTree2(Node head){
        if(head==null){
            Info info=new Info(0,0);
            return info;
        }
        Info left = diameterOfTree2(head.left);
        Info right=diameterOfTree2(head.right);
        int leftD=left.diameter;
        int rightD=right.diameter;
        int midD=left.height+right.height+1;
        int max = Math.max(leftD, Math.max(rightD, midD));
        return new Info(max,Math.max(leftD,rightD)+1);
    }
    public static void main(String[] args) {

        // create hard coded tree
        //       1
        //     /   \
        //    2     3
        //   / \
        //  5    4
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(5);
        head.left.right=new Node(4);
        System.out.println(diameterOfTree2(head).diameter);

    }
}

class Info{
    int diameter;
    int height;
    public Info(int diameter, int height){
        this.diameter=diameter;
        this.height=height;
    }
}
