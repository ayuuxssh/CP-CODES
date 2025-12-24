package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Shortest path of an undirected graph
public class LEC28 {
    public static int[] shortestPath(int V, int[][] edges, int src)
    {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []it:edges)
        {
            int u =it[0];
            int v =it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int [] dis = new int[V];
        Arrays.fill(dis,(int)1e9);
        Queue<Integer>q= new LinkedList<>();
        dis[src]=0;
        q.add(src);
        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            for(int it :adj.get(node))
            {
                if(dis[node]+1<dis[it])
                {
                    dis[it]=1+dis[node];
                    q.add(it);
                }
            }
        }

        for(int i=0;i<V;i++)
        {
            if(dis[i]==(int)1e9)
                dis[i]=-1;
        }
        return dis;
    }
    public static void main(String[] args) {
    int    V = 9, E = 10;
    int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        int src = 0;
        System.out.println(Arrays.toString(shortestPath(V,edges,src)));
    }
}
