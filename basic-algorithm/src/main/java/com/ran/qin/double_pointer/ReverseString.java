/**
 * @Classname ReverseString
 * @Description leetCode - 344.反转字符串
 * @Date 2021/12/15 3:33 下午
 * @author zhangqin
 */

package com.ran.qin.double_pointer;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        s = new char[]{'H','a','n','n','a','h'};
        ReverseString r = new ReverseString();
        r.solutionFirst(s);
        for (char c : s) {
            System.out.println(c);
        }
        System.out.println();
    }
    public void swap(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
    public void solutionFirst(char[] s) {
        int right = 0;
        int left = s.length -1;
        while (right < left){
           swap(s, left, right);
            right++;
            left--;
        }

    }
}

