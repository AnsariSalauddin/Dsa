package in.Graph.question;

import java.util.ArrayList;

public class NumberOfProvinces {
    public static void dsf(ArrayList<ArrayList<Integer>> adj, boolean[] visit,int node){
        visit[node]=true;
        for (int i:adj.get(node)){
            if(!visit[i]){
                dsf(adj,visit,i);
            }
        }
    }
    public static int numberOfProvinces(ArrayList<ArrayList<Integer>> adj, int vertices){
        boolean[] visit=new boolean[vertices];
        int count=0;
        for (int i=0 ;i<vertices; i++){
            if (!visit[i]){
                dsf(adj,visit,i);
                count++;
            }
        }
        return count;
    }
    static void main() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = 5; // vertices 0 to 4

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

// Province 1
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

// Province 2 (node 3 alone)
// no edges

// Province 3 (node 4 alone)
// no edges

        int i = numberOfProvinces(adj, V);
        System.out.println(i);

    }
}
