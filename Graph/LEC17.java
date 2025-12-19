package ayush.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Bipartite Graph using BFS
public class LEC17 {
    public static  boolean isBipartite(int[][] graph)
    {
        int V = graph.length;
        int []color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(check(graph,color,i)==false)
                    return false;
            }
        }
        return true;
    }
    private static boolean check(int [][]graph,int []color,int row)
    {
        color[row]=0;
        Queue<Integer>q= new LinkedList<>();
        q.add(row);
        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            for(int it :graph[node])
            {
                if(color[it]==-1)
                {
                    color[it] = 1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
int [][]  graph ={{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
