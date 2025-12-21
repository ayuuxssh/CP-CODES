package ayush.Graph;
//Shortest path in DAG
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LEC27 {
 static class Pair{
    int first;
    int second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
    public  static int[] shortestPath(int V, int E, int[][] edges)
    {
       ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
       for(int i=0;i<V;i++)
       {
           adj.add(new ArrayList<>());
       }
       for(int []it:edges)
       {
           int u =it[0];
           int v =it[1];
           int dist = it[2];
           adj.get(u).add(new Pair(v,dist));
       }
       boolean [] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                toposort(adj,vis,st,i);
            }
        }

        int[]dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[0]=0;
        while(!st.empty())
        {
            int node = st.peek();
            st.pop();

            for(Pair it:adj.get(node)) {
                int v = it.first;
                int wt = it.second;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        for(int i=0;i<V;i++)
        {
            if(dist[i]==(int)1e9)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
    private static void toposort(ArrayList<ArrayList<Pair>>adj,boolean[]vis,Stack<Integer>st,int node)
    {
        vis[node]=true;
        for(Pair it:adj.get(node))
        {
            int v = it.first;
            if(!vis[v])
            {
                toposort(adj,vis,st,v);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
     int   V = 4, E = 2;
     int [][]edges = {{0,1,2}, {0,2,1}};
        System.out.println(Arrays.toString(shortestPath(V,E,edges)));
    }
}
