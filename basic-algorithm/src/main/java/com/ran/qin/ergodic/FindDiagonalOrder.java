/**
 * @Classname FindDiagonalOrder
 * @Description leetCode - 498. 对角线遍历
 * @Date 2022/6/14 10:46
 * @author zhangqin
 */

package com.ran.qin.ergodic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDiagonalOrder {

    public static void main(String[] args) {
        FindDiagonalOrder f = new FindDiagonalOrder();
        //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        int[][] mat = {{3},{2}};
        int[] res = f.findDiagonalOrderOne(mat);
        Arrays.stream(res).forEach(c -> System.out.print(c));
    }

    public int[] findDiagonalOrderOne(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> res = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            List<Integer> elements = getElement(mat, 0, i);
            if (flag) {
                for (int j = elements.size() - 1; j >= 0; j--) {
                    res.add(elements.get(j));
                }
            } else {
                res.addAll(elements);
            }
            flag = !flag;
        }

        for (int i = 1; i < m; i++) {
            List<Integer> elements = getElement(mat, i, n - 1);
            if (flag) {
                for (int j = elements.size() - 1; j >= 0; j--) {
                    res.add(elements.get(j));
                }
            } else {
                res.addAll(elements);
            }
            flag = !flag;
        }
        int[] r = new int[m * n];
        for (int i = 0; i < r.length; i++) {
            if (res.size() > i) {
                r[i] = res.get(i);
            }
        }
        return r;
    }

    public int[] findDiagonalOrderTwo(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];

        return res;
    }
    public List<Integer> getElement(int[][] mat, int x, int y) {
        List<Integer> res = new ArrayList<>();
        while (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
            res.add(mat[x][y]);
            x++;
            y--;
        }
        return res;
    }
}
