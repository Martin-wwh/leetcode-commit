package java_common;

import java.util.Arrays;

/**
 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class CombineSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsTemp = Arrays.copyOf(nums1,m);
        int index1 = 0;
        int index2 = 0;
        for(int i=0 ; i<m+n; i++){
            if(index1 == m){
                nums1[i] = nums2[index2];
                index2++;
                continue;
            }
            if(index2 == n){
                nums1[i] = numsTemp[index1];
                index1++;
                continue;
            }
            if (numsTemp[index1] < nums2[index2]){
                nums1[i] = numsTemp[index1];
                index1++;
            }else{
                nums1[i] = nums2[index2];
                index2++;
            }

        }
    }


}
