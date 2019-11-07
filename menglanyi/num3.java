package leetcode;

/**
 * 求字符串中不重复的最长子串
 */
public class num3 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        //当前位置
        int now = 0;
        //最长字串的长度
        int size = 0;
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            // 这里IndexOf 里面还有层循环 可以改为map的形式
            int m = s.indexOf(s.charAt(j), now);
            if (m > -1 && m < j) {
                now = m + 1;
                size = j - m;
                if(max<size){
                    max=size;
                }
            } else {
                size++;
                if(max<size){
                    max=size;
                }
            }
        }
        return max;
    }
}
