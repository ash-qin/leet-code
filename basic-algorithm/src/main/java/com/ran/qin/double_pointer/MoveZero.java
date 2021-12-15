package com.ran.qin.double_pointer;


import org.junit.Assert;

/**
 * @author zhangqin
 * @Classname MoveZero
 * @Description leetCode 283 移动零
 * @Date 2021/12/13 11:53 上午
 */

public class MoveZero {

    public static void main(String[] args) {
        MoveZero m = new MoveZero();
        int[] req = new int[]{73348, 66106, -85359, 53996, 18849, -6590, -53381, -86613, -41065, 83457, 0};
        int[] res = new int[]{73348, 66106, -85359, 53996, 18849, -6590, -53381, -86613, -41065, 83457, 0};
        m.solution_2(req);
        Assert.assertArrayEquals("结果处理异常", req, res);
    }

    /**
     * 思路：把非0的项直接往前复制，然后结尾补0
     *
     * @param nums
     */
    public void solution_1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void solution_2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                //todo swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
