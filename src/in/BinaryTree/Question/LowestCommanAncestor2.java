package in.BinaryTree.Question;



public class LowestCommanAncestor2 {
    public static Node lca(Node head,int n1, int n2){
        if(head==null){
            return null;
        }
        if(head.val==n1 || head.val==n2){
            return head;
        }
        Node leftAn=lca(head.left,n1,n2);
        Node rightAn=lca(head.right,n1,n2);
        if(leftAn!=null && rightAn!=null){
            return head;
        }else if(leftAn!=null && rightAn==null){
            return leftAn;
        }else if(leftAn==null && rightAn!=null){
            return rightAn;
        }else {
            return null;
        }
    }

    void main() {
//        IO.println("Hlelo");
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        head.right.left=new Node(6);
        head.right.right=new Node(7);
        Node lca = lca(head, 5, 6);
        System.out.println(lca.val);

    }
}
