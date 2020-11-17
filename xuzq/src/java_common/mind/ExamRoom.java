package java_common.mind;

import java.util.TreeSet;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.mind
 * @Author: xuzq11
 * @CreateTime: 2020-10-10 09:35
 * @Description:
 */
class ExamRoom {

    TreeSet<Integer[]> emptySet;
    int N;

    public ExamRoom(int N) {
        emptySet = new TreeSet<>((a, b) -> {
            int distA = distance(a);
            int distB = distance(b);
            if (distA == distB)
                return b[0] - a[0];
            return distA - distB;
        });
        this.N = N;
        Integer[] seat = new Integer[]{-1,N};
        emptySet.add(seat);
    }

    public int seat() {
        Integer[] dist = emptySet.last();
        int x = dist[0];
        int y = dist[1];
        int seatIndex = -1;
        if (x == -1){
            seatIndex = 0;
        }else if (y == N){
            seatIndex = N-1;
        }else {
            seatIndex = (y+x)/2;
        }
        Integer[] dist1 = new Integer[]{x, seatIndex};
        Integer[] dist2 = new Integer[]{seatIndex,y};
        emptySet.pollLast();
        emptySet.add(dist1);
        emptySet.add(dist2);
        return seatIndex;
    }

    public void leave(int p) {
        Integer[] left = new Integer[2];
        Integer[] right = new Integer[2];
        for (Integer[] interval : emptySet){
            if (interval[0] == p) {
                right = interval;
            }
            if (interval[1] == p){
                left = interval;
            }
        }
        Integer[] newInterval = new Integer[]{left[0],right[1]};
        emptySet.remove(left);
        emptySet.remove(right);
        emptySet.add(newInterval);
    }

    public int distance(Integer[] dist){
        int x = dist[0];
        int y = dist[1];
        if (x == -1) return y / 2;
        if (y == N) return (N-1-x)/2;
        return (y-x)/2;
    }
}