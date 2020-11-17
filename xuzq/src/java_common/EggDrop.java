package java_common;

import org.junit.Test;

import java.util.Arrays;

/**
 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

 你的目标是确切地知道 F 的值是多少。

 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 */
public class EggDrop {

    /**
     * 直接动态规划，不加其他优化
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop1(int K, int N) {

        //定义一个动态规划结果数组
        int[][] dp = new int[K+1][N+1];

        //初始化数值
        for (int i=0; i<K+1;i++)
            Arrays.fill(dp[i],10000);

        //k=0 F=0
        for(int i=0; i<N+1; i++)
            dp[0][i] = 0;

        //k=1 F=N
        for (int i=0; i<N+1; i++)
            dp[1][i] = i;

        //N=0
        for (int i=0; i<K+1; i++)
            dp[i][0] = 0;

        //N=1
        for (int i=0; i<K+1; i++)
            dp[i][1] = 1;

        //从K=2，N=2开始算
        for (int i=2; i<K+1; i++){
            for (int j=2; j<N+1; j++){
                //计算第i层，选择不同的中间试验层的最优解
//                for (int k=1; k<=j; k++){
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][j-k], dp[i-1][k-1])+1);
//                }

                //二分法
                int left = 1;
                int right = j;

                while (left < right){
                    int mid = left + (right-left+1) / 2;
                    int breakCount = dp[i-1][mid-1];
                    int notBreakCount = dp[i][j-mid];
                    if (breakCount > notBreakCount){
                        right = mid - 1;
                    }else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[i][j-left], dp[i-1][left-1])+1;
            }
        }
        return dp[K][N];
    }

    @Test
    public void test(){
        System.out.println(superEggDrop1(2,6));
    }
}
