/**
 * @Classname FloodFill
 * @Description leetCode 733 . 图像渲染
 * @Date 2021/12/28 11:29 上午
 * @author zhangqin
 */

package com.ran.qin.dfs_bfs.solution;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    private final int[] vertical = new int[]{0, 1, -1, 0};
    private final int[] horizontal = new int[]{1, 0, 0, -1};

    public static void main(String[] args) {
//        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image = new int[][]{{0, 0, 0}, {0, 0, 0}};
        FloodFill f = new FloodFill();
//        f.floodFillBfs(image, 0, 0, 2);
        f.floodFillDfs(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j]);
            }
            System.out.print("\n");
        }
    }

    public int[][] floodFillBfs(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor == newColor) {
            return image;
        }
        //二维数组的长
        int length = image.length;
        //二维数组的宽
        int width = image[0].length;

        Queue<int[]> bfs = new LinkedList<int[]>();
        bfs.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!bfs.isEmpty()) {
            int[] poll = bfs.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + horizontal[i];
                int y = poll[1] + vertical[i];
                if (x >= 0 && x < length && y >= 0 && y < width && image[x][y] == currentColor) {
                    bfs.offer(new int[]{x, y});
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }

    public int[][] floodFillDfs(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor == newColor) {
            return image;
        }

        return dfs(image, sr, sc, currentColor, newColor);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int currentColor, int newColor) {
        if (image[sr][sc] == currentColor){
            //二维数组的长
            int length = image.length;
            //二维数组的宽
            int width = image[0].length;
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int x = sr + horizontal[i];
                int y = sc + vertical[i];
                if (x >= 0 && x < length && y >= 0 && y < width) {
                    dfs(image, x, y, currentColor, newColor);
                }
            }
        }
        return image;
    }
}
