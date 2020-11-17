package java_common.mind;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.mind
 * @Author: xuzq11
 * @CreateTime: 2020-10-09 16:04
 * @Description: 数组去重
 */
public class DeweightNums {

    int[] nums = {0,0,1,2,2,4,4,5,6,7,7};

    @Test
    public void deweight(){
        int slow = 0;
        int fast = 1;
        while (fast < nums.length){
            if (nums[fast] != nums[fast-1]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        for (int i=0; i<=slow; i++){
            System.out.println(nums[i]);
        }
    }
}
