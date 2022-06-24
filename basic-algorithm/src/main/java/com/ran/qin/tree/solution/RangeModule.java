/**
 * @Classname RangeModule
 * @Description leetCode - 715. Range 模块
 * @Date 2022/6/20 10:11
 * @author zhangqin
 */

package com.ran.qin.tree.solution;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        //找到离left最近的一个比他大的range
        Map.Entry<Integer, Integer> entry = treeMap.higherEntry(left);
        if (entry != treeMap.firstEntry()) {
            //找到当前这个range的前一个range
            //entry == null 说明当前没有比left大的range 即 前一个是最后一个range
            Map.Entry<Integer, Integer> start = entry != null ? treeMap.lowerEntry(entry.getKey()) : treeMap.lastEntry();

            if (start != null && start.getValue() >= right) {
                return;
            }
            //start 和 插入的range有交集要取并集
            if (start != null && start.getValue() >= left) {
                left = start.getKey();
                treeMap.remove(start.getKey());
            }
        }

        while (entry != null && entry.getKey() <= right) {
            right = Math.max(right, entry.getValue());
            treeMap.remove(entry.getKey());
            entry = treeMap.higherEntry(entry.getKey());
        }

        treeMap.put(left, right);

    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = treeMap.higherEntry(left);

        if (entry == treeMap.firstEntry()){
            return false;
        }

        Map.Entry<Integer, Integer> lower = entry != null ? treeMap.lowerEntry(entry.getKey()) : treeMap.lastEntry();
        return lower != null && lower.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        //找到离left最近的一个比他大的range
        Map.Entry<Integer, Integer> entry = treeMap.higherEntry(left);

        if (entry != treeMap.firstEntry()) {
            //找到当前这个range的前一个range
            //entry == null 说明当前没有比left大的range 即 前一个是最后一个range
            Map.Entry<Integer, Integer> start = entry != null ? treeMap.lowerEntry(entry.getKey()) : treeMap.lastEntry();

            if (start != null && start.getValue() >= right) {
                Integer value = start.getValue();
                if (start.getKey() == left){
                    treeMap.remove(start.getKey());
                }else {
                    treeMap.put(start.getKey(), left);
                }
                if (value != right){
                    treeMap.put(right, value);
                }
                return;
            }
            //start 和 插入的range有交集要取并集
            if (start != null && start.getValue() > left) {
                treeMap.put(start.getKey(), left);
            }

            while (entry != null && entry.getKey() < right) {
                if(entry.getValue() <= right){
                    treeMap.remove(entry.getKey());
                    entry = treeMap.higherEntry(entry.getKey());
                }else {
                    treeMap.put(right, entry.getValue());
                    treeMap.remove(entry.getKey());
                    break;
                }
            }
        }
    }

}
