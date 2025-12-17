package in.Graph.implement;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjecencyList {
    private List<List<Integer>> adjList;
    private int vertices;
    GraphAdjecencyList(int vertices){
        this.vertices=vertices;
        adjList=new ArrayList<>();
        for (int i=0; i<vertices; i++){
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
    public void printGraph(){
        for (int i=0; i<vertices; i++){
            System.out.print(i+" -> ");
            for (int j:adjList.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void main() {
    GraphAdjecencyList gl=new GraphAdjecencyList(4);
        gl.addEdge(0, 1);
        gl.addEdge(0, 2);
        gl.addEdge(1, 3);

        gl.printGraph();
    }
}
