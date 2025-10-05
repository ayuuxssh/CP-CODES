package ayush.DynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEC51 {
    //Mmeoization
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(nums[i]);
        list.add(1);
        list.addLast(1);
        int [][]dp = new int[n+1][n+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return maxCoins(list, 1, n,dp);
    }

    private static int maxCoins(List<Integer> list, int i, int j,int[][]dp)
    {
        if(i>j)
        {
            return 0;
        }
        int max= Integer.MIN_VALUE;
        if(dp[i][j]!=-1)
            return dp[i][j];
        for(int k=i;k<=j;k++)
        {
            int coins = list.get(i-1)*list.get(k)*list.get(j+1)+maxCoins(list,i,k-1,dp)+maxCoins(list,k+1,j,dp);
            max = Math.max(max,coins);
        }
        return  dp[i][j]=max;
    }
    //Tabulation
    public static int maxCoins1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(nums[i]);
        list.add(1);
        list.addLast(1);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int coins = list.get(i - 1) * list.get(k) * list.get(j + 1) + dp[i][k-1]+dp[k+1][j] ;
                    max = Math.max(max, coins);
                }
                 dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
    public static void main(String[] args) {
       int [] nums = {3,1,5,8};
        System.out.println(maxCoins1(nums));
    }
}
