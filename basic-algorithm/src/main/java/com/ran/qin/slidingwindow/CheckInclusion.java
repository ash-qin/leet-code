/**
 * @Classname CheckInclusion
 * @Description leetCode - 567 . 字符串的排列
 * @Date 2021/12/20 10:35 上午
 * @author zhangqin
 */

package com.ran.qin.slidingwindow;

import java.util.Arrays;

public class CheckInclusion {

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        boolean b = c.checkInclusion_2("ab", "eidboaooo");
        System.out.println(b);
    }

    public boolean checkInclusion_1(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int[] attr1 = new int[26];
        int[] attr2 = new int[26];
        for (int i = 0; i < length1; i++) {
            attr1[s1.charAt(i) - 'a']++;
            attr2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(attr1, attr2)) {
            return true;
        }
        for (int i = length1; i < length2; i++) {
            attr2[s2.charAt(i) - 'a']++;
            attr2[s2.charAt(i - length1) - 'a']--;
            if (Arrays.equals(attr1, attr2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion_2(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int[] index = new int[26];
        for (int i = 0; i < length1; i++) {
            index[s1.charAt(i) - 'a']++;
            index[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i : index) {
            if (i != 0){
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = length1; i < length2; i++) {
            int x = s2.charAt(i - length1) - 'a';
            int y = s2.charAt(i) - 'a';
            if (x == y){
                continue;
            }
            if (index[y] == 0){
                diff++;
            }
            index[y]--;
            if (index[y] == 0){
                diff--;
            }
            if (index[x] == 0){
                diff++;
            }
            index[x]++;
            if (index[x] == 0){
                diff--;
            }
            if (diff == 0){
                return true;
            }

        }
        return false;
    }
}
