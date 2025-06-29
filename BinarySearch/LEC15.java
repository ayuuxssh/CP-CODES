package ayush.Binarrysearch;

public class LEC15 {
    public  static int shipWithinDays(int[] weights, int days)
    {
        int low = max(weights);
        int high = sum(weights);
        int ans =-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int req = possible(weights,mid);
            if(req<=days)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low =mid+1;
        }
        return ans;
    }
    private static int max(int []weights)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++)
            max = Math.max(max,weights[i]);
        return max;
    }
    private static int sum (int [] weights)
    {
        int sum =0;
        for(int i=0;i< weights.length;i++)
        {
            sum +=weights[i];
        }
        return sum;
    }
    private static int possible(int []weights,int mid)
    {
        int day =1;int  load=0;
        for(int i=0;i< weights.length;i++)
        {
            if(load+weights[i]>mid)
            {
                day = day+1;
                load = weights[i];
            }
            else
            {
                load += weights[i];
            }
        }
        return day;
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr,5));

    }
}
