package in.Graph.traversal;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static void dfs(
            int node, boolean[] visit,
            ArrayList<ArrayList<Integer>> ajd, ArrayList<Integer> res) {
        visit[node] = true;
        res.add(node);
        for (int i : ajd.get(node)) {
            if (!visit[i]) {
                dfs(i, visit, ajd, res);
            }
        }
    }

    static void main() {
        ArrayList<Integer> res=new ArrayList<>();

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

        boolean[] visit=new boolean[5];
        dfs(0,visit,adj,res);
        System.out.println(res.toString());

    }
}

