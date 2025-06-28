package ayush.Binarrysearch;

public class LEC13 {
    public static int mindays(int [] bloomDay,int m ,int k)
    {
        int n = bloomDay.length;
        if(m*k>n)
            return -1;
        int ans =-1;
        int low = min(bloomDay);
        int high = max(bloomDay);
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(possible(bloomDay,m,k,mid)) {
                ans = mid;
                high = mid - 1;
            }else
                low = mid+1;

        }
        return ans;
    }
    private static int max(int []bloomDay)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i< bloomDay.length;i++)
            max = Math.max(bloomDay[i],max);
        return max;
    }
    private static int min(int []bloomDay)
    {
        int min = Integer.MAX_VALUE;
        for(int i=0;i< bloomDay.length;i++)
            min = Math.min(bloomDay[i],min);
        return min ;
    }
    public static boolean possible(int []bloomDay,int m ,int k,int mid)
    {
        int total =0;
        int count =0;
        for(int i=0;i< bloomDay.length;i++)
        {
            if( bloomDay[i]<=mid)
                count++;
            else
            {
                total = total+count/k;
                count=0;
            }
        }
        if(count!=0)
        {
            total += count/k;
        }
        if(total>=m)
            return true;
        return false;
    }
    public static void main(String[] args) {
int [] arr={7,7,7,7,13,11,12,7};
        System.out.println(mindays(arr,2,3));
    }
}
