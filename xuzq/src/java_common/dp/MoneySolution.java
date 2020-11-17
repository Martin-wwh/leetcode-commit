package java_common.dp;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-08-24 16:26
 * @Description: 凑钱问题
 */
public class MoneySolution {

    @Test
    public void coinPlus(){

        int[] coins = {1,2,5};
        int target = 15;
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
        for (int i=1; i<=target; i++){
            int min = Integer.MAX_VALUE;
            for (int j=0; j<3; j++){
                int coin = coins[j];
                if (i-coin < 0) continue;
                int temp = 1 + dp[i-coin];
                if (temp < min) min = temp;
            }
            dp[i] = min;
        }

        System.out.println(dp[target]);
    }


    public String convert(String s, int numRows) {
        int length = s.length();
        int plus = length % (2*numRows -2);
        int temp = 0;
        if (plus > 0 && plus <= numRows){
            temp = 1;
        }else if (plus > numRows){
            temp = plus - numRows + 1;
        }
        int colNum = length/(2*numRows -2) * (numRows-1) + temp;

        char[][] chars = new char[numRows][colNum];

        for (int i=0; i<s.length();i++){
            int col = i / (2*numRows -2) * (numRows-1);
            int row = i % (2*numRows-2);
            if (row >= numRows){
                col = col + row - numRows + 1;
                row = 2*(numRows-1) - row;
            }
            chars[row][col] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<numRows; i++){
            for (int j=0; j<colNum; j++){
                if (chars[i][j] != '\u0000'){
                    sb.append(chars[i][j] + "");
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){

        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
}
