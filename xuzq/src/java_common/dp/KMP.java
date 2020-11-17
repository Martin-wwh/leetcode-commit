package java_common.dp;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-09-17 15:39
 * @Description: 本文用 pat 表示模式串，长度为 M，txt 表示文本串，长度为 N。KMP 算法是在 txt 中查找子串 pat，如果存在，返回这个子串的起始索引，否则返回 -1。
 */
public class KMP {

    String pat = "ABABC";

    String text = "ABABDCABABCAA";

    @Test
    public void index(){
        int N = text.length();
        int M = pat.length();

        //初始化dp
        int[][] dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        //影子状态
        int x = 0;
        for (int i=1; i<M; i++){
            for (int c=0; c<256;c++){
                dp[i][c] = dp[x][c];
            }
            dp[i][pat.charAt(i)] = i+1;
            x = dp[x][pat.charAt(i)];
        }

        //在text中搜寻下标
        int j=0;
        for (int i=0; i<N; i++){
            j = dp[j][text.charAt(i)];
            if (j == M){
                System.out.println(i-M+1);
                return;
            }
        }
        System.out.println(-1);
    }
}
