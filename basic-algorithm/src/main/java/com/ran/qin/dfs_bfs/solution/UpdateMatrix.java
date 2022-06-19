/**
 * @Classname UpdateMatrix
 * @Description leetCode - 542.01矩阵
 * @Date 2022/3/29 2:53 下午
 * @author zhangqin
 */

package com.ran.qin.dfs_bfs.solution;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {

    private final int[] vertical = new int[]{0, 1, -1, 0};
    private final int[] horizontal = new int[]{1, 0, 0, -1};

    public int[][] solutionOne(int[][] matrix){
        if (matrix == null){
            return new int[0][0];
        }
        int column = matrix[0].length;
        int row = matrix.length;
        boolean[][] visit = new boolean[row][column];
        int[][] result = new int[row][column];
        Queue<int[]> queue = new LinkedList<int[]>();

        //循环，找出所有的0放入队列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visit[i][j] =true;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            for (int m = 0; m < 4; m++) {
                int mi = i + vertical[m];
                int mj = j + horizontal[m];
                if (mi >=0 && mi < row && mj >= 0 && mj < column && !visit[mi][mj]){
                    result[mi][mj] = result[i][j]+1;
                    visit[mi][mj] = true;
                    queue.offer(new int[]{mi, mj});
                }
            }
        }

        return result;
    }

    public int[][] solutionTwo(int[][] mat){


        return null;
    }
}
