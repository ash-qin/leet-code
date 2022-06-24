/**
 * @Classname FindBottomLeftValue
 * @Description leetCode - 513. 找树左下角的值
 * @Date 2022/6/22 10:25
 * @author zhangqin
 */

package com.ran.qin.tree.solution;

import com.ran.qin.tree.impl.TreeCreateFactoryImpl;
import com.ran.qin.tree.model.TreeNode;

import java.util.Arrays;
import java.util.List;

public class FindBottomLeftValue {
    int currentHeigh = 0;
    int res = 0;

    public static void main(String[] args) {
        FindBottomLeftValue f = new FindBottomLeftValue();
        TreeCreateFactoryImpl<Integer> factory = new TreeCreateFactoryImpl<>();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, null, 5, 6, null, null, 7);
        TreeNode<Integer> tree = factory.createBinaryTreeLayerSequence(0, integers);
        System.out.println(f.findBottomLeftValue(tree));
    }

    public int findBottomLeftValue(TreeNode<Integer> root) {
        dfs(root, 0);

        return res;
    }

    public void dfs(TreeNode<Integer> root, int heigh) {
        if (root == null) {
            return;
        }
        heigh++;
        if (heigh > currentHeigh) {
            currentHeigh = heigh;
            res = root.getVal() == null ? 0 : root.getVal();
        } else if (heigh == currentHeigh && res == 0) {
            res = root.getVal() == null ? 0 : root.getVal();

        }
        dfs(root.getLeft(), heigh);
        dfs(root.getRight(), heigh);
    }
}
