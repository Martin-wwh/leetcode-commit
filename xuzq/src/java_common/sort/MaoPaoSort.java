package java_common.sort;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.sort
 * @Author: xuzq11
 * @CreateTime: 2020-06-18 17:32
 * @Description: 冒泡排序 思想：相连两项做对比，将大的换到后面，经过n-1轮，达成有序
 */
public class MaoPaoSort {

    public void sort(int[] nums){
        for (int i=0; i<nums.length-1; i++){
            for (int j=0; j<nums.length-i-1; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int num : nums){
            System.out.print(num  + "\t");
        }
    }

    //优化1 ： 判断剩下的未排序的是否有序
    public void sort1(int[] nums){
        for (int i=0; i<nums.length-1; i++){
            boolean isOrdered = true;
            for (int j=0; j<nums.length-i-1; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isOrdered = false;
                }
            }
            if (isOrdered){
                break;
            }
        }
        for (int num : nums){
            System.out.print(num  + "\t");
        }
    }

    //优化2 ： 记录到数组末尾的最长数组长度，缩短更新截至下标
    public void sort2(int[] nums){
        int maxOrderedLength = nums.length-1;
        //最后更新的下表
        int lastIndex = 0;
        for (int i=0; i<nums.length-1; i++){
            boolean isOrdered = true;

            for (int j=0; j<maxOrderedLength; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isOrdered = false;
                    lastIndex = j;
                }
            }
            maxOrderedLength = lastIndex;
            if (isOrdered){
                break;
            }
        }
        for (int num : nums){
            System.out.print(num  + "\t");
        }
    }

    //优化3 ： 鸡尾酒排序， 正序进行一次冒泡，再反序进行一次冒泡，这算一轮
    public void sort3(int[] nums){

        for (int i=0; i<nums.length-1; i++){
            boolean isOrdered = true;

            for (int j=0; j<nums.length-i-1; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isOrdered = false;
                }
            }
            if (isOrdered){
                break;
            }

            isOrdered = true;
            for (int k=nums.length-i-1; k>i; k--){
                if (nums[k-1] > nums[k]){
                    int temp = nums[k];
                    nums[k] = nums[k-1];
                    nums[k-1] = temp;
                    isOrdered = false;
                }
            }
            if (isOrdered){
                break;
            }
        }
        for (int num : nums){
            System.out.print(num  + "\t");
        }
    }

    @Test
    public void test() {
        int[] nums = {2,5,4,17,6,2,45,81,7,14};
        sort3(nums);
    }
}
