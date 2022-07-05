/**
 * @Classname MinCost
 * @Description leetCode - 剑指 Offer II 091. 粉刷房子
 * @Date 2022/6/25 22:04
 * @author zhangqin
 */

package com.ran.qin.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCost {

    public static void main(String[] args) {
        int[][] costs= {{17,2,17},{16,16,5},{14,3,19}};

        MinCost m = new MinCost();
        int i = m.minCost(costs);
        System.out.println(i);
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int dp[] =new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int depNew[] = new int[3];
            for (int j = 0; j < 3; j++) {
                    depNew[j] = Math.min(dp[(j +1)%3] , dp[(j+2)%3])+costs[i][j];
            }
            dp = depNew;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
