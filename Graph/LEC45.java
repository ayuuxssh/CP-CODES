package ayush.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Prim's Algorithm for finding minimum spannig tree
public class LEC45 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public static int spanningTree(int V, int[][] edges)
    {
        boolean []vis = new boolean[V];
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        for(int [] it:edges)
        {
            int u =it[0];
            int v =it[1];
            int w = it[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>((x,y)->x.first-y.first);
        int sum =0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            int wt = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            if(!vis[node])
            {
                vis[node]=true;
                sum +=wt;
                for(Pair it:adj.get(node))
                {
                    int v = it.first;
                    int w = it.second;
                    if(!vis[v])
                    {
                        pq.add(new Pair(w,v));
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
     int    V = 3, E = 3;
     int [][]Edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(spanningTree(V,Edges));
    }
}
