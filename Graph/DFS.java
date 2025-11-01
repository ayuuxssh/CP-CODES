package ayush.Graph;
import java.util.*;
public class DFS {
    public static ArrayList<Integer> dfs(int [][] adj)
    {
boolean []vis = new boolean[adj.length+1];//TO keep the track of visited node
vis[0]=true;
ArrayList<Integer> dfs= new ArrayList<>();//To store dfs
        dfs(0,vis,adj,dfs);//Recursively call dfs function to have a go in depth
        return dfs;
    }
    public static void dfs(int Node,boolean []vis,int[][]adj,ArrayList<Integer>dfs)
    {
        vis[Node] = true;//tracking the visited node
        dfs.add(Node);//store in dfs
for(Integer it:adj[Node])
{
    if(!vis[it])
    {
        dfs(it,vis,adj,dfs);
    }
}
    }
    public static void main(String[] args) {
       int [][] adj = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        System.out.println(dfs(adj));
    }
}
