package ayush.Graph;

import java.util.ArrayList;
import java.util.List;
//Eventual safe states using detection of cycles in directed graph
public class LEC20 {
    public static List<Integer> eventualSafeNodes(int[][] graph)
    {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        boolean [] vis = new boolean[n];
        boolean []path = new boolean[n];
        boolean []check = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(graph,vis,path,check,i);
            }
        }

        for(int i=0;i<n;i++)
        {
            if(check[i])
            {
                ans.add(i);
            }
        }
        return ans;
    }
    private static boolean dfs(int [][]graph,boolean[]vis,boolean[]path,boolean[]check,int node)
    {
        vis[node]=true;
        path[node]=true;

        for(int it:graph[node])
        {
            if(!vis[it])
            {
                if(dfs(graph,vis,path,check,it))
                    return true;
            }
            else if(path[it])
            {
                return true;
            }
        }

        path[node]=false;
        check[node]=true;
        return false;
    }
    public static void main(String[] args) {
int [][] graph ={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}
