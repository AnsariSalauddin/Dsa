package in.BinaryTree.Question;

public class ContructTreeFromInAndPreOrder {
    static int index=0;
    public static int findPositionInPreOrder(int[] in,int elment,int size){
        for (int i=0; i<size; i++){
            if(in[i]==elment){
                return i;
            }
        }
        return -1;
    }
    public static Node constructNode(int[] in,int[] pre, int inStart, int inEnd, int size){
        if(index>=size || inStart>inEnd){
            return null;
        }
        int element=pre[index++];
        Node root=new Node(element);
        int pos=findPositionInPreOrder(in,element,size);
        root.left=constructNode(in,pre,inStart,pos-1,size);
        root.right=constructNode(in,pre,pos+1,inEnd,size);
        return root;
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public static void main(String[] args) {
        int[] in={3,1,4,0,5,2};
        int[] pre={0,1,3,4,2,5};
        Node node = constructNode(in, pre, 0, in.length-1, pre.length);
        postOrder(node);

    }
}
