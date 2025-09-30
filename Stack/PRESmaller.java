package ayush.Stack;

import java.util.Arrays;
import java.util.Stack;

public class PRESmaller {
    public  static int[] smaller(int[]nums)
    {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int [] ans =new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.empty() && nums[i]<=st.peek())
                st.pop();
            if(st.empty())
                ans[i]=-1;
            else
                ans[i]= st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
int [] nums= {4,5,2,10,8};
int [] ansall = smaller(nums);
        System.out.println(Arrays.toString(ansall));
    }
}
