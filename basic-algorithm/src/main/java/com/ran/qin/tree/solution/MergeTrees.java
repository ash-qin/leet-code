/**
 * @Classname MergeTrees
 * @Description leetCode - 617.合并二叉树
 * @Date 2021/12/29 3:34 下午
 * @author zhangqin
 */

package com.ran.qin.tree.solution;

import com.ran.qin.tree.model.TreeNode;
import com.ran.qin.tree.impl.TreeCreateFactoryImpl;
import com.ran.qin.tree.impl.TreeSearchFactoryImpl;

import java.util.Arrays;
import java.util.List;

public class MergeTrees {

    public static void main(String[] args) {

        MergeTrees m = new MergeTrees();
        TreeCreateFactoryImpl<Integer> createFactory = new TreeCreateFactoryImpl<Integer>();
        TreeSearchFactoryImpl<Integer> searchFactory = new TreeSearchFactoryImpl<Integer>();
        TreeNode<Integer> root1 = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(1, 3, 2, 5));
        TreeNode<Integer> root2 = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(2,1,3,0,4,0,7));
        TreeNode<Integer> result = m.mergeTrees(root1, root2);
        List<Integer> integers = searchFactory.levelOrderTraverse(result);
        System.out.println(integers);

    }

    public TreeNode<Integer> mergeTrees(TreeNode<Integer> root1, TreeNode<Integer>root2){
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode<Integer> result = new TreeNode<Integer>(root1.getVal() + root2.getVal());
        result.setLeft(mergeTrees(root1.getLeft(), root2.getLeft()));
        result.setRight(mergeTrees(root1.getRight(), root2.getRight()));
        return result;
    }
}
