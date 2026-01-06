package ayush.Graph;
import java.util.ArrayList;
import java.util.List;//Tarjan's Algorithm for finding bridges
public class LEC55 {
    private static int timer =1;
    private  static void dfs(int node, int parent , boolean[]vis, List<List<Integer>> adj,int []low,int []tin,List<List<Integer>>bridges)
    {
        vis[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;
            if(!vis[it])
            {
                dfs(it,node,vis,adj,low,tin,bridges);
                low[node]= Math.min(low[node],low[it]);
                if(low[it]>tin[node])
                {
                    List<Integer>result = new ArrayList<>();
                    result.add(it);
                    result.add(node);
                    bridges.add(result);
                }
            }
            else {
                low[node]= Math.min(low[node],low[it]);
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it:connections)
        {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[]vis= new boolean[n];
        int []tin = new int [n];
        int []low = new int [n];
        List<List<Integer>>ans = new ArrayList<>();
        dfs(0,-1,vis,adj,low,tin,ans);
        return ans;
    }

public static void main(String[] args) {
   int  n = 4;
   List<List<Integer>>list = new ArrayList<>(List.of(
           List.of(0,1),
           List.of(1,2),
           List.of(2,0),
           List.of(1,3)
   ));
    System.out.println(criticalConnections(n,list));
}
}
