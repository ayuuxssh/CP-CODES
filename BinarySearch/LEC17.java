package ayush.Binarrysearch;
import java.util.*;
public class LEC17 {
    //Linear approach
    public static  int mindistace(int []stalls,int k)
    {
        Arrays.sort(stalls);
        int ans =-1;
        for(int i=1;i<=(stalls[stalls.length-1]-stalls[0]);i++)
        {
            if(canweplace(stalls,i,k))
            {
                ans =i;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
    //binary search
    public static int mindistance1(int []stalls,int k)
    {

        Arrays.sort(stalls);
        int ans =-1;
     int low =1;
     int high = stalls[stalls.length-1]-stalls[0];
     while(low<=high)
        {
            int mid = (low+high)/2;

            if(canweplace(stalls,mid,k))
            {
                ans =mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    private static boolean canweplace(int []stalls,int mid,int k)
    {
        int countcow=1;
        int last =stalls[0];
        for(int i=1;i< stalls.length;i++)
        {
            if(stalls[i]-last>=mid)
            {
                countcow++;
                last = stalls[i];
            }
            else
                continue;
        }
        if(countcow>=k)
            return true;
        return false;
    }
    public static void main(String[] args) {
int [] arr={1, 2, 4, 8, 9};
        System.out.println(mindistance1(arr,3));
    }
}
