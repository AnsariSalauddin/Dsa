package in.Graph.question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int first;
    int second;
    int third;
    public Node(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
public class DistanceOfNearestCellHaving1 {
    public static int[][] nearest(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] visit=new int[n][m];
        int dist[][]=new int[n][m];
        Queue<Node> queue=new LinkedList<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(grid[i][j]==1){
                    queue.add(new Node(i,j,0));
                    visit[i][j]=1;
                }else {
                    visit[i][j]=0;
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while (!queue.isEmpty()){
            int row=queue.peek().first;
            int col=queue.peek().second;
            int step=queue.peek().third;
            queue.poll();
            dist[row][col]=step;
            for (int i=0; i<4; i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && visit[nRow][nCol]==0){
                    queue.add(new Node(nRow,nCol,step+1));
                    visit[nRow][nCol]=1;
                }
            }
        }
        return dist;
    }

    static void main() {

        int[][] grid = {{0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}};
        int[][] nearest = nearest(grid);
        for (int[] i:nearest){
            System.out.println(Arrays.toString(i));
        }
    }
}
