package java_common.tree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-22 14:15
 * @Description: 第K大的数
 */
public class KthLargest {

    int k;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i=0; i<nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (queue.size() < k){
            queue.add(val);
        }else if (val > queue.peek()){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }



}
