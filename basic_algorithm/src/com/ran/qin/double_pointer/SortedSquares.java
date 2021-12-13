/**
 * @Classname SortedSquares
 * @Description leetCode 有序数组的平方 977
 * @Date 2021/12/1 8:29 下午
 * @author zhangqin
 */

package com.ran.qin.double_pointer;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{-5, -3, -2, -1};
        SortedSquares sortedSquares = new SortedSquares();
        int[] ints = sortedSquares.sortedSquares(nums);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    public int[] sortedSquares(int[] nums) {
        int negative = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative = i;
            }else {
                break;
            }
        }
        int mid = negative + 1;
        int index = 0;
        int[] ans = new int[nums.length];
        while (mid < nums.length || negative >= 0) {
            if (negative < 0) {
                ans[index] = nums[mid] * nums[mid];
                ++mid;
            } else if (mid == nums.length) {
                ans[index] = nums[negative] * nums[negative];
                --negative;
            } else if (nums[mid] * nums[mid] < nums[negative] * nums[negative]) {
                ans[index] = nums[mid] * nums[mid];
                ++mid;
            } else {
                ans[index] = nums[negative] * nums[negative];
                --negative;
            }
            index++;
        }
        return ans;
    }
}
