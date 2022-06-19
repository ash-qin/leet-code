/**
 * @Classname SmallestDistancePair
 * @Description leetCode - 719. 找出第 K 小的数对距离
 * @Date 2022/6/15 10:18
 * @author zhangqin
 */

package com.ran.qin.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmallestDistancePair {

    public static void main(String[] args) {
        SmallestDistancePair s = new SmallestDistancePair();
        int[] nums = {1, 4, 7, 10};
        int k = 2;
        int i = s.smallestDistancePair(nums, k);
        System.out.println(i);
    }

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (right + left) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {

                // diff = right - left -> right = left - diff
                //此处left = i diff = mid 因为递增，所以可以找到离第i个差值最接近mid的下标
                int j = binarySearch(nums, i, nums[i] - mid);
                //说明当前队列当次离mid最接近的diff 有多少个
                count += i - j;
            }
            //如果大于k 说明diff 太大要缩小
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public int binarySearch(int[] nums, int end, int target) {
        int left = 0;
        int right = end;

        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
