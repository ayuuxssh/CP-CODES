package ayush.Binarrysearch;

public class LEC4 {
    public static int rotated(int []arr,int x)
    {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]==x)
            {
                return mid;
            }
            if(arr[low]<arr[mid])
            {
                if(arr[low]<=x && x<=arr[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                if(arr[mid]<=x && x<=arr[high])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = { 4,5,6,7,0,1,2};
        System.out.println(rotated(arr,7));
    }
}
