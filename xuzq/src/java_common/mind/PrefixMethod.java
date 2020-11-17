package java_common.mind;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.mind
 * @Author: xuzq11
 * @CreateTime: 2020-09-30 14:42
 * @Description: 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/continuous-subarray-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrefixMethod {

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i=0; i<nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                int subSum = sum[j+1] - sum[i+1] + nums[i];
                if (subSum == k || (k != 0 && subSum % k == 0)){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = {0,1,0};
        int k=0;
        System.out.println(checkSubarraySum(nums, k));
    }
}
