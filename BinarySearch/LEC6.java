package ayush.Binarrysearch;

public class LEC6 {
    public static int min(int []nums)
    {
        int low =0;
        int ans = Integer.MAX_VALUE;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid])
            {
                ans = Math.min(nums[low],ans);
                low = mid+1;
            }
            else
            {
                ans = Math.min(nums[mid],ans);
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr={7,8,1,2,3,4,5,6};
        System.out.println(min(arr));
    }
}
