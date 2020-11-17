package java_common.dp;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-11-06 15:31
 * @Description:
 */
public class FindFlights {


    int res = Integer.MAX_VALUE;
    int dst;
    int[][] prices;
    int n;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        this.n = n;
        this.dst = dst;
        prices = new int[n][n];
        for (int[] flight: flights){
            prices[flight[0]][flight[1]] = flight[2];
        }
        res = prices[src][dst] == 0 ? res : prices[src][dst];
        Set<Integer> seen = new HashSet<>();
        seen.add(src);
        backtrack(src, K, 0, seen);
        return res;
    }

    public void backtrack(int startCity, int left, int sum, Set<Integer> seen){
        if (startCity == dst){
            if (sum < res) res = sum;
            return;
        }
        if (left < 0) return;
        for (int i=0; i<n; i++){
            if (prices[startCity][i] == 0 || seen.contains(i)) continue;
            left--;
            sum += prices[startCity][i];
            seen.add(i);
            backtrack(i, left, sum, seen);
            seen.remove(i);
            left++;
            sum -= prices[startCity][i];
        }
    }

    @Test
    public void test(){
        int n= 10;
        int[][] flights = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}};
        int src = 6;
        int dst = 0;
        int k= 7;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));;
    }
}
