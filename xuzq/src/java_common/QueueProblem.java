package java_common;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-06-18 10:41
 * @Description:
 */
public class QueueProblem {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums){
            queue.add(num);
            if (queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
