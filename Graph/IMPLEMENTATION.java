package ayush.Graph;
import java.util.ArrayList;
import java.util.*;
public class IMPLEMENTATION {
    public static void main(String[] args) {
        int n = 8;
        int m = 6;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        //edges of 1->2
        list.get(1).add(2);
        list.get(2).add(1);

        //edges of 2->4
        list.get(2).add(6);
        list.get(6).add(2);

        //edges of 1->3
        list.get(1).add(3);
        list.get(3).add(1);
// edges of  3->4
        list.get(3).add(4);
        list.get(4).add(3);
        // edges of 4->5
        list.get(2).add(5);
        list.get(5).add(2);
        // edges of 2->5
        list.get(3).add(7);
        list.get(7).add(3);
        list.get(8).add(7);
        list.get(7).add(8);
        list.get(8).add(4);
        list.get(4).add(8);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
       ArrayList<Integer> ans = bfs(n,list);
        System.out.println(ans);
        ArrayList<Integer> ans1 = DFS(n,list);
        System.out.println(ans1);
    }
    //BFS(Breadth First Search)
    public static ArrayList<Integer>bfs(int n , ArrayList<ArrayList<Integer>> list)
    {
        boolean [] vis = new boolean[n+1];
        ArrayList<Integer> result= new  ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        vis[1] = true;
while(!queue.isEmpty())
{
    int  node = queue.poll();
    result.add(node);
    for(int i : list.get(node))
    {
if(vis[i]== false)
{
    vis[i] = true;
    queue.offer(i);
}
    }
}
return result;
    }
    public static ArrayList<Integer> DFS(int n , ArrayList<ArrayList<Integer>> list)
    {
        boolean [] vis = new boolean[n+1];
        vis[1] = true;
        ArrayList<Integer> result = new ArrayList<>();
        DFS(1,list,result,vis);
        return result;
    }

    private  static void DFS(int node , ArrayList<ArrayList<Integer>> list, ArrayList<Integer> result, boolean[] vis) {
        vis[node] =true;
        result.add(node);
        for(int i : list.get(node))
        {
            if(vis[i]==false)
            {
                DFS(i,list,result,vis);
            }
        }
    }
}

