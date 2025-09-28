package ayush.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEC50 {
    public static int minCost(int n, int[] cuts)
    {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<cuts.length;i++)
        {
            list.add(cuts[i]);
        }
        list.add(n);
        list.addLast(0);
list.sort(null);
int [][]dp =  new  int[cuts.length+1][cuts.length+1];
for(int []row:dp)
    Arrays.fill(row,-1);
        return minCost(list,1,list.size()-2,dp);
    }
    private static int minCost(List<Integer>list ,int i,int j,int [][]dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++)
        {
            int cost = list.get(j+1)-list.get(i-1)+minCost(list,i,k-1,dp)+minCost(list,k+1,j,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
//Tabulation
public static int minCost1(int n, int[] cuts)
{
    int m = cuts.length;
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<cuts.length;i++)
    {
        list.add(cuts[i]);
    }
    list.add(n);
    list.addLast(0);
    list.sort(null);
    int [][]dp =  new  int[m+2][m+2];
    for(int []row:dp)
   Arrays.fill(row,0);
        for(int i=m;i>0;i--) {
            for (int j = 1 ; j <= m; j++) {
                if(i>j)
                    continue;
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = list.get(j + 1) - list.get(i - 1) + dp[i][k - 1] + dp[k + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][list.size()-2];
    }
    public static void main(String[] args) {
      int   n = 7;
      int []cuts = {1,3,4,5};
        System.out.println(minCost1(n,cuts));
    }
}
