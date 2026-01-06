package ayush.Graph;

import java.util.HashMap;
import java.util.Map;
//Maximum stones removed from same row or col
public class LEC53 extends  DisjointSet{

    LEC53(int n) {
        super(n);
    }

    public static int removeStones(int[][] stones) {
    int n = stones.length;
    int maxRow = 0;
    int maxCol = 0;
    for(int []it:stones)
    {
        maxRow = Math.max(maxRow,it[0]);
        maxCol = Math.max(maxCol,it[1]);
    }
    LEC53 ds = new LEC53(maxRow+maxCol+1);
    HashMap<Integer,Integer> mp = new HashMap<>();
    for(int[]it:stones)
    {
        int nodeRow = it[0];
        int nodeCol = it[1]+maxRow+1;
        ds.unionBySize(nodeRow,nodeCol);
        mp.put(nodeRow,1);
        mp.put(nodeCol,1);
    }
    int count =0;
    for(Map.Entry<Integer,Integer> it:mp.entrySet())
    {
        if(ds.UltParent(it.getKey())==it.getKey())
        {
            count++;
        }
    }
    return n- count;
}

    public static void main(String[] args) {
     int [][]   stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }
}

