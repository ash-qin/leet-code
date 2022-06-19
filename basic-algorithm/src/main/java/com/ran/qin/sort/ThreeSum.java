/**
 * @Classname ThreeSum
 * @Description leetCode - 15. 三数之和
 * @Date 2022/6/16 21:41
 * @author zhangqin
 */

package com.ran.qin.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> lists = t.threeSum(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length == 0 || nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums[0] > 0) {
            return new ArrayList<>();
        }

        for (int first = 0; first < nums.length; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;

            }
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    continue;
                }
                if (nums[second] + nums[third] + nums[first] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }

        }
        return res;
    }
}
