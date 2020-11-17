package java_common.dp;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-08-26 14:51
 * @Description: 博弈问题
 */
public class GameSolution {

    class Node{
        //先手能获取的最大数目
        int first;
        //后手能获取的最大数目
        int second;
    }

    @Test
    public void game(){
        int[] piles = {3,9,1,2};
        int n = piles.length;
        Node[][] dp = new Node[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                dp[i][j] = new Node();
            }
        }
        for (int i=0; i<n; i++){
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }

        for (int i=n-2; i>=0; i--){
            for (int j=i+1; j<n; j++){
                int right = dp[i][j-1].second+piles[j];
                int left = dp[i+1][j].second+piles[i];
                if (left > right){
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i+1][j].first;
                }else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j-1].first;
                }

            }
        }
        Node node = dp[0][n-1];
        System.out.println(node.first-node.second);
    }
}
