package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
//Dijkistra Algorithm using priority queue
public class LEC32 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public static int[] dijkstra(int V, int[][] edges, int src)
    {
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []it:edges)
        {
            int u=it[0];
            int v =it[1];
            int dis = it[2];
            adj.get(u).add(new Pair(v,dis));
            adj.get(v).add(new Pair(u,dis));
        }
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)-> x.first-y.first);
        dist[src]=0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty())
        {
            int node = pq.peek().second;
            pq.remove();
            for(Pair it:adj.get(node))
            {
                int v = it.first;
                int wt = it.second;
                if(dist[node]+wt<dist[v])
                {
                    dist[v]= dist[node]+wt;
                    pq.add(new Pair(dist[v],v));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
     int   V = 3;
     int [][]edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
     int src = 2;
        System.out.println(Arrays.toString(dijkstra(V,edges,src)));
    }
}
