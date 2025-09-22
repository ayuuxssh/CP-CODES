package ayush.DynamicProgramming;

import java.util.*;

public class LEC43
{
    public static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<n;i++)
        {
            if(nums[i]>ans.get(ans.size()-1))
            {
                ans.add(nums[i]);
            }
            else
            {
                int x = Collections.binarySearch(ans,nums[i]);
                if(x<0)
                {
                    x = -x-1;
                }
                ans.set(x,nums[i]);
            }
        }
        return ans.size();
    }
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
