package in.BinaryTree.Question;

public class Cousin {
    public static boolean isCousin(Node head, int val1, int val2){
        if (head==null){
            return false;
        }
        int leftLevel=calLevel(head,val1,1);
        int rightLevel=calLevel(head,val2,1);
        if(leftLevel==0 || rightLevel==0){
            return false;
        }
        return leftLevel==rightLevel && !isSibling(head,val1,val2);
    }

    public static boolean isSibling(Node head, int val1, int val2) {
        if(head==null){
            return false;
        }
        if(head.left!=null && head.right!=null && head.left.val==val1 && head.right.val==val2){
            return true;
        }
        if(head.left!=null && head.right!=null && head.left.val==val2 && head.right.val==val1){
            return true;
        }
        return isSibling(head.left,val1,val2) || isSibling(head.right,val1,val2);
    }

    public static int calLevel(Node head, int val1, int l) {
        if(head==null){
            return 0;
        }
        if(head.val==val1){
            return l;
        }
        int i = calLevel(head.left, val1, l + 1);
        if(i!=0){
            return i;
        }
        return calLevel(head.right,val1,l+1);
    }

    public static void main(String[] args) {

        // create hard coded tree
        //       1
        //     /   \
        //    2     3
        //   /       \
        //  5         4
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(5);
        head.right.right=new Node(4);
        boolean cousin = isCousin(head, 4, 3);
        System.out.println(cousin);
    }
}
