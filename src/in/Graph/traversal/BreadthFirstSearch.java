package in.Graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> bsf,int vertices){
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> queue=new  LinkedList<>();
        boolean[] visit=new boolean[vertices];
        queue.add(0);
        visit[0]=true;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            res.add(poll);
            for (int i :bsf.get(poll)){
                if(!visit[i]){
                    queue.add(i);
                    visit[i]=true;
                }
            }
        }
        return res;
    }
    static void main() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // total vertices = 5 (0 to 4)
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);

        adj.get(1).add(0);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(0);

        adj.get(4).add(2);
        System.out.println(bfs(adj,5));
    }
}
