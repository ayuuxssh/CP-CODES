package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class LEC19 {
//Detection of cycle in Directed graph
    public  static boolean isCyclic(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int [] it:edges)
        {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        boolean[]vis = new boolean[V];
        boolean []path = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(dfs(adj,vis,path,i))
                    return true;
            }
        }
        return false;
    }
    private static boolean dfs(ArrayList<ArrayList<Integer>>adj,boolean[]vis,boolean []path,int node)
    {
        vis[node]=true;
        path[node]=true;


        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                if(dfs(adj,vis,path,it))
                    return true;
            }
            else if(path[it])
                return true;
        }

        path[node]=false;
        return false;

    }
    public static void main(String[] args) {
       int  V = 4;
       int [][]edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println(isCyclic(V,edges));
    }
}
