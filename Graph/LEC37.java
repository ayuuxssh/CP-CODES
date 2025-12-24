package ayush.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
// Path With Minimum Effort
public class LEC37 {
   static class Pair{
        int diff;
        int first;
        int second;
        Pair(int diff,int first,int second)
        {
            this.diff = diff;
            this.first = first;
            this.second = second;
        }
    }
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int [][]dis = new int[n][m];
        for(int [] row:dis)
        {
            Arrays.fill(row,(int)1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y)->x.diff-y.diff);
        dis[0][0]=0;
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty())
        {
            int diff = pq.peek().diff;
            int row = pq.peek().first;
            int col = pq.peek().second;
            pq.remove();

            for(int d=-1;d<=1;d++)
            {
                for (int e =-1;e<=1;e++)
                {
                    if(d!=0 && e!=0)
                        continue;
                    int nr = row+d;
                    int nc = col+e;
                    if(nr>=0 && nr<n && nc>=0 && nc<m && Math.max(diff,Math.abs(heights[row][col]-heights[nr][nc]))<dis[nr][nc])
                    {
                        dis[nr][nc]= Math.max(diff,Math.abs(heights[row][col]-heights[nr][nc]));
                        pq.add(new Pair(dis[nr][nc],nr,nc));
                    }
                }
            }
        }
        return dis[n-1][m-1];
    }
    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
}
