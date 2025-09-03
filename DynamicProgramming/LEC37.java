package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC37 {
    //Memoization
    public static int maxProfit(int []prices)
    {
        int n =prices.length;
        int [][][]dp = new int[n+1][2][3];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfit(prices,0,1,2,dp);
    }
    private static int maxProfit(int []prices,int i,int buy,int count,int [][][]dp)
    {
        if(count ==0)
            return 0;
        int profit =0;
        if(i==prices.length)
            return 0;
        if(dp[i][buy][count]!=-1)
            return dp[i][buy][count];
        if(buy==1)
        {
            profit = Math.max(-prices[i]+maxProfit(prices,i+1,0,count,dp),maxProfit(prices,i+1,1,count,dp));
        }
        else
        {
            profit = Math.max(prices[i]+maxProfit(prices,i+1,1,count-1,dp),maxProfit(prices,i+1,0,count,dp));
        }
        return  dp[i][buy][count]=profit;
    }
    //Tabulation
    public static int maxProfit1(int []prices)
    {
        int n =prices.length;
        int [][][]dp = new int[n+1][2][3];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                dp[n][i][j]=0;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                dp[i][j][0]=0;
            }
        }
        int profit =0;
       for(int i=n-1;i>=0;i--) {
           for (int j = 0; j < 2; j++) {
               for (int k = 1; k <= 2; k++) {
                   if (j == 1) {
                       profit = Math.max(-prices[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
                   } else {
                       profit = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                   }
                   dp[i][j][k] = profit;
               }
           }
       }
       return dp[0][1][2];
    }
    //Space optimisation
    public static int maxProfit2(int []prices)
    {
        int n =prices.length;
        int [][]prev = new int[2][3];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                prev[i][j]=0;
            }
        }

        int profit =0;
        for(int i=n-1;i>=0;i--) {
            int [][]curr = new int[2][3];
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 1) {
                        profit = Math.max(-prices[i] + prev[0][k], prev[1][k]);
                    } else {
                        profit = Math.max(prices[i] + prev[1][k - 1], prev[0][k]);
                    }
                    curr[j][k] = profit;
                }
            }
            prev = curr.clone();
        }
        return prev[1][2];
    }
    // Now we convert all the codes to dp[n][4]
    //here we will find using transcation number
    // it will give the idea as only two transactions we are going to do
    //if we are buying it will be on even index and sell on odd index
    public static int maxProfit4(int []prices)
    {
        int n =prices.length;
        int [][]dp = new int[n+1][4];
        for(int []row:dp)
        Arrays.fill(row,-1);
        return maxProfit(prices,0,0,dp);
    }
    private static int maxProfit(int []prices,int i,int count,int [][]dp)
    {
        if(count ==4)
            return 0;
        int profit =0;
        if(i==prices.length)
            return 0;
        if(dp[i][count]!=-1)
            return dp[i][count];
        if(count%2==0)
        {
            profit = Math.max(-prices[i]+maxProfit(prices,i+1,count+1,dp),maxProfit(prices,i+1,count,dp));
        }
        else
        {
            profit = Math.max(prices[i]+maxProfit(prices,i+1,count+1,dp),maxProfit(prices,i+1,count,dp));
        }
        return  dp[i][count]=profit;
    }
    //Tabulation of above
    public static int maxProfit5(int []prices) {
        int n = prices.length;
        int profit = 0;
        int[][] dp = new int[n + 1][5];
       for(int []row:dp)
           Arrays.fill(row,0);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
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
    public static void main(String[] args) {
int [] prices ={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit5(prices));
    }
}
