package java_common.sort;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.sort
 * @Author: xuzq11
 * @CreateTime: 2020-08-17 16:07
 * @Description: 希尔排序
 */
public class XierSort {

    int[] nums;

    public void sort(){
        int length = nums.length;
        int i, j;
        int h = length / 2;
        while(h>=1){
            for (i=h; i<length; i++){
                int temp = nums[i];
                j = i-h;
                while (j>=0 && nums[j] > temp){
                    nums[j+h] = nums[j];
                    j = j-h;
                }
                nums[j+h] = temp;
            }
            h = h/2;
        }
    }

    @Test
    public void test() {
        nums = new int[]{2,5,4,17,6,2,45,81,7,14};
        sort();
        for (int num : nums){
            System.out.print(num  + "\t");
        }
    }
}
