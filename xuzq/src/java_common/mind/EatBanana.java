package java_common.mind;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.mind
 * @Author: xuzq11
 * @CreateTime: 2020-10-09 15:13
 * @Description: https://leetcode-cn.com/problems/koko-eating-bananas/
 */
public class EatBanana {

    int[] piles = {30,11,23,4,20};
    int H = 6;

    //二分法寻找左边界
    @Test
    public void minEatingSpeed() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<piles.length; i++){
            if (piles[i] < min) min = piles[i];
            if (piles[i] > max) max = piles[i];
        }
        while (min < max) {
            int mid = (min + max) / 2;
            int spentHours = 0;
            for (int pile : piles){
                spentHours += (pile / mid) + (pile % mid == 0 ? 0 : 1);
            }
            if (spentHours > H){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        System.out.println(min);
    }
}
