package java_common.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-08-26 11:53
 * @Description:
 */
public class LongestHuiwen {


    //最长回文子序列
    @Test
    public void huiwen(){

        String s = "aacabdkacaa";

        int[][] dp = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++){
            dp[i][i] = 1;
        }


        for (int i=s.length()-1; i>=0; i--){
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[0][s.length()-1]);
    }


    //最长回文子串
    @Test
    public void longestPalindrome() {
        String s = "aaaa";
        String result = s.substring(0,1);
        int length = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = true;
            if (i>0 && s.charAt(i) == s.charAt(i-1)){
                dp[i][i-1] = true;
            }
        }
        for (int i=n-2; i>=0; i--){
            for (int j=i+1; j<n; j++){
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    int len = j+1-i;
                    if (len > length){
                        length = len;
                        result = s.substring(i,j+1);
                    }
                }
            }
        }
        System.out.println(result);
//        return result;
    }

}
