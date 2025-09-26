package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC46 {
    public static int LongestBitonicSequence(int n, int[] nums)
    {
        int []dp = new int [n];
        int []dp1= new int [n];
        int []bitonic = new int [n];
        Arrays.fill(dp,1);
        Arrays.fill(dp1,1);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && dp[j]+1>dp[i])
                {
                    dp[i] = 1+dp[j];
                }
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(nums[i]>nums[j] && dp1[j]+1>dp1[i])
                {
                    dp1[i]= dp1[j]+1;
                }
            }
        }
        int max =0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]>1 && dp1[i]>1) {
                bitonic[i] = dp[i] + dp1[i] - 1;
            }
            if(bitonic[i]>max)
                max= bitonic[i];

        }
        return max;
    }
    public static void main(String[] args) {
       int n = 5;
       int []nums = {1, 2, 5, 3, 2};
        System.out.println(LongestBitonicSequence(n,nums));
    }
}
