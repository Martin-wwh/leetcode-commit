package java_common;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-05-28 09:53
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Sameword {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        if (s.equals(t)){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0 ; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for (int i=0 ; i<t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                int count = map.get(t.charAt(i))-1;
                if (count == 0){
                    map.remove(t.charAt(i));
                }else{
                    map.put(t.charAt(i), count);
                }

            }else{
                return false;
            }
        }
        return map.isEmpty();

    }

    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    public int firstUniqChar(String s) {
//        for(int i=0; i<s.length()-1;i++){
//            char a = s.charAt(i);
//            if (!s.substring(i+1).contains(a+"")){
//                return i;
//            }
//        }
//        return -1;


        int n = s.length();

        for(int i='a'; i<='z';i++){
            int start = s.indexOf(i);
            int end = s.lastIndexOf(i);

            if(start == end && start != -1){
                n = Math.min(start, n);
            }
        }

        if (n == s.length()){
            return -1;
        }else{
            return n;
        }

    }
}
