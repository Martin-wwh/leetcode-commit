package java_common.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.sort
 * @Author: xuzq11
 * @CreateTime: 2020-09-30 10:35
 * @Description:
 */
public class PanCakeSort {

    List<Integer> res = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    public void sort(int[] arr, int n){
        if (n == 1) return;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i=0; i<n; i++){
            int num = arr[i];
            if (num > max){
                maxIndex = i;
                max = num;
            }
        }
        reserve(arr, maxIndex);
        res.add(maxIndex+1);
        reserve(arr,n-1);
        res.add(n);
        sort(arr,n-1);
    }

    public void reserve(int[] arr, int n){
        int i=0, j=n;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test(){
        int[] arr = {3,2,4,1};
        pancakeSort(arr);
    }
}
