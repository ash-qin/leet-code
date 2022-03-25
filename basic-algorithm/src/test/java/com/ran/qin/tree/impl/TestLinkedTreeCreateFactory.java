/**
 * @Classname TestLinkedTreeCreateFactory
 * @Description 连接树创建实现测试
 * @Date 2022/3/24 11:30 上午
 * @author zhangqin
 */

package com.ran.qin.tree.impl;

import com.ran.qin.tree.model.LinkedTreeNode;
import com.ran.qin.tree.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLinkedTreeCreateFactory {
    LinkedTreeCreateFactoryImpl<Integer> factory = new LinkedTreeCreateFactoryImpl<Integer>();

    @Test
    public void TestCreate() {


        List<Integer> nodes = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            nodes.add(i);
        }
        LinkedTreeNode<Integer> binaryTree = factory.createBinaryTreeLayerSequence(0, nodes);
        Assert.assertNotNull(binaryTree);
    }
}
