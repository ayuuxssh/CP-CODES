package ayush.Binarrysearch;

public class LEC16 {
    public static int missing(int [] nums,int k)
    {
        int [] missing = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            missing[i] = nums[i]-(i+1);
        }
        int low =0;int high = nums.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(missing[mid]<k)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return high+k+1;
    }
    public static void main(String[] args) {
        int[] arr ={2,3,4,7,11};
        System.out.println(missing(arr,5));
    }
}
