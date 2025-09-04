package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC38 {
    public static int maxProfit(int []prices,int k)
    {
        int n =prices.length;
        int [][]dp = new int[n+1][2*k];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return maxProfit(prices,0,0,dp,2*k);
    }
    private static int maxProfit(int []prices,int i,int count,int [][]dp,int k)
    {
        if(count ==k)
            return 0;
        int profit =0;
        if(i==prices.length)
            return 0;
        if(dp[i][count]!=-1)
            return dp[i][count];
        if(count%2==0)
        {
            profit = Math.max(-prices[i]+maxProfit(prices,i+1,count+1,dp,k),maxProfit(prices,i+1,count,dp,k));
        }
        else
        {
            profit = Math.max(prices[i]+maxProfit(prices,i+1,count+1,dp,k),maxProfit(prices,i+1,count,dp,k));
        }
        return  dp[i][count]=profit;
    }
    //Tabulation
    public static int maxProfit1(int []prices,int k)
    {
        int n =prices.length;
        int len =(2*k)+1;
        int [][]dp = new int[n+1][len];
        for(int i=0;i<n;i++)
            dp[i][len-1]=0;
        for(int i=0;i<len;i++)
            dp[n][i]=0;
        int profit =0;
        for(int i=n-1;i>=0;i--) {
            for (int j = len - 2; j >= 0; j--) {
                if (j % 2 == 0) {
                    profit = Math.max(-prices[i] + dp[i + 1][j + 1], dp[i + 1][j]);
                } else {
                    profit = Math.max(prices[i] + dp[i + 1][j + 1], dp[i + 1][j]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
    //Space optimised
    public static int maxProfit2(int []prices,int k)
    {
        int n =prices.length;
        int len =(2*k)+1;
        int []after = new int[len];
        for(int i=0;i<n;i++)
            after[len-1]=0;
        int profit =0;
        for(int i=n-1;i>=0;i--) {
            int [] curr = new int[len];
            for (int j = len - 2; j >= 0; j--) {
                if (j % 2 == 0) {
                    profit = Math.max(-prices[i] + after[j + 1], after[j]);
                } else {
                    profit = Math.max(prices[i] + after[j + 1], after[j]);
                }
                curr[j] = profit;
            }
            after = curr;
        }
        return after[0];
    }

    public static void main(String[] args) {
        int[]prices = {2,4,1};
        int k =2;
        System.out.println(maxProfit2(prices,k));
    }
}
