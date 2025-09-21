package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC41 {
    //Memiozation
    public static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
int [][]dp = new int[n+1][n+1];
for(int []row:dp)
    Arrays.fill(row,-1);
        return lengthOfLIS(nums,0,0,dp);
    }
    private static int lengthOfLIS(int []nums,int i,int prev,int[][]dp)
    {
        if(i==nums.length)
            return 0;
        if(dp[i][prev]!=-1)
            return dp[i][prev];
        int pick =0,nonpick=0;
        nonpick = lengthOfLIS(nums,i+1,prev,dp);
        if(prev==0 || nums[i]>nums[prev-1])
        {
            pick = 1+lengthOfLIS(nums,i+1,i+1,dp);
        }
        return dp[i][prev]=Math.max(pick, nonpick);
    }
    //Tabulation
    public static int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n+1];
        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = 0 + dp[ind+1][prev_index +1];

                int take = 0;

                if(prev_index == -1 || nums[ind] > nums[prev_index]){

                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev_index+1] = Math.max(notTake,take);

            }
        }

        return dp[0][0];
    }
    //Space optimisation
    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[]after = new int[n + 1];
        for(int ind = n-1; ind>=0; ind --){
            int [] curr = new int[n+1];
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){
                int notTake = 0 + after[prev_index +1];

                int take = 0;

                if(prev_index == -1 || nums[ind] > nums[prev_index]){

                    take = 1 + after[ind+1];
                }

                curr[prev_index+1] = Math.max(notTake,take);

            }
            after = curr;
        }

        return after[0];
    }
    //Another Tabulation
    public static int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n+1];
        Arrays.fill(dp,1);
        for(int ind = 1; ind<n; ind ++){
            for (int prev_index = 0; prev_index <ind; prev_index ++){

              if(nums[prev_index]<nums[ind])
              {
                  dp[ind] = Math.max(1+dp[prev_index],dp[ind]);
              }
            }
        }
        int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,dp[i]);
        }

        return max;
    }
    //Printing the LIS
    public static void printLIS(int[]nums)
    {
        int n = nums.length;
        int []dp = new int[n];
        int []hash = new int[n];
        Arrays.fill(dp,1);
        int max =1;int last =1;
        for(int i=0;i<n;i++)
            hash[i]=i;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i] && (1+dp[j])>dp[i])
                {
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max)
            {
                max= dp[i];
                last = i;
            }
        }
        int []lis = new int[max];
        lis[0] =nums[last];
        int ind =1;
        while(hash[last]!=last)
        {

            last = hash[last];
            lis[ind++]=nums[last];
        }

        for(int i=lis.length-1;i>=0;i--)
        {
            System.out.println(lis[i]);
        }
    }
    public static void main(String[] args) {
int [] nums = {10,9,2,5,3,7,101,18};
printLIS(nums);
    }
}
