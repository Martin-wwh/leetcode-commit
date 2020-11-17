package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ref : https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 */

public class SquareSumSolution {

    public int numSquares(int n) {
        int num = (int)Math.sqrt(n);
        Set<Integer> seenSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        for (int i=1; i<=num; i++){
            int square = (int)Math.pow(i,2);
            if (square == n) return count;
            queue.add(square);
            seenSet.add(square);
        }

        queue.add(null);

        while(!queue.isEmpty()){
            Integer a = queue.poll();
            if (a == null){
                count++;
                if (queue.peek() != null){
                    queue.add(null);
                }
            }else if (a == n){
                return count;
            }else {
                for (int i=1; i<=num; i++){
                    int temp = a + (int)Math.pow(i,2);
                    if (temp > n) break;
                    if (!seenSet.contains(temp)){
                        queue.add(temp);
                        seenSet.add(temp);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SquareSumSolution().numSquares(2));
    }
}
