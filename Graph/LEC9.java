package ayush.Graph;

import java.util.Arrays;

public class LEC9 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        int [][]ans = image;
        int newimage = image[sr][sc];
        dfs(image,ans,sr,sc,color,newimage);
        return ans;
    }
    private static void dfs(int[][]image,int[][]ans,int sr,int sc,int color,int newimage)
    {
        ans[sr][sc]=color;
        int n= image.length;
        int m = image[0].length;
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                if(i!=0 && j!=0)
                {
                    continue;
                } int nr = sr+i;
                int nc = sc+j;
                if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==newimage && ans[nr][nc]!=color)
                {
                    dfs(image,ans,nr,nc,color,newimage);
                }
            }
        }
    }
    public static void main(String[] args) {
        int [][] image ={{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int [][]result = floodFill(image,sr,sc,color);
        System.out.println(Arrays.deepToString(result));
    }
}
