package Algorithms.DepthAndBreadthFirstSearch.BeijingSubway;


import javafx.scene.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先搜索
 */
public class BFS {

    public void breadthFirstSearch(Node start, Node target) {
        Queue<Node> q = null; // 核心数据结构
        Set<Node> visited = null; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target) {
                    System.out.println("经过的步数：" + step);
                }
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : visited)
                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
    }

    /**
     * 起点：二叉树的根节点
     * 终点：两个子节点都是null的节点
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public int parseTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //已经走过的节点
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //从根节点开始搜索，root节点本身也是一层
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            //从根节点开始向左右子节点搜索
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                //终点标志
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                //将到达终点之前的每个节点加入进去
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }


    //内部类，自己构造的二叉树模型
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
