package com.ran.qin.binary;

/**
 * @Classname SearchInsert
 * @Description leetCode 35
 * @Date 2021/11/27 8:34 下午
 * @author zhangqin
 */


public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        int[] nums = new int[]{1};
        int target = 0;
        int i = s.searchInsert(nums, target);
        System.out.println(i);
    }
    public int searchInsert(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
        if (nums[0] == target || nums[0] > target){
            return 0;
        }
        if (nums[end] == target){
            return end;
        }
        if (nums[end] < target){
            return end +1;
        }
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if (target > nums[mid]){
                start = mid +1;
            }else if (target < nums[mid]){
                end = mid - 1 ;
            }else {
                return mid;
            }
        }
        return start;
    }
}
