package java_common.dp;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-08-26 10:06
 * @Description: 编辑距离问题就是给我们两个字符串 s1 和 s2，只能用三种操作，让我们把 s1 变成 s2，求最少的操作数。
 */
public class EditDistance {

    @Test
    public void distance(){
        String s1 = "distance";
        String s2 = "springbok";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<=m; i++){
            dp[i][0] = i;
        }
        for (int i=1; i<=n; i++){
            dp[0][i] = i;
        }

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else
                dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
            }
        }

        System.out.println(dp[m][n]);
    }

    @Test
    public void minDistance() {

        String word1 = "distance";
        String word2 = "springbok";

        if (word1.length() == 0  || word2.length() == 0) System.out.println(word1.length() + word2.length());

        int[][] distance = new int[word1.length()+1][word2.length()+1];

        for (int i=0; i<word1.length()+1;i++){
            distance[i][0] = i;
        }

        for (int i=0; i<word2.length()+1;i++){
            distance[0][i] = i;
        }

        for (int i=1; i<word1.length()+1; i++){
            for (int j=1; j<word2.length()+1; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    distance[i][j] = distance[i-1][j-1];
                }else{
                    distance[i][j] = Math.min(distance[i-1][j], Math.min(distance[i][j-1], distance[i-1][j-1])) + 1;
                }
            }
        }
        System.out.println(distance[word1.length()][word2.length()]);
    }
}
