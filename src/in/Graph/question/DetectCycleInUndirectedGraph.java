package in.Graph.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair1{
    int first;
    int second;
    Pair1(int first, int second){
        this.first=first;
        this.second=second;
    }
}

public class DetectCycleInUndirectedGraph {
    public static boolean detectCycleInUndirectedGraph(int src,
                                                       boolean[] visit,
                                                       ArrayList<ArrayList<Integer>> adj){
        visit[src]=false;
        Queue<Pair1> q=new LinkedList<>();
        q.add(new Pair1(src,-1));

        while (!q.isEmpty()){
            Pair1 poll = q.poll();
            int child=poll.first;
            int parent=poll.second;
            for (int i:adj.get(child)){
                if(!visit[i]){
                    visit[i]=true;
                    q.add(new Pair1(i,child));
                }else if (parent!=i){
                    return true;
                }
            }
        }
        return false;
    }
    static void main() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0, 1)));
        list.add(new ArrayList<>(Arrays.asList(1, 2)));
        list.add(new ArrayList<>(Arrays.asList(2, 3)));
        int V=4;
        boolean[] visit=new boolean[V];
        boolean b=false;
        for (int i=0; i<V;i++){
            if(!visit[i]){
               b = detectCycleInUndirectedGraph(i, visit, list);
            }
        }
        System.out.println(b);
    }
}
