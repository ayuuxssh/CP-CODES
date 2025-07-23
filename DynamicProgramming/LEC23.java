package ayush.DynamicProgramming;
import java.util.*;
public class LEC23 {
    //Memoization
    public static int knapsack(int []val,int []wt,int capacity)
    {
        int n = wt.length;
        int [][]dp = new int[n][capacity+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return knapsack(val,wt,n-1,capacity,dp);
    }
    private static int knapsack(int []val,int []wt,int index,int target,int [][]dp)
    {

        if(index==0)
        {
                return (target/wt[0])*val[0];
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left = knapsack(val,wt,index-1,target,dp);
        int right =Integer.MIN_VALUE;
        if(wt[index]<=target)
            right = val[index]+knapsack(val,wt,index,target-wt[index],dp);
        return dp[index][target]=Math.max(left,right);
    }
    //TABULATION
    public static int knapsack1(int []val,int []wt,int capacity)
    {
        int n = wt.length;
        int [][]dp = new int[n][capacity+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
   for(int i=0;i<=capacity;i++)
       dp[0][i]=(i/wt[0])*val[0];
for(int i=1;i<n;i++) {
    for (int j = 0; j <= capacity; j++) {
        int left = dp[i - 1][j];
        int right = Integer.MIN_VALUE;
        if (wt[i] <= j)
            right = val[i] + dp[i][j - wt[i]];
        dp[i][j] = Math.max(left, right);
    }
}
return dp[n-1][capacity];
    }
    //Space optimised
    public static int knapsack2(int []val,int []wt,int capacity)
    {
        int n = wt.length;
        int []prev = new int[capacity+1];
            Arrays.fill(prev,-1);
        for(int i=0;i<=capacity;i++)
            prev[i]=(i/wt[0])*val[0];
        for(int i=1;i<n;i++) {
            int []temp = new int[capacity+1];
            for (int j = 0; j <= capacity; j++) {
                int left = prev[j];
                int right = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    right = val[i] + temp[j - wt[i]];
                temp[j] = Math.max(left, right);
            }
            prev = temp;
        }
        return prev[capacity];
    }
    //Further optimised using 1d array
    public static int knapsack3(int []val,int []wt,int capacity)
    {
        int n = wt.length;
        int []prev = new int[capacity+1];
        Arrays.fill(prev,-1);
        for(int i=0;i<=capacity;i++)
            prev[i]=(i/wt[0])*val[0];
        for(int i=1;i<n;i++) {
            for (int j =0; j <=capacity ;j++) {
                int left = prev[j];
                int right = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    right = val[i] + prev[j - wt[i]];
                prev[j] = Math.max(left, right);
            }
        }
        return prev[capacity];
    }
    public static void main(String[] args) {
int []val ={1,1};
int []wt={2,1};
        System.out.println(knapsack3(val,wt,3));
    }
}
