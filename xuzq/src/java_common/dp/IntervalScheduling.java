package java_common.dp;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.greed
 * @Author: xuzq11
 * @CreateTime: 2020-09-17 10:54
 * @Description: 给定一个区间集合，找到不相交的最大子集  贪心算法
 */
public class IntervalScheduling {

    //找到需要移除的下标
    @Test
    public void test(){
        Integer[][] intervals = {{1,2},{2,4},{3,4},{2,3}};
        int n = intervals.length;
//        int[] end = new int[n];
//        for (int i=0; i<n; i++){
//            end[i] = intervals[i][1];
//        }
//        Arrays.sort(end);
        TreeSet<Integer[]> intervalSet = new TreeSet<Integer[]>((a, b) -> {
            if (a[1] > b[1]) return 1;
            return -1;
        });
        for (int i=0; i<n; i++){
            intervalSet.add(intervals[i]);
        }
        List<Integer[]> res = new ArrayList<>();
//        int endTime = end[0];
//        for (int i=1; i<n; i++){
//            if (endTime > intervals[i][0]){
//                res.add(i);
//                continue;
//            }
//            endTime = intervals[i][1];
//        }
        int endTime = intervalSet.first()[1];
        intervalSet.pollFirst();
        for (Integer[] interval : intervalSet){
            if (endTime > interval[0]){
                res.add(interval);
                continue;
            }
            endTime = interval[1];
        }
        System.out.println(Arrays.toString(res.toArray()));
    }
}
