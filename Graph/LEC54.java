package ayush.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//Kosaraju Algorithm for Strongly connected components
public class LEC54 {
    public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean []vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(adj,vis,i,st);
            }
        }
        ArrayList<ArrayList<Integer>>adj1 = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            vis[i]=false;
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int it:adj.get(i))
            {
                adj1.get(it).add(i);
            }
        }
        int count =0;
        while(!st.empty())
        {
            int node = st.peek();
            st.pop();
            if(!vis[node])
            {
                dfs1(adj1,vis,node);
                count++;
            }
        }
        return count;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[]vis,int node,Stack<Integer>st)
    {
        vis[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(adj,vis,it,st);
            }
        }
        st.add(node);
    }
    private static void dfs1(ArrayList<ArrayList<Integer>> adj, boolean[]vis, int node)
    {
        vis[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs1(adj,vis,it);
            }
        }

    }

    public static void main(String[] args) {



    }
}
