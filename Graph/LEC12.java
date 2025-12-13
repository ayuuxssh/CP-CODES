package ayush.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LEC12 {

        public static boolean check(int [][]edges,int V)
        {
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<V;i++)
            {
                list.add(new ArrayList<>());
            }
            for(int[] it:edges)
            {
                int u = it[0];
                int v = it[1];
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int []vis = new int[V+1];
            for(int i=0;i<V;i++)
            {
                if(vis[i]== 0)
                {
                    if(detectCycle(i,-1,list,vis))
                        return true;
                }
            }
            return false;
        }
        private static boolean detectCycle(int src,int parent,List<List<Integer>> list,int []vis)
        {
            vis[src]=1;
                for(Integer it:list.get(src))
                {
                    if(vis[it]==0)
                    {
                        if(detectCycle(it,src,list,vis))
                            return true;
                    }
                    else if(it!=parent)
                        return true;
                }

            return false;

        }
        public static void main(String[] args) {
            int [][]edges={ {0, 1}, {0, 2}, {1, 2}, {2, 3}};
            int v =4;
            System.out.println(check(edges,v));
        }
    }


