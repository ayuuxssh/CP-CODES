package ayush.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Binary MAZE
public class LEC36 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;

        }
    }
    public  static int shortestPathBinaryMatrix(int[][] grid)
    {
        int n = grid.length;
        int [][]dis= new int[n][n];
        for(int [] row:dis)
        {
            Arrays.fill(row,(int)1e9);
        }
        Queue<Pair>q= new LinkedList<>();
        if(grid[0][0]==0)
        {
            dis[0][0]=1;
            q.add(new Pair(0,0));
        }
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int d=-1;d<=1;d++)
            {
                for(int e =-1;e<=1;e++)
                {
                    int nr = row+d;
                    int nc = col+e;

                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && dis[row][col]+1<dis[nr][nc])
                    {
                        dis[nr][nc]= 1+dis[row][col];
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        if(dis[n-1][n-1]==(int)1e9)
            return -1;
        return dis[n-1][n-1];
    }
    public static void main(String[] args) {
      int [][]  grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
