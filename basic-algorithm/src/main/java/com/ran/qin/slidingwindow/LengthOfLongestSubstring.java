/**
 * @Classname LengthOfLongestSubstring
 * @Description leetCode - 3 . 无重复字符的最长子串
 * @Date 2021/12/18 9:55 上午
 * @author zhangqin
 */

package com.ran.qin.slidingwindow;

import java.util.HashSet;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int len = l.lengthOfLongestSubstring_2("abcbcadef");
        System.out.println(len);
    }

    /**
     * leetCode上最快的解法
     * 思路：确定当前这个字符在串里最后一次出现的位置，另一个指针持续往后滑动，如果遇见相同的，则把子串起点挪到该字符上次出现的下一个位置，以此循环完获得最大子串
     * i是每一次判断的字符串的起点，j是每次循环的字符串终点
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


//    public int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        HashSet<Character> characters = new HashSet<Character>();
//        int right = 0, left = 0;
//        int res = 0;
//        while (right < length && left < length) {
//            if (!characters.contains(s.charAt(left))) {
//                characters.add(s.charAt(left++));
//                res = Math.max(res, left - right);
//            } else {
//                characters.remove(s.charAt(right++));
//            }
//        }
//        return res;
//    }
}
