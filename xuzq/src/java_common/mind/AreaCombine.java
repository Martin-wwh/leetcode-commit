package java_common.mind;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.mind
 * @Author: xuzq11
 * @CreateTime: 2020-09-30 17:56
 * @Description: 重叠区间合并，运用贪心算法
 */
public class AreaCombine {

    int[][] intervals = {{1,4},{2,3}};

    List<Integer[]> res = new ArrayList<>();

    @Test
    public void merge() {
        TreeSet<Integer[]> intervalSet = new TreeSet<Integer[]>((a, b) -> {
            if (a[0] > b[0]) return 1;
            return -1;
        });
        for (int i=0; i<intervals.length; i++){
            Integer[] interval = new Integer[2];
            interval[0] = intervals[i][0];
            interval[1] = intervals[i][1];
            intervalSet.add(interval);
        }
        int end = intervalSet.first()[1];
        int start = intervalSet.first()[0];
        intervalSet.pollFirst();
        int count = 0;
        for (Integer[] set : intervalSet){
            if (end >= set[0] && end <= set[1]){
                end = set[1];
            }
            if (end < set[0]){
                res.add(new Integer[]{start,end});
                start = set[0];
                end = set[1];
            }
            if (count == intervalSet.size()-1){
                res.add(new Integer[]{start,end});
            }
            count++;
        }

        int[][] result = new int[res.size()][2];
        for (int i=0; i<res.size(); i++){
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }

        System.out.println(Arrays.toString(res.toArray()));
    }

    int[][] A = {{6,7},{8,13},{15,19}};
    int[][] B = {{1,2},{4,5},{11,13},{15,16},{17,19}};

    @Test
    public void intervalIntersection() {
        int indexA = 0;
        int indexB = 0;
        List<Integer[]> res = new ArrayList<>();
        while (indexA < A.length && indexB < B.length){
            while (indexA < A.length && indexB < B.length && (A[indexA][1] < B[indexB][0] || B[indexB][1] < A[indexA][0]) ){
                if (A[indexA][1] < B[indexB][0]) indexA++;
                if (indexA < A.length && B[indexB][1] < A[indexA][0]) indexB++;
            }
            if (indexB < B.length && indexA < A.length){
                int min = A[indexA][0] > B[indexB][0] ? A[indexA][0] : B[indexB][0];
                int max = A[indexA][1] < B[indexB][1] ? A[indexA][1] : B[indexB][1];
                res.add(new Integer[]{min,max});
                if (A[indexA][1] < B[indexB][1]){
                    indexA++;
                }else{
                    indexB++;
                }
            }

        }
        int[][] result = new int[res.size()][2];
        for (int i=0; i<res.size(); i++){
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }
        System.out.println(111);
//        return result;
    }
}
