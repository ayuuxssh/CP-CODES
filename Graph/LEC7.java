package ayush.Graph;

import java.util.ArrayList;
//Number of provinces
public class LEC7 {
    public  static int findCircleNum(int[][] isConnected)
    {
ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
int n =isConnected.length;
for(int i=0;i<n;i++)
    adj.add(new ArrayList<>());//To add empty arrayList
        //To change adjacency matrix to adjacency list
for(int i=0;i<n;i++)
{
    for(int j=0;j<n;j++)
    {
        if(isConnected[i][j]==1 && i!=j)
        {
            adj.get(i).add(j);
            adj.get(j).add(i);
        }
    }

}
int provinces =0;
boolean []vis = new boolean[n+1];//to keep the track of visited node
for(int i=0;i<n;i++)//check the city so that we can find provinces
{
    if(!vis[i])
    {
        provinces++;//to count the provinces
        dfs(i,adj,vis);
    }
}
return provinces;
    }
    //Apllied pure dfs
    private static void dfs(int node, ArrayList<ArrayList<Integer>>adj,boolean[]vis)
    {
        vis[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,adj,vis);
            }
        }
    }
    public static void main(String[] args) {
     int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
