package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//Number of ways to arrive at destination
public class LEC40 {
   static  class Pair{
        int first;
        long second;
        Pair(int first,long second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public static  int countPaths(int n, int[][] roads) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []it:roads)
        {
            int u= it[0];
            int  v = it[1];
            long times =(long)it[2];
            adj.get(u).add(new Pair(v,times));
            adj.get(v).add(new Pair(u,times));
        }
        long []dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x, y)->Long.compare(x.second,y.second));
        dis[0]=0;
        pq.add(new Pair(0,0));
        int []ways= new int[n];
        Arrays.fill(ways,0);
        ways[0]=1;
        int MOD = (int)(1e9+7);
        while(!pq.isEmpty())
        {
            long time = pq.peek().second;
            int node = pq.peek().first;
            pq.remove();
            for(Pair it:adj.get(node))
            {
                int v= it.first;
                long wt = it.second;
                if(time+wt<dis[v])
                {
                    dis[v]=time+wt;
                    ways[v]=ways[node];
                    pq.add(new Pair(v,dis[v]));
                }
                else if(time+wt==dis[v])
                {
                    ways[v]=(ways[v]+ways[node])%MOD ;
                }
            }
        }

        return ways[n-1]%MOD;
    }

    public static void main(String[] args) {
     int    n = 7;

    int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(n,roads));
    }
}
