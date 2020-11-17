package java_common.dp;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-09-19 13:57
 * @Description: 最长子序列
 */
public class LCS {

    @Test
    public void test(){
        String str1 = "abcde";
        String str2 = "ace";

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
