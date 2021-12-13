/**
 * @Classname MoveZero
 * @Description leetCode 283 移动零
 * @Date 2021/12/13 11:53 上午
 * @author zhangqin
 */

package com.ran.qin.double_pointer;

public class MoveZero {

    public static void main(String[] args) {
        MoveZero m = new MoveZero();
        int[] req = new int[]{0,1,0,3,12};
        int[] res = new int[]{1,3,12,0,0};
        m.solution_1(req);
    }

    public void solution_1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void solution_2(int[] nums) {

    }
}
