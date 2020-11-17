package java_common.tree;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-22 10:54
 * @Description:
 */
public class BSTInsert {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;
    }

    @Test
    public void test(){
        Integer[] nums = {0};
        deleteNode(new ConnectTree().arrayToTree(nums), 0);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            if (root.left == null && root.right == null){
                root = null;
            }else if (root.right != null && root.left != null){
                TreeNode node = root.right;
                if (node.left == null){
                    root.val = node.val;
                    root.right = node.right;
                }
                else {
                    while (node.left.left != null){
                        node = node.left;
                    }
                    root.val = node.left.val;
                    node.left = node.left.right;
                }

            }else{
                root = root.left == null ? root.right : root.left;
            }
        }
        if (root != null && root.val > key && root.left != null ) root.left = deleteNode(root.left, key);
        if (root != null && root.val < key && root.right != null ) root.right = deleteNode(root.right, key);
        return root;
    }
}
