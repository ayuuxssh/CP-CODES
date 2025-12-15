package ayush.Graph;
//Surrounding Regions //Replace O with X
public class LEC14 {
    public  static void solve(char[][] board)
    {
        int n = board.length;
        int m = board[0].length;
        boolean [][]vis = new boolean[n][m];
        for(int i=0;i<m;i++)
        {
            if(!vis[0][i] && board[0][i]=='O')
            {
                dfs(board,vis,0,i);
            }
            if(!vis[n-1][i] && board[n-1][i]=='O')
            {
                dfs(board,vis,n-1,i);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i][0] && board[i][0]=='O')
            {
                dfs(board,vis,i,0);
            }
            if(!vis[i][m-1] && board[i][m-1]=='O')
            {
                dfs(board,vis,i,m-1);
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] &&  board[i][j]=='O')
                    board[i][j]='X';
                System.out.println(board[i][j]);
            }
            System.out.println();
        }

    }
    private  static void dfs(char[][] board, boolean [][]vis,int row ,int col)
    {
        int n = board.length;
        int m = board[0].length;
        vis[row][col]= true;
        for(int d =-1;d<=1;d++)
        {
            for(int e=-1;e<=1;e++)
            {
                if(d!=0 && e!=0)
                    continue;
                int nr = row+d;
                int nc = col+e;
                if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='O' && !vis[nr][nc])
                {
                    dfs(board,vis,nr,nc);
                }
            }
        }

    }
    public static void main(String[] args) {
 char [][] board ={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);

    }
}
