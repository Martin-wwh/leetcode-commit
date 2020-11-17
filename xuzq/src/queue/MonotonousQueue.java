package queue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: queue
 * @Author: xuzq11
 * @CreateTime: 2020-09-24 17:02
 * @Description: 单调队列
 */
public class MonotonousQueue {

    Deque<Integer> deque = new LinkedList<>();

    public void push(int n){
        while (!deque.isEmpty() && deque.getLast() < n){
            deque.removeLast();
        }
        deque.addLast(n);
    }

    public int max(){
        return deque.getFirst();
    }

    public void pop(int n){
        if (deque.getFirst() == n){
            deque.removeFirst();
        }
    }

    //给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MonotonousQueue queue = new MonotonousQueue();
        int[] res = new int[n-k+1];
        int j=0;
        for (int i=0; i<n; i++){
            if (i<k-1){
                queue.push(nums[i]);
            }else if (i==k-1){
                queue.push(nums[i]);
                res[j++] = queue.max();
            }else  {
                queue.pop(nums[i-k]);
                queue.push(nums[i]);
                res[j++] = queue.max();
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
