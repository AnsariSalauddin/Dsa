package in.bst;




public class SearchElementInBST {
    public static boolean searchElementInbinaryTree(Node node, int element){
        if(node==null){
            return false;
        }
        if(element==node.data){
            return true;
        } else  if (node.data > element) {
            return searchElementInbinaryTree(node.left, element);
        } else {
            return searchElementInbinaryTree(node.right, element);
        }
    }

    //Search Using iterative
    public static boolean searchElementUsingIterative(Node root, int x){
        Node temp=root;
        while (temp!=null){
            if(temp.data==x){
                return true;
            }else  if(temp.data>x){
                temp=temp.left;
            }else {
                temp=temp.right;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Node node=new Node(40);
        node.left=new Node(30);
        node.left.left=new Node(25);
        node.left.right=new Node(35);

        node.right=new Node(50);
        node.right.left=new Node(45);
        node.right.right=new Node(60);

        boolean b = searchElementInbinaryTree(node, 50);
        System.out.println(b);
        boolean b1 = searchElementUsingIterative(node, 50);
        System.out.println(b1);

    }
}
