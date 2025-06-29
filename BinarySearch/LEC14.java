package ayush.Binarrysearch;

public class LEC14 {
    public static int threshold(int [] nums,int threshold)
    {
        int low = 1;
        int high = max(nums);
        int ans =1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(possible(nums,mid,threshold))
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    private static int max(int [] nums)
    {
        int max =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    private static boolean possible(int [] nums,int mid ,int threshold)
    {
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            double x = (double) nums[i]/mid;
            total = total+(int)Math.ceil(x);
        }
        if(total<=threshold) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
int [] arr ={1,2,5,9};
        System.out.println(threshold(arr,6));
    }
}
