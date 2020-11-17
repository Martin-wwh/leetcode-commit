package java_common;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-05-19 08:50
 * @Description: 回文串
 */
public class Palindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     */
    public boolean isPalindrome(String s) {
        if ("".equals(s)){
            return true;
        }
        String simples = "";
        for (int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            String a = String.valueOf(s.charAt(i));
            String b = a.toLowerCase();
            if ((c>='a'&&c<='z') || (c>='A'&&c<='Z') || (c>='0'&&c<='9')){
                simples += b;
            }
        }
        int left = 0, right=simples.length()-1;
        while (left <= right){
            String ls = String.valueOf(simples.charAt(left));
            String rs = String.valueOf(simples.charAt(right));
            if (ls.equals(rs)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回 s 所有可能的分割方案。
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if ("".equals(s)){
            return result;
        }
        //利用动态规划 分析是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0 ; right<s.length(); right++){
            for (int left =0; left<=right; left++){
                if (s.charAt(left) == s.charAt(right) && (right-left<=2) || dp[left+1][right-1]){
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> path = new ArrayDeque<>();
        backTrack(s,0,s.length(),path,result);
        return result;
    }

    public void backTrack(String s, int start, int len, Deque<String> path, List<List<String>> res){
        //递归终止
        if (start == len){
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < len; i++) {
            //如果不是回文，此分支不存在
//            if (!checkPalindrome(s, start, i)){
//                continue;
//            }
            //动态规划
//            if (!dp[start][i]){
//            continue;
//        }

            //将满足条件的截取的字符串放入path
            path.addLast(s.substring(start, i+1));
            //继续遍历剩下的字符串
            backTrack(s,i+1,len, path, res);
            //在回溯的过程中，删除之前插入的path,使其变成对应节点下面的路径
            path.removeLast();
        }
    }

    public boolean checkPalindrome(String s, int start, int end){
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }



    @Test
    public void test(){
        System.out.println(partition("aab"));
    }
}
