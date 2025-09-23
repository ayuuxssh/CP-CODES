package ayush.DynamicProgramming;
import java.util.ArrayList;
import java.util.*;
public class LEC44 {
    public static List<Integer> largestDivisibleSubset(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int []dp = new int [n+1];
      int []hash= new int [n+1];
      Arrays.fill(dp,1);
      for(int i=0;i<n;i++)
          hash[i]=i;
      int max =1;
      int last =1;
      for(int i=1;i<n;i++)
      {
          for(int j=0;j<i;j++)
          {
              if(nums[i]%nums[j]==0 && (1+dp[j]>dp[i]))
              {
                  dp[i]= 1+dp[j];
                  hash[i]=j;
              }
          }
          if(dp[i]>max)
          {
              max = dp[i];
              last = i;
          }
      }
      List<Integer> ans = new ArrayList<>();
      ans.add(nums[last]);
      while(hash[last]!=last)
      {
          last = hash[last];
          ans.add(nums[last]);
      }
      return ans.reversed();
}
    public static void main(String[] args) {
       int [] nums = {1,2,3};
        System.out.println(largestDivisibleSubset(nums));
    }
}
