package ayush.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Bipartite using DFS
public class LEC18 {
        public static  boolean isBipartite(int[][] graph)
        {
            int V = graph.length;
            int []color = new int[V];
            Arrays.fill(color,-1);
            for(int i=0;i<V;i++)
            {
                if(color[i]==-1)
                {
                    if(check(graph,color,i,0)==false)
                        return false;
                }
            }
            return true;
        }
        private static boolean check(int [][]graph,int []color,int row,int col)
        {
            color[row]=col;
            for(int it:graph[row])
            {
                if(color[it]==-1) {
                    if (check(graph, color, it, 1-col) == false)
                        return false;
                }
                    else if(color[it]== col)
                        return false;
                }
            return true;
        }
        public static void main(String[] args) {
            int [][]  graph ={{1,2,3},{0,2},{0,1,3},{0,2}};
            System.out.println(isBipartite(graph));
        }
    }

