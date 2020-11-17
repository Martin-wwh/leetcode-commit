package java_common.dp;

import java_common.sort.MaoPaoSort;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-08-24 17:51
 * @Description: 最长子序列
 */
public class LongestSequence {

    @Test
    public void longest(){
        int[] nums = {1,4,3,5,8,12,3,5,10};
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i=1; i<nums.length; i++){
            int max = Integer.MIN_VALUE;
            for (int j=0; j<i; j++){
                if (nums[j] > nums[i]) continue;
                int temp = dp[j] + 1;
                if (max < temp) max = temp;
            }
            dp[i] = max;
        }

        System.out.println(dp[3]);
    }

    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int resultLeft = 0;
        int resultRight = 0;
        int maxLength = Integer.MAX_VALUE;

        for (Character c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        while (right < s.length()){
            if (tMap.containsKey(s.charAt(right))){
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right),0) + 1);
            }
            while (left <= right && containAll()){

                int length = right-left+1;
                if (length < maxLength){
                    maxLength = length;
                    resultLeft = left;
                    resultRight = right+1;
                }

                if (tMap.containsKey(s.charAt(left))){
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left),0) - 1);
                }
                left++;


            }

            right++;
        }
        if (resultLeft == resultRight){
            return "";
        }else{
            return s.substring(resultLeft,resultRight);
        }
    }


    public boolean containAll(){
        for (Character c : tMap.keySet()){
            if (sMap.getOrDefault(c,0) < tMap.get(c)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,9,29,0,1);
        calendar.add(Calendar.MINUTE, -2);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                int len = right - left + 1;
                if (len > length) {
                    length = len;
                }
                set.add(s.charAt(right));
            }else{
                while (left < right){
                    if (s.charAt(left) == s.charAt(right)){
                        left++;
                        break;
                    }
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            right++;
        }
        return length;
    }


    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (isNum(c)){
                num = 10* num + (c - '0');
            }
            if (!isNum(c) || i == s.length()-1){
                switch(sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int temp1 = stack.pop();
                        stack.push(temp1*num);
                        break;
                    case '/':
                        int temp2 = stack.pop();
                        stack.push(temp2/num);
                        break;
                }
                sign = c;
                num = 0;

            }
        }
        int result = 0;
        for (Integer res : stack){
            result += res;
        }
        return result;
    }

    public boolean isNum(char c){
        if (c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }

}
