package ayush.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LEC8 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second= second;
        }
    }
    public static int numIslands(char[][] grid)
    {
int n = grid.length;
int m = grid[0].length;
int count=0;
int[][]vis=new int[n][m];
for(int i=0;i<n;i++)
{
    for(int j=0;j<m;j++)
    {
        if(vis[i][j]==0 && grid[i][j]=='1')
        {
            count++;
            bfs(i,j,grid,vis);
        }
    }
}
return count;
    }
    private static void bfs(int row,int col,char[][]grid,int [][]vis)
    {
        int n= grid.length;
        int m = grid[0].length;
        vis[row][col]=1;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(row,col));
        while(!q.isEmpty())
        {
            int front = q.peek().first;
            int back = q.peek().second;
            q.remove();
            for(int d= -1;d<=1;d++)
            {
                for(int e =-1;e<=1;e++)
                {
                    if(d!=0 && e!=0)
                    {
                        continue;
                    }
                    int nr = front+d;
                    int nc = back+e;
                    if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]=='1')
                    {
                        vis[nr][nc]=1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
      char [][]  grid = {
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '0', '0', '0'}
};
        System.out.println(numIslands(grid));
    }
}
