package ayush.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Lec10 {
   static class Pair{
        int first;
        int second;
        int time;
        Pair(int first,int second,int time)
        {
            this.first=first;
            this.second=second;
            this.time = time;
        }
    }
    public static  int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int [][]vis = new int [n][m];
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
               if(grid[i][j]==2)
               {
                   vis[i][j]=2;
                   queue.add(new Pair(i,j,0));
               }

            }
        }
        int tm =0;
        while(!queue.isEmpty())
        {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int tm1 = queue.peek().time;
            tm = Math.max(tm,tm1);
            queue.remove();
            for(int d=-1;d<=1;d++)
            {
                for(int e=-1;e<=1;e++)
                {
                    if(d!=0 && e!=0)
                        continue;
                    int nr = row+d;
                    int nc = col+e;

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]!=2)
                    {
                        vis[nr][nc]=2;
                        queue.add(new Pair(nr,nc,tm1+1));
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
             if(vis[i][j]!=2 && grid[i][j]==1)
                 return -1;
            }
        }

        return tm;
    }

    public static void main(String[] args) {
         int [][]grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
