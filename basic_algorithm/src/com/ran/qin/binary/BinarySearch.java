/**
 * @Classname BinarySearch
 * @Description 二分查找 leetCode 704
 * @Date 2021/11/27 3:50 下午
 * @author zhangqin
 */

package com.ran.qin.binary;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
        if (nums[0] == target){
            return 0;
        }
        if (nums[end] == target){
            return end;
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
        return -1;
    }

}
