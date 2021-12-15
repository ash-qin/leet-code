/**
 * @Classname TwoSum
 * @Description leetCode - 167. 两数之和
 * @Date 2021/12/15 2:38 下午
 * @author zhangqin
 */

package com.ran.qin.double_pointer;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0};
        TwoSum t = new TwoSum();
        int[] solution = t.solutionFirst(nums, -1);
        solution = t.solutionSecond(nums, -1);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    public int[] solutionFirst(int[] numbers, int target) {
        int right = 0;
        int left = 1;
        while (right < numbers.length) {
            if (left >= numbers.length) {
                right++;
                left = right + 1;
                continue;
            }
            if (numbers[right] + numbers[left] == target) {
                return new int[]{right + 1, left + 1};
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] solutionSecond(int[] numbers, int target) {
        int right = 0;
        int left = numbers.length - 1;
        while (right < left) {
            if (numbers[right] + numbers[left] < target) {
                right++;
            } else if (numbers[right] + numbers[left] > target) {
                left--;
            } else {
                return new int[]{right + 1, left + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
