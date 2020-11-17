package java_common.dp;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-09-19 11:36
 * @Description: 四键键盘
 */
public class FourOps {

    @Test
    public void test(){
        int n=7;

        int[] dp = new int[n+1];
        for (int i=1; i<n+1; i++){
            dp[i] = dp[i-1] + 1;

            for (int j=2; j<i; j++){
                dp[i] = Math.max(dp[i], dp[j-2]*(i-j+1));
            }
        }

        System.out.println(dp[n]);
    }
}
