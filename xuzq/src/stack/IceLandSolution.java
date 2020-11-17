package stack;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * ref : https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/883/
 */

public class IceLandSolution {

    int rows=0;
    int cols=0;

    public int numIslands(char[][] grid) {

        rows = grid.length;

        if(rows == 0){
            return 0;
        }
        cols = grid[0].length;

        int count = 0;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }


    public void dfs(int i, int j, char[][] grid){
        if(isOut(i-1,j) && grid[i-1][j] == '1'){
            grid[i-1][j] = '0';
            dfs(i-1,j,grid);
        }
        if(isOut(i,j-1) && grid[i][j-1] == '1'){
            grid[i][j-1] = '0';
            dfs(i,j-1,grid);
        }
        if(isOut(i,j+1) && grid[i][j+1] == '1'){
            grid[i][j+1] = '0';
            dfs(i,j+1,grid);
        }
        if(isOut(i+1,j) && grid[i+1][j] == '1'){
            grid[i+1][j] = '0';
            dfs(i+1,j,grid);
        }
    }


    public boolean isOut(int x, int y){
        if (x>=rows || x<0 || y<0 || y>=cols){
            return false;
        }
        return true;
    }
}
