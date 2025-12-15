package ayush.Graph;

import java.util.LinkedList;
import java.util.Queue;

//Number of Enclaves using BFS
//We can solve using DFS as it is same as Surrounding region
public class LEC15 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public  static int numEnclaves(int[][] grid)
    {
       int n = grid.length;
       int m = grid[0].length;
       boolean [][]vis = new boolean[n][m];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            if(grid[0][i]==1 && !vis[0][i])
            {
                vis[0][i]=true;
                q.add(new Pair(0,i));
            }
            if(grid[n-1][i]==1 && !vis[n-1][i])
            {
                vis[n-1][i]=true;
                q.add(new Pair(n-1,i));
            }
        }
        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1 && !vis[i][0])
            {
                vis[i][0]=true;
                q.add(new Pair(i,0));
            }
            if(grid[i][m-1]==1 && !vis[i][m-1])
            {
                vis[i][m-1]=true;
                q.add(new Pair(i,m-1));
            }
        }
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int d=-1;d<=1;d++)
            {
                for(int e=-1;e<=1;e++)
                {
                    if(d!=0 && e!=0)
                        continue;
                    int nr = row+d;
                    int nc = col+e;
                    if(nr>=0 && nr<n && nc>=0 &&nc<m && grid[nr][nc]==1 && !vis[nr][nc])
                    {
                        vis[nr][nc]=true;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        int count =0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] && grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
      int [][]  grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}
