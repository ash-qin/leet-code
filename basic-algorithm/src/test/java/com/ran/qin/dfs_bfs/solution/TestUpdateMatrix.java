/**
 * @Classname TestUpdateMatrix
 * @Description leetCode - 542.01矩阵测试类
 * @Date 2022/3/29 4:10 下午
 * @author zhangqin
 */

package com.ran.qin.dfs_bfs.solution;

import org.junit.Test;

public class TestUpdateMatrix {

    @Test
    public void testOne(){
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] map = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] ints = updateMatrix.solutionOne(map);
        print(ints);
    }

    public static void print(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}
