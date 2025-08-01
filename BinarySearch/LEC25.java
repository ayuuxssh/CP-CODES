package ayush.Binarrysearch;

public class LEC25 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m-1;
        while(row<n && col>=0)
        {
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]<target)
                row++;
            else
                col--;
        }
        return false;
    }
    public static void main(String[] args) {
int [][]matrix ={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
};
        System.out.println(searchMatrix(matrix,5));
    }
}
