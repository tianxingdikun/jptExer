package Algorithms.DepthAndBreadthFirstSearch.BeijingSubway;

public class TreeNode {

    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }

    public TreeNode(String data,TreeNode leftNode,TreeNode rightNode) {
        this.val = data;
        this.left = leftNode;
        this.right = rightNode;
    }

    /**
     * 初始化一颗二叉树
     *
     * @return
     */
    public TreeNode initTree() {
        // 结构如下：(由下往上建立)
        //            A
        //       B         C
        //    D         E     F
        //  G   H         I
        TreeNode I = new TreeNode("I", null, null);
        TreeNode H = new TreeNode("H", null, null);
        TreeNode G = new TreeNode("G", null, null);
        TreeNode F = new TreeNode("F", null, null);
        TreeNode E = new TreeNode("E", null, I);
        TreeNode D = new TreeNode("D", G, H);
        TreeNode C = new TreeNode("C", E, F);
        TreeNode B = new TreeNode("B", D, null);
        TreeNode A = new TreeNode("A", B, C);
        return A;  // 返回根节点
    }

}
