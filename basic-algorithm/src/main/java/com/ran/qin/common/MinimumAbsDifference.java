/**
 * @Classname MinimumAbsDifference
 * @Description leetCode - 1200. 最小绝对差
 * @Date 2022/7/4 21:34
 * @author zhangqin
 */

package com.ran.qin.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {

    public static void main(String[] args) {
        MinimumAbsDifference m = new MinimumAbsDifference();
        int[] arr = {4,2,1,3};
        List<List<Integer>> lists = m.minimumAbsDifference(arr);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int temp = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            int mid = arr[i + 1] - arr[i];
            if (mid < temp){
            temp = mid;
            res.clear();
            List<Integer> r = new ArrayList<>();
            r.add(arr[i]);
            r.add(arr[i+1]);
            res.add(r);
            }else if (mid == temp){
                List<Integer> r = new ArrayList<>();
                r.add(arr[i]);
                r.add(arr[i+1]);
                res.add(r);
            }
        }
        return res;
    }
}
