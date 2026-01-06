package ayush.Graph;

import java.util.ArrayList;
//Articulation point in graph
public class LEC56 {
    private static int timer =1;
    private static  void dfs(int node, int parent , boolean[]vis, ArrayList<ArrayList<Integer>> adj, int []low, int []tin, int []mark)
    {
        vis[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        int child =0;
        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;
            if(!vis[it])
            {
                dfs(it,node,vis,adj,low,tin,mark);
                low[node]= Math.min(low[node],low[it]);
                if(low[it]>=tin[node] && parent!=-1)
                {

                    mark[node]=1;
                }
                child++;
            }
            else {
                low[node]= Math.min(low[node],tin[it]);
            }
        }
        if(child>1 && parent==-1)
            mark[node]=1;
    }

    public static ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        boolean[]vis= new boolean[V];
        int []tin = new int [V];
        int []low = new int [V];
        int []mark = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0,-1,vis,adj,low,tin,mark);
        for(int i=0;i<V;i++)
        {
            if(mark[i]==1)
            {
                ans.add(i);
            }
        }
        if(ans.size()==0)
        {
            ans.add(-1);
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

