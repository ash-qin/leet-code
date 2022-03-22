import com.ran.qin.tree.TreeNode;
import com.ran.qin.tree.impl.TreeCreateFactoryImpl;
import com.ran.qin.tree.impl.TreeSearchFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangqin
 * @Classname TestTreeSearchFactory
 * @Description 树的查询操作测试类
 * @Date 2022/3/22 9:43 下午
 */

public class TestTreeSearchFactory {
    TreeSearchFactoryImpl<Integer> searchFactory = new TreeSearchFactoryImpl<Integer>();
    TreeCreateFactoryImpl<Integer> createFactory = new TreeCreateFactoryImpl<Integer>();
    @Test
    public void testPreOrder() {
        TreeNode<Integer> tree = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> integers = searchFactory.preOrderTraverse(tree);
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6, 7), integers);
    }

    @Test
    public void testInOrder() {
        TreeNode<Integer> tree = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> integers = searchFactory.inOrderTraverse(tree);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 6, 3, 7), integers);
    }

    @Test
    public void testPostOrder() {
        TreeNode<Integer> tree = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> integers = searchFactory.postOrderTraverse(tree);
        Assert.assertEquals(Arrays.asList(4, 5, 2, 6, 7, 3, 1), integers);
    }

    @Test
    public void testLevelOrder() {
        TreeNode<Integer> tree = createFactory.createBinaryTreeLayerSequence(0, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> integers = searchFactory.levelOrderTraverse(tree);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), integers);
    }



}
