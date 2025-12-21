package ayush.Graph;

import java.util.*;
//Eventual states using BFS(Topological sort)
public class LEC25 {
        public static List<Integer> eventualSafeNodes(int[][] graph)
        {
            List<Integer> ans = new ArrayList<>();
            int n = graph.length;
            int [] indegree= new int[n];
            Arrays.fill(indegree,0);
            List<List<Integer>>adj = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<n;i++)
            {
                for(int it:graph[i])
                {
                    adj.get(it).add(i);
                    indegree[i]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<n;i++)
            {
               if(indegree[i]==0)
                   q.add(i);
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
                   {
                       q.add(it);
                   }
               }
           }
           ans.sort(null);
            return ans;
        }

        public static void main(String[] args) {
            int [][] graph ={{1,2},{2,3},{5},{0},{5},{},{}};
            System.out.println(eventualSafeNodes(graph));
        }
    }

