import java.util.*;
public class  LEC2
{
    //Lower bound-smallest index such that arr[ind]>=x
   public static int lowerbound(int []arr,int x)
   {
       int l =0;
       int h = arr.length-1;
       int ans = arr.length;
       while(l<=h)
       {
           int mid = (l+h)/2;
           if(arr[mid]>=x)
           {
               ans = mid;
               h = mid-1;
           }
           else
           {
               l = mid+1;
           }
       }
       return ans;
   }
   //Upper bound - smallest index such that arr[ind]>x
   public static int upperbound(int []arr,int x)
   {
       int l =0;
       int h = arr.length-1;
       int ans = arr.length;
       while(l<=h)
       {
           int mid = (l+h)/2;
           if(arr[mid]>x)
           {
               ans = mid;
               h = mid-1;
           }
           else
           {
               l = mid+1;
           }
       }
       return ans;
   }
    public static void main(String[] args) {
        int [] arr={3,5,8,15,19};
        System.out.println(lowerbound(arr,5));
        System.out.println(upperbound(arr,5));
    }
}