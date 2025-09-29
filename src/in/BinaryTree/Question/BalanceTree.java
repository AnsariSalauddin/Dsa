package in.BinaryTree.Question;

public class BalanceTree {
    public static int heigthTree(Node head){
        if(head==null || (head.left==null && head.right==null))return 0;
        return Math.max(heigthTree(head.left),heigthTree(head.right))+1;
    }
    public static boolean checkBalance(Node head){
        if(head==null)return true;
        int lh=heigthTree(head.left);
        if(head.left!=null)lh++;
        int rh=heigthTree(head.right);
        if(head.right!=null)rh++;
        int d=lh-rh;
        if(d<0)d=-d;
        if(d>1)return false;
        return (checkBalance(head.left)&&checkBalance(head.right));
    }

    public static int checkBalanceTree(Node head){
        if(head==null){
            return 0;
        }
        int lf = checkBalanceTree(head.left);
        int rh = checkBalanceTree(head.right);
        if(lf==-1 && rh==-1)return -1;
        if(Math.abs(lf-rh)>1)return -1;
        return Math.max(lf,rh)+1;

    }
    public static void main(String[] args) {

//              1
//            /   \
//          2       3
//        /  \     / \
//       4     5  6   7
//
        Node node=new Node(1);
        node.left=new Node(2);
//        node.left.left=new Node(4);
//        node.left.right=new Node(5);
//        node.right=new Node(3);
//        node.right.left=new Node(6);
//        node.right.right=new Node(7);
        int i = checkBalanceTree(node);
        if(i==-1)
            System.out.println("tree not balance tree"+i);
        else
            System.out.println("Balance tree"+i);
    }
}
