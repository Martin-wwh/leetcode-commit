package java_common.tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-21 10:29
 * @Description: 根据中序和先序/后序中的还原整个树
 */
public class TreeBuild {

    int[] inorder = {3,4,2,1,6,5,8,7,9};
    int[] postorder = {4,3,2,6,8,9,7,5,1};
    int[] preorder = {1,2,3};

    Map<Integer, Integer> inMap = new HashMap<>();

    @Test
    public void buildTree() {
        for (int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        TreeNode node = buildPost(postorder.length-1,0, inorder.length-1);
        System.out.println(node);
    }

    public TreeNode buildPost(int root, int left, int right){
        if (left > right) return null;
        TreeNode node = new TreeNode();
        int val = postorder[root];
        node.val = val;
        int inIndex = inMap.get(val);
        node.left = buildPost(root-right+inIndex-1, left, inIndex-1);
        node.right = buildPost(root-1,inIndex+1, right);
        return node;
    }

    @Test
    public void buildTreePre() {

        for (int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = build(0,0, inorder.length-1);
        System.out.println(root);
    }

    public TreeNode build(int root, int left, int right){
        if (left > right) return null;
        TreeNode node = new TreeNode();
        int val = preorder[root];
        node.val = val;
        int inIndex = inMap.get(val);
        node.left = build(root+1, left, inIndex-1);
        node.right = build(root+inIndex-left+1, inIndex+1, right);
        return node;
    }
}
