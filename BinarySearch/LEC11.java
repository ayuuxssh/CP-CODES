package ayush.Binarrysearch;

public class LEC11 {
    public static long root(int n,int m)
    {
        long high =m;
        long low =1;
        while(low<=high)
        {
            long mid = (low+high)/2;
            if(Math.pow(mid,n)==m)
                return mid;
            else if(Math.pow(mid,n)<m) {
                low = mid + 1;
            }
            else
                high = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(root(3,64));
    }
}
