/**
 * @Classname FindFrequentTreeSum
 * @Description leetCode - 508. 出现次数最多的子树元素和
 * @Date 2022/6/19 22:11
 * @author zhangqin
 */

package com.ran.qin.tree.solution;

import com.ran.qin.tree.impl.TreeCreateFactoryImpl;
import com.ran.qin.tree.model.TreeNode;

import java.util.*;

public class FindFrequentTreeSum {

    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;

    public static void main(String[] args) {

        FindFrequentTreeSum f = new FindFrequentTreeSum();
        TreeCreateFactoryImpl factory = new TreeCreateFactoryImpl();
        List<Integer> integers = Arrays.asList(5, 2, -5);
        TreeNode tree = factory.createBinaryTreeLayerSequence(0, integers);
        int[] res = f.findFrequentTreeSum(tree);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxCount){
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int dfs(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }

        int sum = root.getVal() + dfs(root.getLeft()) + dfs(root.getRight());
        map.put(sum, map.getOrDefault(sum, 0)+1);
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }
}
