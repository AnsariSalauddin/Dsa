package in.BinaryTree.Question;

import java.util.ArrayList;
import java.util.Objects;

public class LowestCommonAncestor<T> {
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
    public  Node<T> lca(Node<T> root,int n1, int n2){
        ArrayList<Node<T>> path1=new ArrayList<>();
        ArrayList<Node<T>> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i=0;
        for (;i<path1.size() && i<path2.size();i++){
            if(path1.get(i).data!=path2.get(i).data){
                break;
            }
        }
        return !path2.isEmpty() && !path1.isEmpty() ? path1.get(i-1):null;

    }
    public boolean getPath(Node<T> root,int n1,ArrayList<Node<T>> path){
        if (root==null){
            return false;
        }
        path.add(root);
        if(root.data.equals(n1)){
            return true;
        }
        boolean path1 = getPath(root.left, n1, path);
        boolean path2 = getPath(root.right, n1, path);

        if(path1 || path2){
            return true;
        }
        path.removeLast();
        return false;
    }


    public static void main(String[] args) {
        LowestCommonAncestor<Integer> lowestCommonAncestor=new LowestCommonAncestor<>();

        Node<Integer> node=new Node<>(1);
        node.left=new Node<>(2);
        node.left.left=new Node<>(3);
        node.left.right=new Node<>(4);
        node.right=new Node<>(5);
        node.right.left=new Node<>(6);
        node.right.right=new Node<>(7);

        Node<Integer> lca = lowestCommonAncestor.lca(node, 2, 0);
        System.out.println(Objects.nonNull(lca)?lca.data:"n1 ya n2 not exist in tree");


    }
}
