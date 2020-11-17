package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ref : https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/873/
 */

public class UnlockSolution {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        Set<String> seenSet = new HashSet<>();
        for(String deadend : deadends) deadSet.add(deadend);
        Queue<String> queue = new LinkedList<>();
        if(deadSet.contains("0000")) return -1;
        queue.add("0000");
        queue.offer(null);
        seenSet.add("0000");
        int count = 0;

        while (!queue.isEmpty()){
            String node = queue.poll();
            if (node == null){
                count++;
                if (queue.peek() != null){
                    queue.offer(null);
                }
            }else if (node.equals(target)){
                return count;
            }else {
                for (int i=0; i<4; i++){

                    for (int j=-1; j<=1; j+=2){
                        int num = Integer.parseInt(node.substring(i,i+1));
                        num = ((num+j)+10) % 10;
                        String nodeNext = node.substring(0,i) + num + node.substring(i+1);
                        if (!deadSet.contains(nodeNext) && !seenSet.contains(nodeNext)){
                            seenSet.add(nodeNext);
                            queue.offer(nodeNext);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
