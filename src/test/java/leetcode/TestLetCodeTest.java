package leetcode;

import bo.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * TestLetCode的单元测试类
 */
@RunWith(MockitoJUnitRunner.class)
public class TestLetCodeTest {

    private TestLetCode testLetCode;
    private MockedStatic<System> systemMock;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        testLetCode = new TestLetCode();
        // 保存原始的System.out
        originalOut = System.out;
        // 创建ByteArrayOutputStream来捕获输出
        outputStream = new ByteArrayOutputStream();
        // mock System类的静态方法
        systemMock = Mockito.mockStatic(System.class);
    }

    @After
    public void tearDown() {
        // 释放mock对象
        if (systemMock != null) {
            systemMock.close();
        }
        // 恢复原始的System.out
        System.setOut(originalOut);
    }

    /**
     * 测试空树情况
     * 预期：不执行任何操作，无输出
     */
    @Test
    public void testPreOrderWithDepth_NullRoot() {
        // 准备测试数据
        TreeNode root = null;
        
        // 设置mock行为，捕获System.out.println的调用
        systemMock.when(() -> System.out.println(Mockito.anyString())).thenAnswer(invocation -> {
            String message = invocation.getArgument(0);
            originalOut.println(message);
            return null;
        });
        
        // 执行被测方法
        testLetCode.preOrderWithDepth(root);
        
        // 验证：没有调用System.out.println
        systemMock.verifyNoInteractions();
    }

    /**
     * 测试单节点树情况
     * 预期：只输出根节点的值
     */
    @Test
    public void testPreOrderWithDepth_SingleNode() {
        // 准备测试数据
        TreeNode root = new TreeNode(1);
        
        // 捕获输出流
        System.setOut(new PrintStream(outputStream));
        
        // 执行被测方法
        testLetCode.preOrderWithDepth(root);
        
        // 验证输出
        String output = outputStream.toString();
        assertEquals("1\n", output);
    }

    /**
     * 测试完整二叉树情况
     * 构造树结构：
     *       1
     *      / \
     *     2   3
     *    / \
     *   4   5
     * 预期输出顺序：1 2 4 5 3（先序遍历）
     */
    @Test
    public void testPreOrderWithDepth_CompleteTree() {
        // 准备测试数据
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // 捕获输出流
        System.setOut(new PrintStream(outputStream));
        
        // 执行被测方法
        testLetCode.preOrderWithDepth(root);
        
        // 验证输出
        String output = outputStream.toString();
        assertEquals("1\n2\n4\n5\n3\n", output);
    }

    /**
     * 测试只有左子树的情况
     * 构造树结构：
     *   1
     *  /
     * 2
     */
    @Test
    public void testPreOrderWithDepth_LeftOnlyTree() {
        // 准备测试数据
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        
        // 捕获输出流
        System.setOut(new PrintStream(outputStream));
        
        // 执行被测方法
        testLetCode.preOrderWithDepth(root);
        
        // 验证输出
        String output = outputStream.toString();
        assertEquals("1\n2\n", output);
    }

    /**
     * 测试只有右子树的情况
     * 构造树结构：
     * 1
     *  \
     *   2
     */
    @Test
    public void testPreOrderWithDepth_RightOnlyTree() {
        // 准备测试数据
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        
        // 捕获输出流
        System.setOut(new PrintStream(outputStream));
        
        // 执行被测方法
        testLetCode.preOrderWithDepth(root);
        
        // 验证输出
        String output = outputStream.toString();
        assertEquals("1\n2\n", output);
    }

    /**
     * 测试复杂树结构
     * 构造树结构：
     *       1
     *      / \
     *     2   3
     *    /   / \
     *   4   5   6
     */
    @Test
    public void testPreOrderWithDepth_ComplexTree() {
        // 准备测试数据
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        // 捕获输出流
        System.setOut(new PrintStream(outputStream));
        
        // 执行被测方法
        testLetCode.preOrderWithDepth(root);
        
        // 验证输出
        String output = outputStream.toString();
        assertEquals("1\n2\n4\n3\n5\n6\n", output);
    }
}
