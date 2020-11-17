package java_common.back;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.back
 * @Author: xuzq11
 * @CreateTime: 2020-09-25 14:20
 * @Description:
 */
public class SubSet {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        back(path,0,nums);
        return res;
    }

    public void back(List<Integer> path, int start, int[] nums){
        res.add(new ArrayList<>(path));
        for (int i=start; i<nums.length; i++){
            path.add(nums[i]);
            back(path, i+1, nums);
            path.remove(nums[i]);
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        subsets(nums);

    }
}
