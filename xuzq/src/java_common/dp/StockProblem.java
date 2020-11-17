package java_common.dp;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-09-18 15:03
 * @Description: 股票问题
 */
public class StockProblem {

    /**
     * 最多交易k次的最大利润，同时只能操作一个
     */
    @Test
    public void test1(){
        int[] stocks = {2,1,4,5,2,9,7};
        int k = 2;
        int n = stocks.length;

        //状态数组
        int[][][] dp = new int[n+1][k+1][2];

        for (int i=0; i<k+1; i++){
            dp[0][i][1] = Integer.MIN_VALUE;
            dp[0][i][0] = 0;
        }
        for (int i=1; i<n+1; i++){
            dp[i][0][1] = Math.max(-stocks[i-1], dp[i-1][0][1]);
        }
        for (int i=1; i<n+1; i++){
            for (int j=1; j<k+1; j++ ){
                dp[i][j][0] = Math.max(dp[i-1][j-1][1] +stocks[i-1], dp[i-1][j][0] );
                dp[i][j][1] = Math.max(dp[i-1][j][0] - stocks[i-1], dp[i-1][j][1]);
            }
        }

        System.out.println(dp[n][k][0]);
    }

    /**
     * k 无限，不能同时参与多个
     */
    @Test
    public void test2(){
        int[] stocks = {1,2,3,4,5,6,7};
        int n = stocks.length;

        //状态数组 dp[i][j] i第几天， j为当前是否持有股票
        int[][] dp = new int[n+1][2];

        //初始化dp
        dp[0][1] = Integer.MIN_VALUE;

        for (int i=1; i<n+1; i++){
            dp[i][1] = Math.max(dp[i-1][0]-stocks[i-1], dp[i-1][1]);
            dp[i][0] = Math.max(dp[i-1][1]+stocks[i-1], dp[i-1][0]);
        }

        System.out.println(dp[n][0]);
    }

    /**
     * k=1
     */
    @Test
    public void test3(){
        int[] stocks = {2,1,4,5,2,9,7};

        int n = stocks.length;

        //状态数组 dp[i][j] i第几天， j为当前是否持有股票
        int[][] dp = new int[n+1][2];
        dp[0][1] = Integer.MIN_VALUE;
        //初始化 j=0就是在i天之前（包括i天）的最小的股票价格
        for (int i=1; i<n+1; i++){
            dp[i][0] = Math.max(dp[i-1][1]+stocks[i-1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1],-stocks[i-1]);
        }

        System.out.println(dp[n][0]);
    }
}
