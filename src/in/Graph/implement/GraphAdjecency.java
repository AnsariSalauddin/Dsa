package in.Graph.implement;

public class GraphAdjecency {
    private int[][] adjMatrix;
    private int vertices;
    GraphAdjecency(int vertices){
        this.vertices=vertices;
        this.adjMatrix=new int[vertices][vertices];
    }
    public void addEdge(int src, int des){
        adjMatrix[src][des]=1;
        adjMatrix[des][src]=1;
    }
    public  void printGraph(){
        for (int i=0; i<vertices; i++){
            for (int j=0; j<vertices; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void main() {
        GraphAdjecency graph=new GraphAdjecency(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.printGraph();

    }

}
