import cn.hutool.core.collection.ListUtil;
import com.ran.qin.tree.TreeNode;
import com.ran.qin.tree.impl.TreeFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqin
 * @Classname TestTreeFactory
 * @Description 树相关操作测试
 * @Date 2022/3/22 3:21 下午
 */

public class TestTreeFactory {

    @Test
    public void TestCreate() {

        TreeFactoryImpl<Integer> factory = new TreeFactoryImpl<Integer>();
        List<Integer> nodes = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            nodes.add(i);
        }
        TreeNode<Integer> binaryTree = factory.createBinaryTreeLayerSequence(0, nodes);
        Assert.assertNotNull(binaryTree);
    }

    @Test
    public void testCreatePreIn(){
        List<Integer> preList = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        List<Integer> inList = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        TreeFactoryImpl<Integer> factory = new TreeFactoryImpl<Integer>();
        TreeNode<Integer> tree = factory.createBinaryTreePreInSequence(preList, inList);
        Assert.assertNotNull(tree);
    }

}
