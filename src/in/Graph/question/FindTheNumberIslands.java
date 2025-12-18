package in.Graph.question;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class FindTheNumberIslands {
    public static void bsf(int row, int col, boolean[][] visit, char[][] grid){
        visit[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(row,col));
        while (!queue.isEmpty()){
            int nrow=queue.peek().first;
            int ncol=queue.peek().second;
            queue.poll();
            for (int delrow=-1; delrow<=1; delrow++){
                for (int delcol=-1; delcol<=1; delcol++){
                    int nrow1=nrow+delrow;
                    int ncol1=ncol+delcol;
                    if(nrow1>=0 && nrow1<n && ncol1>=0
                            && ncol1<m && !visit[nrow1][ncol1] && grid[nrow1][ncol1]=='L'){
                        visit[nrow1][ncol1]=true;
                        queue.add(new Pair(nrow1,ncol1));
                    }
                }
            }

        }
    }
    public static int numberOfIslands(char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visit=new boolean[n][m];
        int count=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(!visit[i][j] && grid[i][j]=='L'){
                count++;
                bsf(i,j,visit,grid);
                }
            }
        }
        return count;
    }
    static void main() {
        char grid[][] = {{'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };
        int i = numberOfIslands(grid);
        System.out.println(i);
    }
}
