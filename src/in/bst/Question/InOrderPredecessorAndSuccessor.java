package in.bst.Question;

import in.bst.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InOrderPredecessorAndSuccessor {
    public static Node rightMostInLeft(Node node){
        while (node.right!=null){
            node=node.right;
        }
        return node;
    }
    public static Node leftMostInRight(Node node){
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
    public static List<Integer> findPredecessorAndSucessor(Node node, int key){
        Node temp=node;
        int succ=-1;
        int pred=-1;
        while (temp!=null){
            if(temp.data<key){
                pred=temp.data;
                temp=temp.right;
            }else if(temp.data> key){
                succ=temp.data;
                temp=temp.left;
            }else {
                if(temp.left!=null){
                    pred=rightMostInLeft(temp.left).data;
                }
                if(temp.right!=null){
                    succ=leftMostInRight(node.right).data;
                }
            }
        }
        return Arrays.asList(pred,succ);
    }
    static void main() {
        Node root=new Node(6);
        root.left=new Node(4);
        root.left.left=new Node(1);
        root.left.right=new Node(5);
        root.right=new Node(8);
        root.right.left=new Node(7);
        root.right.right=new Node(9);

        List<Integer> predecessorAndSucessor = findPredecessorAndSucessor(root, 3);
        System.out.printf(predecessorAndSucessor.toString());
    }
}
