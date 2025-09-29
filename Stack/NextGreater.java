package ayush.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int n = nums2.length;
        int m = nums1.length;
        int [] ansall = new int [m];
        int [] ans = new int [n];
        Stack<Integer>st = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.empty() && nums2[i]> st.peek()) {
                st.pop();
            }
            if(st.empty())
            {
                ans[i]=-1;
            }
            else
            {
                ans[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    ansall[i]= ans[j];
                }
            }
        }
        return ansall;
    }

    public static void main(String[] args) {
      int[]  nums1 = {4,1,2};
      int [] nums2 = {1,3,4,2};
        int [] a = nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(a));
    }
}
