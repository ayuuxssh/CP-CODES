package ayush.Binarrysearch;
import java.util.*;
public class LEC26 {
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low =0;
        int high = m-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int row = maxElement(mat,n,m,mid);
            int left = mid-1>=0?mat[row][mid-1]:-1;
            int  right = mid+1<m?mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid]>right)
            {
                return new int[]{row,mid};
            }
            else if(mat[row][mid]<left)
                high = mid-1;
            else
                low = mid+1;
        }
        return new int[]{-1,-1};
    }
    private static int maxElement(int[][]mat,int n ,int m ,int mid)
    {
        int max1 =mat[0][mid];
        int index =0;
        for(int i=1;i<n;i++)
        {
            if(mat[i][mid]>max1)
            {
                max1= mat[i][mid];
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
  int [][] matrix ={{10,20,15},{21,30,14},{7,16,32}};
  int[]ans =findPeakGrid(matrix);
        System.out.println(Arrays.toString(ans));
    }
}
