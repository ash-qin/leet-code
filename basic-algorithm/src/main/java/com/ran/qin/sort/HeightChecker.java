/**
 * @Classname HeightChecker
 * @Description leetCode - 1051. 高度检查器
 * @Date 2022/6/13 10:42
 * @author zhangqin
 */

package com.ran.qin.sort;

import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        HeightChecker h = new HeightChecker();
        int[] req1 = {5, 1, 2, 3, 4};
        int[] req2 = {5, 1, 2, 3, 4};
        System.out.println(h.heightCheckerOne(req1));
        System.out.println(h.heightCheckerTwo(req2));
    }

    public int heightCheckerOne(int[] heights) {
        int temp = heights[0];
        int[] res = new int[heights.length];
        System.arraycopy(heights, 0, res, 0, heights.length);
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public int heightCheckerTwo(int[] heights) {
        int count = 0;
        int max = Arrays.stream(heights).max().getAsInt();
        int[] template = new int[max + 1];
        for (int height : heights) {
            template[height]++;
        }
        int index = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= template[i]; j++) {
                if (heights[index] != i){
                    count++;
                }
                index++;
            }
        }
        return count;
    }
}
