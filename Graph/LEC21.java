package ayush.Graph;

import java.util.ArrayList;
import java.util.Stack;
//Topological sorting in DAG(Directed Acyclic Graph)
public class LEC21 {
    public  static ArrayList<Integer> topoSort(int V, int[][] edges)
    {
        ArrayList<Integer>ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        boolean [] vis = new boolean[V];
        Stack<Integer>st = new Stack<>();
        for(int []it:edges)
        {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(adj,vis,st,i);
            }
        }
        while(!st.empty())
        {
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj ,boolean[]vis,Stack<Integer>st,int node)
    {
        vis[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(adj,vis,st,it);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
     int   V = 4, E = 3;
     int [][]edges = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(V,edges));
    }
}
