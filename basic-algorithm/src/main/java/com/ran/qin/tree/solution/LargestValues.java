/**
 * @Classname LargestValues
 * @Description leetCode - 515. 在每个树行中找最大值
 * @Date 2022/6/24 10:47
 * @author zhangqin
 */

package com.ran.qin.tree.solution;

import com.ran.qin.tree.impl.TreeCreateFactoryImpl;
import com.ran.qin.tree.model.TreeNode;

import java.util.*;

public class LargestValues {

    public static void main(String[] args) {
        TreeCreateFactoryImpl<Integer> factory = new TreeCreateFactoryImpl<>();
        List<Integer> integers = Arrays.asList(1,2,3);
        com.ran.qin.tree.model.TreeNode<Integer> tree = factory.createBinaryTreeLayerSequence(0, integers);
        LargestValues l = new LargestValues();
        List<Integer> res = l.largestValues(tree);
        res.forEach(s -> System.out.print(+s + " "));
    }

    public List<Integer> largestValues(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode<Integer>> search = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        search.add(root);
        while (!search.isEmpty()) {
            int size = search.size();
            int max = Integer.MIN_VALUE;
            while (size>0){
                size--;
                TreeNode<Integer> poll = search.poll();
                int current = poll.getVal() == null ? Integer.MIN_VALUE : poll.getVal();
                max = Math.max(current, max);
                if (poll.getLeft() != null) {
                    search.add(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    search.add(poll.getRight());
                }
            }
            result.add(max);
        }
        return result;
    }
}
