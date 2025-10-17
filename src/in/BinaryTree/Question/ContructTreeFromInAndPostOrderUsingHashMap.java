package in.BinaryTree.Question;

import java.util.HashMap;

public class ContructTreeFromInAndPostOrderUsingHashMap {
    static int index;

    public static void Occurence(HashMap<Integer,Integer> occ,int[] inOrd){
        if(occ.isEmpty()){
            return;
        }
        for (int i=0; i<inOrd.length; i++){
            occ.put(inOrd[i],i);
        }
    }
    public static Node constructNode(int[] in,int[] post, int inStart, int inEnd, HashMap<Integer,Integer> occ){
        if(index < 0 || inStart>inEnd){
            return null;
        }
        int element=post[index--];
        Node root=new Node(element);
        int pos=occ.get(element);
        root.right=constructNode(in,post,pos+1,inEnd,occ);
        root.left=constructNode(in,post,inStart,pos-1,occ);
        return root;
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        postOrder(root.left);
        postOrder(root.right);

    }
    public static void main(String[] args) {
        int[] in={4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        index=post.length-1;
        HashMap<Integer,Integer> occ=new HashMap<>();
        Occurence(occ,in);
        Node node = constructNode(in, post, 0, in.length-1, occ);
        postOrder(node);


    }
}
