package in.Graph.question;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleUndirectedGraphDFS {
    public static boolean detectCycleInUndirectedGraph1(
            Pair1 src,
            boolean[] visit,
            ArrayList<ArrayList<Integer>> list
    ) {
        visit[src.first] = true;   // FIX 1: mark visited

        for (int i : list.get(src.first)) {

            if (!visit[i]) {
                if (detectCycleInUndirectedGraph1(
                        new Pair1(i, src.first), visit, list)) {
                    return true;
                }
            }
            // FIX 2: check parent, not current node
            else if (i != src.second) {
                return true;
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
//        Pair1 pair1=new Pair1(1,-1);
        for (int i=0; i<V;i++){
            if(!visit[i]){
                b = detectCycleInUndirectedGraph1(new Pair1(i,-1), visit, list);
                break;
            }
        }
        System.out.println(b);
    }
}
