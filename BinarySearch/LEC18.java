package ayush.Binarrysearch;

public class LEC18 {
    //linear time
    public static int maxpage(int []arr,int k)
    {
        if(k>arr.length)
            return -1;
        int max =max(arr);
        int sum = sum(arr);
        int ans =-1;
        for(int i= max ;i<=sum;i++)
        {
            if(canwephold(arr,i,k)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    //binary search
    public static int maxpages1(int []arr,int k)
    {
        if(k>arr.length)
            return -1;
        int low =max(arr);
        int high = sum(arr);
        int ans =-1;
       while(low<=high)
       {
           int mid = (low+high)/2;
            if(canwephold(arr,mid,k)) {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;

    }

    private static boolean canwephold(int []arr,int mid,int k)
    {
        int last =arr[0];
        int count =1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]+last>mid)
            {
                count++;
                last = arr[i];
            }
            else
            {
                last +=arr[i];
            }
        }
        if(count>k)
            return false;
        return true;
    }
    private static int sum(int []arr)
    {
        int sum =0;
        for(int i=0;i<arr.length;i++)
            sum +=arr[i];
        return sum;
    }
    private static int max(int []arr)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
            max= Math.max(max,arr[i]);
        return max;
    }
    public static void main(String[] args) {
int []arr = {12, 34, 67, 90};
        System.out.println(maxpages1(arr,2));
    }
}
