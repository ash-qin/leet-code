/**
 * @Classname Rotate
 * @Description leetCode 轮转数组 189
 * @Date 2021/12/1 8:44 下午
 * @author zhangqin
 */

package com.ran.qin.double_pointer;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
       int[] nums =new int[]{-1,-100,3,99};
       Rotate t = new Rotate();
       t.rotate(nums, 2);
        for (int anInt : nums) {
            System.out.println("anInt = " + anInt);
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] result = nums.clone();
        for (int i = 0; i < length; i++) {
            if(i + k <length -1){
                nums[i + k] = result[i];
            }else {
                nums[(i +k) % (length)] = result[i];
            }
        }

    }
}
