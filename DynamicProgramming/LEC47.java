package ayush.DynamicProgramming;

import java.util.Arrays;

public class LEC47 {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        int []count = new int[n];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);
        int max =0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && dp[j]+1>dp[i])
                {
                    dp[i] =1+dp[j];
                    count[i]=count[j];
                }
                else if(nums[i]>nums[j] && dp[j]+1 ==dp[i])
                {
                    count[i]+=count[j];
                }
            }
            if(dp[i]>max) {
                max = dp[i];
            }
        }
        int count1 =0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==max)
            {
                count1+=count[i];
            }
        }
        return count1;

    }
        public static void main(String[] args) {
          int []  nums = {1,3,5,4,7};
            System.out.println(findNumberOfLIS(nums));
    }
}
