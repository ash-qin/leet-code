/**
 * @Classname MaxAreaOfIsland
 * @Description leetCode 695.岛屿的最大面积
 * @Date 2021/12/28 5:56 下午
 * @author zhangqin
 */

package com.ran.qin.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    private final int[] vertical = new int[]{0, 1, -1, 0};
    private final int[] horizontal = new int[]{1, 0, 0, -1};

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0}};
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        int i = m.maxAreaOfIslandDfs(grid);
        System.out.println(i);
    }

    public int maxAreaOfIslandDfs(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int dfs = dfs(grid, i, j);
                result = Math.max(result, dfs);
            }
        }
        return result;
    }

    /**
     * dfs 遍历整个矩阵
     *
     * @param grid
     * @param sr
     * @param sc
     * @return
     */
    private int dfs(int[][] grid, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr == grid.length || sc == grid[0].length || grid[sr][sc] != 1) {
            return 0;
        }
        int ans = 1;
        for (int i = 0; i < vertical.length; i++) {
            grid[sr][sc] = 0;
            ans += dfs(grid, sr + vertical[i], sc + horizontal[i]);
        }
        return ans;
    }
}
