package ayush.Binarrysearch;
import java.util.*;
public class LEC23 {
    //Linear
    public static List<Integer>maximum1(int[][]mat)
    {
        int m = mat.length;
        int n= mat[0].length;
        int max1 =-1;
        int index =-1;
        for(int i=0;i<m;i++)
        {
            int count =0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                }
            }
            if(count>max1)
            {
                max1 =count;
                index =i;
            }
        }
List<Integer>list = new ArrayList<>();
        list.add(index);
        list.add(max1);
        return list;
    }
    private static int lowerbound(int []arr,int n ,int target)
    {
        int low =0;
        int high = n-1;
        int ans = n;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>=target)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    //BinarySearch
    //Works if row is sorted
    public static List<Integer>maximum2(int[][]mat)
    {
        int m = mat.length;
        int n= mat[0].length;
        int max1 =-1;
        int index =-1;
        for(int i=0;i<m;i++)
        {
            int count = n-lowerbound(mat[i],n,1);
            if(count>max1)
            {
                max1 =count;
                index =i;
            }
        }
        List<Integer>list = new ArrayList<>();
        list.add(index);
        list.add(max1);
        return list;
    }
    public static void main(String[] args) {
       int [][] mat = {{0,1},{1,0}};
        System.out.println(maximum2(mat));
    }
}
