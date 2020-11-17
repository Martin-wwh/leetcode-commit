package java_common;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class WrodSplit {

    public boolean wordBreak1(String s, List<String> wordDict) {
        //暴力破解，回溯
//        return wordSplit(s, new HashSet<>(wordDict), 0);

        //BFS 构建树结构
//        Set<String> wordSet = new HashSet<>(wordDict);
//        Queue<Integer> lastVisitQueue = new LinkedList<>();
//        int[] visitList = new int[s.length()];
//        lastVisitQueue.add(0);
//        while (!lastVisitQueue.isEmpty()){
//            int start = lastVisitQueue.remove();
//            if (visitList[start] == 0){
//                for (int end=start; end<s.length(); end++){
//                    if (wordSet.contains(s.substring(start,end+1))){
//                        lastVisitQueue.add(end+1);
//                        if (end +1 == s.length()){
//                            return true;
//                        }
//                    }
//                }
//                visitList[start] = 1;
//            }
//        }
//        return false;

        //动态规划 从s中选取一个下标作为分割点，如果前者为true,且后者包含在字典内，则s就可以认为是true,同理，将前者进一步处理
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0; i<=s.length(); i++){
            for (int j=0; j<i; j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordSplit(String s, Set<String> wordDictSet, int start){
        if (start == s.length()){
            return true;
        }
        for (int i=start; i<s.length(); i++){
            if (wordDictSet.contains(s.substring(start,i+1)) && wordSplit(s,wordDictSet,i+1)){
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     *
     * 说明：
     *
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet =  new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        Deque<String> pathDeque = new LinkedList<>();
        //回溯法
//        getwordBreak(s,0,wordSet,pathDeque, result);

        //动态规划
        boolean[] dp = new boolean[s.length()];
        for (int right = 0 ; right<s.length(); right++){
            String word = s.substring(0, right+1);
            if (wordSet.contains(s.substring(0, right+1))){
                dp[right] = true;
                continue;
            }
            for (int l=0; l<right; l++){
                if (dp[l] && wordSet.contains(s.substring(l+1,right+1))){
                    dp[right] = true;
                    break;
                }
            }
        }
//        getwordBreak(s,0,wordSet,pathDeque, result);

        dfs(s,s.length()-1,wordSet,pathDeque,result,dp);

        return result;
    }

    public void getwordBreak(String s, int start, Set<String> wordSet, Deque<String> pathDeque, List<String> res){
        if (start == s.length()){
            StringBuilder sb = new StringBuilder();
            for (String path : pathDeque){
                sb.append(path + " ");
            }
            sb.deleteCharAt(sb.lastIndexOf(" "));
            res.add(sb.toString());
            return;
        }

        for (int i=start; i<s.length(); i++){
            if (!wordSet.contains(s.substring(start,i+1))){
                continue;
            }

            pathDeque.addLast(s.substring(start,i+1));
            getwordBreak(s,i+1,wordSet, pathDeque,res);
            pathDeque.removeLast();
        }
    }

    public void dfs(String s, int end, Set<String> wordSet, Deque<String> pathDeque, List<String> res, boolean[] dp){
        if (wordSet.contains(s.substring(0,end+1))){
            pathDeque.addLast(s.substring(0,end+1));

            StringBuilder sb = new StringBuilder();
            for (String path : pathDeque){
                sb.append(path + " ");
            }
            sb.deleteCharAt(sb.lastIndexOf(" "));
            res.add(sb.toString());
            pathDeque.removeLast();
        }

        for (int i=0; i<end; i++){
            if (dp[i]){
                if (wordSet.contains(s.substring(i+1,end+1))){
                    pathDeque.addLast(s.substring(i+1,end+1));
                    dfs(s,i,wordSet,pathDeque,res,dp);
                    pathDeque.removeLast();
                }

            }
        }
    }

    @Test
    public void test(){
        String[] strs = {"cat","cats","and","sand","dog"};
        List<String> wordDict = Arrays.asList(strs);
        System.out.println(wordBreak("catsanddog",wordDict));
    }
}
