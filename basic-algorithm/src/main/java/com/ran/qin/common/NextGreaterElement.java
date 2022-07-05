/**
 * @Classname NextGreaterElement
 * @Description leetCode - 556. 下一个更大元素 III
 * @Date 2022/7/3 21:34
 * @author zhangqin
 */

package com.ran.qin.common;

public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement n = new NextGreaterElement();
        int num = 21;
        int res = n.nextGreaterElement(num);
        System.out.println(res);
    }

    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while(i >=0 && nums[i]>= nums[i+1]){
            i--;
        }
        if (i<0){
            return -1;
        }

        int j = nums.length -1;
        while(j >= 0 && nums[i]>= nums[j]){
            j--;
        }
        char temp ;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverse(nums, i+1);
        long res = Long.parseLong(new String(nums));
        return res > Integer.MAX_VALUE ? -1:(int) res;

    }
    public void reverse(char[] nums, int start){
        int i = start;
        int j = nums.length - 1;
        char temp;
        while(i < j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
