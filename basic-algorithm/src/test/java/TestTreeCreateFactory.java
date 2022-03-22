import com.ran.qin.tree.TreeNode;
import com.ran.qin.tree.impl.TreeCreateFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangqin
 * @Classname TestTreeFactory
 * @Description 树相关操作测试
 * @Date 2022/3/22 3:21 下午
 */

public class TestTreeCreateFactory {

    @Test
    public void TestCreate() {

        TreeCreateFactoryImpl<Integer> factory = new TreeCreateFactoryImpl<Integer>();
        List<Integer> nodes = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            nodes.add(i);
        }
        TreeNode<Integer> binaryTree = factory.createBinaryTreeLayerSequence(0, nodes);
        Assert.assertNotNull(binaryTree);
    }

    @Test
    public void testCreatePreIn() {
        List<Integer> preList = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        List<Integer> inList = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        TreeCreateFactoryImpl<Integer> factory = new TreeCreateFactoryImpl<Integer>();
        TreeNode<Integer> tree = factory.createBinaryTreePreInSequence(preList, inList);
        Assert.assertNotNull(tree);
    }

    @Test
    public void testCreatePostIn() {
        List<Integer> postList = Arrays.asList(4, 5, 2, 6, 7, 3, 1);
        List<Integer> inList = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        TreeCreateFactoryImpl<Integer> factory = new TreeCreateFactoryImpl<Integer>();
        TreeNode<Integer> tree = factory.createBinaryTreePostInSequence(postList, inList);
        Assert.assertNotNull(tree);
    }

}
