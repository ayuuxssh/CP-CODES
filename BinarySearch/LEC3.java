package ayush.Binarrysearch;

public class LEC3 {
    public static int first(int []arr,int x)
    {
        int ans =-1;
        int low =0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>x)
            {
                high = mid-1;
            }
            else if(arr[mid]<x)
            {
                low = mid+1;
            }
            else {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public static int last(int []arr,int x)
    {
        int ans =-1;
        int low =0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>x)
            {
                high = mid-1;
            }
            else if(arr[mid]<x)
            {
                low = mid+1;
            }
            else {
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
    public static int Numberofocc(int []arr,int x)
    {
        int first = first(arr,x);
        int last = last(arr,x);
        return last-first+1;
    }
    public static void main(String[] args) {
        int []arr ={2,4,6,8,8,8,11,13};
        System.out.println(first(arr,8));
        System.out.println(last(arr,8));
        System.out.println(Numberofocc(arr,8));
    }
}
