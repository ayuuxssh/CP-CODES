package ayush.Graph;

import java.util.*;

//Topological sorting using BFS (Kahn's Algorithm)
public class LEC22 {
    public  static ArrayList<Integer> topoSort(int V, int[][] edges)
    {
        ArrayList<Integer>ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        int[] indegree= new int[V];
        Arrays.fill(indegree,0);
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for(int []it:edges)
        {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }

        }
        return ans;
    }
        public static void main(String[] args) {
            int   V = 4, E = 3;
            int [][]edges = {{3, 0}, {1, 0}, {2, 0}};
            System.out.println(topoSort(V,edges));
    }
}
