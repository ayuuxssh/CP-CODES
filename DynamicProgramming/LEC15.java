package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC15 {
    //Memoization
    public static boolean canpartition(int [] nums)
    {
        int sum =0;
        int n = nums.length;
        for(int i=0;i<n;i++)
            sum +=nums[i];
        if(sum %2==1)
            return false;
        int [][]dp = new int[n][sum/2+1];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return partition(nums,sum/2,n-1,dp);
    }
    private static boolean partition(int [] nums,int sum,int index,int [][]dp)
    {
        if(sum==0)
            return true;
        if(index==0)
            return nums[0]==sum;
        if(dp[index][sum]!=-1)
            return dp[index][sum]==0?true:false;
        boolean pick =false;
        if(sum>=nums[index])
            pick = partition(nums,sum-nums[index],index-1,dp);
        boolean notpick =partition(nums,sum,index-1,dp);
        dp[index][sum]= pick||notpick?0:1;
        return pick||notpick;
    }
    //Tabulation
    public static boolean canpartition1(int [] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if (sum % 2 == 1)
            return false;
        boolean[][] dp = new boolean[n][sum / 2 + 1];
        for (boolean[] row : dp)
            Arrays.fill(row, false);
        int sum1 = sum / 2;
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        if (nums[0] <= sum1)
            dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum1; j++) {
                boolean pick = false;
                if (j >= nums[i])
                    pick = dp[i - 1][j - nums[i]];
                boolean notpick = dp[i - 1][j];
                dp[i][j] = pick || notpick;
            }
        }
        return dp[n-1][sum1];
    }
    //space optimisation
    public static boolean canpartition2(int [] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if (sum % 2 == 1)
            return false;
        boolean[] prev = new boolean[sum / 2 + 1];

            prev[0]= true;
        int sum1 = sum / 2;
        if(nums[0]<=sum1)
            prev[nums[0]]=true;
        for (int i = 1; i < n; i++) {
            boolean [] temp = new boolean[sum1+1];
            temp[0]= true;
            for (int j = 1; j <= sum1; j++) {
                boolean pick = false;
                if (j >= nums[i])
                    pick = prev[j - nums[i]];
                boolean notpick = prev[j];
                temp[j] = pick || notpick;
            }
            prev= temp;
        }
        return prev[sum1];
    }
    public static void main(String[] args) {
int []arr={1,2,3,5};
        System.out.println(canpartition2(arr));
    }
}
