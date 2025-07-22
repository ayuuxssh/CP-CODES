package ayush.DynamicProgramming;
import java.util.*;
public class LEC22 {
    //Memoization
    public static int change(int amount, int[]coins)
    {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return change(coins,n-1,amount,dp);
    }
    private static int change(int []coins,int index,int target,int[][]dp)
    {
        if(index==0)
        {
            if(target%coins[0]==0)
                return 1;
            return 0;
        }
        if(dp[index][target]!=-1)
            return dp[index][target];
        int left =0;
        if(coins[index]<=target)
            left = change(coins,index,target-coins[index],dp);
        int right = change(coins,index-1,target,dp);
        return dp[index][target]=left+right;
    }
    //Tabulation
    public static int change1(int amount, int[]coins)
    {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int []row:dp)
            Arrays.fill(row,0);

        for(int i=0;i<=amount;i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i]=0;
        }
        for(int i=1;i<n;i++) {
            for (int j = 0; j <= amount; j++) {
                int left = 0;
                if (coins[i] <= j)
                    left = dp[i][j - coins[i]];
                int right = dp[i - 1][j];
                dp[i][j] = left + right;
            }
        }
        return dp[n-1][amount];
    }
    //Space optimisation
    public static int change2(int amount, int[]coins)
    {
        int n = coins.length;
        int []prev = new int[amount+1];

        for(int i=0;i<=amount;i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
            else
                prev[i]=0;
        }
        for(int i=1;i<n;i++) {
            int []temp = new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int left = 0;
                if (coins[i] <= j)
                    left = temp[j - coins[i]];
                int right = prev[j];
                temp[j] = left + right;
            }
            prev = temp;
        }
        return prev[amount];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(change2(5,arr));
    }
}
