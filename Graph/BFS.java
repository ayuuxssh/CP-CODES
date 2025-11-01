package ayush.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static  ArrayList<Integer> bfs(int [][]adj)
    {
        ArrayList<Integer> bfs = new ArrayList<>();//To create new Arraylist to store the bfs
        boolean [] vis = new boolean[adj.length+1];//Create the boolean array to check the node whether they are visited or not
        Queue<Integer> q = new LinkedList<>();//To store the elements and perform bfs
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty())
        {
            Integer node = q.poll();//Pop out the element in the queue
            bfs.add(node);//add to the bfs
            for(Integer it:adj[node])//Traverse through neighbour of node
            {
                if(vis[it]==false)//Checking whether it was visited earlier or not
                {
                    vis[it]=true;//if it is not the mark as true and add to the queue;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
int adj[][] = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        System.out.println(bfs(adj));
    }
}
