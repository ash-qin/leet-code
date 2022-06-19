/**
 * @Classname FindPairs
 * @Description leetCode - 532. 数组中的 k-diff 数对
 * @Date 2022/6/16 10:01
 * @author zhangqin
 */

package com.ran.qin.sort;

import java.util.Arrays;
import java.util.HashSet;

public class FindPairs {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int k =1;
        FindPairs f = new FindPairs();
        int pairs = f.findPairs(nums, k);
        System.out.println(pairs);
    }

    public int findPairs(int[] nums, int k) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num-k)){
                res.add(num-k);
            }
            if (visited.contains(num+k)){
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }


}
