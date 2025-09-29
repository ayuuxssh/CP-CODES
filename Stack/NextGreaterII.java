package ayush.Stack;
import java.util.*;
public class NextGreaterII {
    public static int[] nextGreaterElements(int[] nums)
    {
        int n = nums.length;
        int [] ans = new  int [n];
        Stack<Integer>st = new Stack<>();
        for(int i = 2*n-1;i>=0;i--)
        {
            while(!st.empty() && nums[i%n]>=st.peek())
            {
                st.pop();
            }
            if(st.empty())
            {
                ans[i%n]=-1;
            }
            else
            {
                ans[i%n]= st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
      int []  nums = {1,2,1};
      int [] ans1 = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans1));
    }
}
