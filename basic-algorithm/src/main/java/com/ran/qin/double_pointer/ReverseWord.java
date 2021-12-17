/**
 * @Classname ReverseWord
 * @Description leetCode - 557 . 反转字符串中的数组
 * @Date 2021/12/16 9:46 上午
 * @author zhangqin
 */

package com.ran.qin.double_pointer;

public class ReverseWord {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWord r = new ReverseWord();
        String s1 = r.solutionFirst(s);
        System.out.println(s1);
    }

    public String solutionFirst(String s) {
        StringBuffer res = new StringBuffer();
        int right = 0;
        while (right < s.length()) {
            int left = right;
            while (left < s.length() && s.charAt(left) != ' ') {
                left++;
            }
            //swap
            for (int i = left - 1; i >= right; i--) {
                res.append(s.charAt(i));
            }
            if (left < s.length() && s.charAt(left) == ' ') {
                res.append(' ');
            }
            right = left + 1;
        }
        return res.toString();
    }
}