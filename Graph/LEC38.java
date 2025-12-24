package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//Cheapest Flight with K stops
public class LEC38 {
    static class Pair{
        int first;
        int second;
        int third;
        Pair(int first,int second,int third)
        {
            this.first=first;
            this.second =second;
            this.third =third;

        }
    }
    public  static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int [] it:flights)
        {
            int u = it[0];
            int v =it[1];
            int price = it[2];
            adj.get(u).add(new Pair(v,price,0));
        }
        int []dist= new int[n];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y)->x.first-y.first);
        dist[src]=0;
        pq.add(new Pair(0,src,0));
        while(!pq.isEmpty())
        {
            int node = pq.peek().second;
            int stop = pq.peek().first;
            int dis = pq.peek().third;
            pq.remove();
            if(stop>k)
                continue;
            for(Pair it:adj.get(node))
            {
                int v = it.first;
                int wt = it.second;
                if(dis+wt<dist[v] && stop<=k )
                {
                    dist[v]= dis+wt;
                    pq.add(new Pair(stop+1,v,dist[v]));

                }
            }
        }
        if(dist[dst]==(int)1e9)
            return -1;

        return dist[dst];
    }

    public static void main(String[] args) {
       int  n = 4;
       int [][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
       int src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
}
