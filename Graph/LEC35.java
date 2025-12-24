package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//Printing shortest path using Dijkstra
public class LEC35 {
    static  class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public  static List<Integer> shortestPath(int n, int m, int edges[][])
    {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []it:edges)
        {
            int u =it[0];
            int v =it[1];
            int dist = it[2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((x,y)-> x.first-y.first);
        int[]dis = new int[n+1];
        int []parent = new int[n+1];
        Arrays.fill(dis,(int)1e9);
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
        }
        dis[1]=0;
        pq.add(new Pair(0,1));
        while(!pq.isEmpty())
        {
            int node = pq.peek().second;
            pq.remove();
            for(Pair it:adj.get(node))
            {
                int v= it.first;
                int wt = it.second;
                if(dis[node]+wt<dis[v])
                {
                    dis[v]= dis[node]+wt;
                    parent[v]=node;
                    pq.add(new Pair(dis[v],v));
                }
            }
        }
        List<Integer>ans = new ArrayList<>();
        if(dis[n]==(int)1e9)
        {
            ans.add(-1);
            return ans;
        }

            int nod = n;
            while(parent[nod]!=nod)
            {
                ans.add(nod);
                nod = parent[nod];
            }
            ans.add(1);
            ans.add(dis[n]);
            List<Integer>result = ans.reversed();

        return result;
    }
    public static void main(String[] args) {
      int   n = 5, m= 6;
      int [][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(n,m,edges));
    }
}
