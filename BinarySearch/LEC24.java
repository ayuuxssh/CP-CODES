package ayush.Binarrysearch;

public class LEC24 {
    public static boolean search(int [][]matrix,int target)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean check = false;
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]<=target && matrix[i][m-1]>=target)
            {
              check=   bs(matrix[i],target);
            }
            else
                continue;
        }
        return check;
    }
    private static boolean bs(int []arr,int target)
    {
        int low =0;
        int high = arr.length;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]==target)
                return true;
            else if(arr[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
    //More optimised
    public static boolean search1(int [][]matrix,int target)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int low =0;
        int high = (n*m)-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
       int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
        System.out.println(search1(matrix,target));
    }
}
