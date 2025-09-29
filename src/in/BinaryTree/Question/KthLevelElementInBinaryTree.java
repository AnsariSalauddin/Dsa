package in.BinaryTree.Question;

public class KthLevelElementInBinaryTree<T> {
    static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public void kthLevelElementInt(Node<T> root,int l,int key){
        if(root==null){
            return;
        }
        if(l==key){
            System.out.print(root.data+" ");
            return ;
        }
        kthLevelElementInt(root.left,l+1,key);
        kthLevelElementInt(root.right,l+1,key);
    }
    public static void main(String[] args) {
        /**
         *              1
         *            /  \
         *           2    3
         *          /\   /\
         *        4   5 6  7
         * **/

        Node<Integer> node=new Node<>(1);
        node.left=new Node<>(2);
        node.left.left=new Node<>(4);
        node.left.right=new Node<>(5);
        node.right=new Node<>(3);
        node.right.right=new Node<>(7);
        node.right.left=new Node<>(6);

        KthLevelElementInBinaryTree<Integer> kthLevelElementInBinaryTree=new KthLevelElementInBinaryTree<>();
        kthLevelElementInBinaryTree.kthLevelElementInt(node,1,3);


    }
}
