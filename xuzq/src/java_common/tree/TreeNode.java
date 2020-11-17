package java_common.tree;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-19 14:58
 * @Description:
 */
public class TreeNode {

    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode next = null;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
