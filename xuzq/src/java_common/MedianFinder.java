package java_common;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-06-18 13:48
 * @Description: 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 */
class MedianFinder {

    List<Integer> nums;

    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new LinkedList<>();
    }

    public void addNum(int num) {
        if (nums.size() == 0){
            nums.add(num);
        }else {
            int index = -1;
            for (int i=0; i<nums.size(); i++){
                if (num < nums.get(i)){
                    index = i;
                    break;
                }
            }
            if (index == -1) index = nums.size() + 1;
            nums.add(index, num);
        }
    }

    public double findMedian() {
        int length = nums.size();
        if (length % 2 == 0){
            return ((double)(nums.get(length / 2) + nums.get(length / 2 -1 ))) / 2 ;
        }else {
            return nums.get(length / 2);
        }
    }

    @Test
    public void test(){
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        double param_2 = obj.findMedian();
    }
}