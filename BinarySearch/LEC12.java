package ayush.Binarrysearch;

public class LEC12 {
    public static int minspeed(int [] piles ,int h)
    {
        int low =1;int ans =-1;
        int high = MAX(piles);
        while(low<=high)
        {
            int mid = (low+high)/2;
            int req = required(piles, mid);
            if(req<=h) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid+1;

        }
        return ans;
    }
    private static int required(int []piles,int mid)
    {
        int total=0;
        for(int i=0;i< piles.length;i++)
        {
            double z =(double)piles[i]/mid;
            double x = Math.ceil(z);
            if(x==0)
                x=1;
         total = total+ (int)x;
        }
        return total;
    }
    private static int MAX(int []piles)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            max = Math.max(piles[i],max);
        }
        return max;
    }
    public static void main(String[] args) {
int []arr ={30,11,23,4,20};int  h = 5;
        System.out.println(minspeed(arr,h));
    }

}
