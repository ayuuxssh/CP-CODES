package ayush.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LEC13 {
    static class Pair{
        int first;
        int second;
        int steps;
        Pair(int first,int second,int steps)
        {
            this.first = first;
            this.second=second;
            this.steps=steps;
        }
    }
    public  static int[][] updateMatrix(int[][] mat)
    {
        int n=mat.length;
        int m = mat[0].length;
        boolean [][]vis= new boolean[n][m];
        int [][]dis = new int[n][m];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    dis[i][j]=0;
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().steps;
            q.remove();

            for(int d=-1;d<=1;d++)
            {
                for(int e =-1;e<=1;e++)
                {
                    if(d!=0 && e!=0)
                        continue;
                    int nr = row+d;
                    int nc = col+e;

                    if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1 && vis[nr][nc]==false)
                    {
                        vis[nr][nc]=true;
                        q.add(new Pair(nr,nc,steps+1));
                        dis[nr][nc]=steps+1;
                    }
                }
            }
        }
        return dis;

    }
    public static void main(String[] args) {
       int [][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }
}
