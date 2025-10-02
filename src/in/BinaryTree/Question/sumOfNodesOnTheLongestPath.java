package in.BinaryTree.Question;
class Result {
    int maxLen = 0;
    int maxSum = 0;
}
public class sumOfNodesOnTheLongestPath {
    public static void sumOfLongestTree(Node head,int len,int sum, Result res){

        if(head==null){
            if(len>res.maxLen){
                res.maxLen=len;
                res.maxSum=sum;
            }else if (len== res.maxLen){
                res.maxSum=Math.max(sum,res.maxSum);
            }
            return;
        }
        sum+=head.val;
        sumOfLongestTree(head.left,len+1,sum,res);
        sumOfLongestTree(head.right,len+1,sum,res);
    }
   public static int sumOfLongest(Node head){
        Result res=new Result();
        sumOfLongestTree(head,0,0,res);
        return res.maxSum;

    }
    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
//        head.left.right=new Node(6);
        head.right.left=new Node(5);
        int i = sumOfLongest(head);
        System.out.println(i);
        /*
                        1
                      /   \
                     2      3
                    /  \    / \
                   4    6   5
         */
    }
}
