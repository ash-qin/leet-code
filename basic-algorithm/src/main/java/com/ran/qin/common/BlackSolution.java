/**
 * @Classname BlackSolution
 * @Description leetCode - 710. 黑名单中的随机数
 * @Date 2022/6/26 22:46
 * @author zhangqin
 */

package com.ran.qin.common;

import java.util.*;

public class BlackSolution {

    /**
     * 黑名单与白名单分割点
     */
    int division;
    /**
     * 黑名单白名单映射 --- 小于分割点的黑名单映射成大于分割点的一白名单
     */
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * 随机数对象
     */
    Random random;


    public BlackSolution(int n, int[] blacklist) {
        int m = blacklist.length;
        division = n - m;

        Set<Integer> black = new HashSet<>();
        for (int i : blacklist) {
            //m -> n 包含m
            if (i >= division) {
                black.add(i);
            }
        }
        int w = division;
        for (int i : blacklist) {
            if (i < division) {
                while (black.contains(w)){
                    w++;
                }
                map.put(i, w);
                //使用完当前白名单映射后，要加一流转到下一个
                w++;
            }
        }
    }

    public int pick() {
        int i = random.nextInt(division);
        return map.getOrDefault(i, i);
    }
}
