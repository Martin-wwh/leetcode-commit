package java_common.tree;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-21 15:08
 * @Description: 最大公共父节点
 */
public class PublicParent {

    TreeNode parent = null;

    Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        findBoth(root,p,q);
        return parent;
    }

    public int findBoth(TreeNode node, TreeNode p, TreeNode q){
        if (node == null) return 0;
        int findNum = 0;

        findNum = findBoth(node.left, p, q) + findBoth(node.right,p,q);
        if (node.val == p.val || node.val == q.val) findNum++;
        if (findNum == 2 && parent == null){

            parent = node;
        }
        return findNum;
    }

    @Test
    public void test(){
        String req = "{\"nowUTC\":\"2020-09-23T03:17:42.577Z\",\"devicePersistentData\":{}}";
        JSONObject jsonObject = JSONObject.parseObject(req);
        Object data = jsonObject.get("devicePersistentData");
        System.out.println(data.toString());

    }


    public TreeNode BSTlowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        findBSTparent(root, p, q);
        return parent;
    }

    public void findBSTparent(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return;
        if (root.val > p.val && root.val > q.val){
            findBSTparent(root.left, p, q);
        }else if (root.val < p.val && root.val < q.val){
            findBSTparent(root.right, p, q);
        }else {
            if (parent == null){
                parent = root;
            }
        }
    }

    int min = Integer.MAX_VALUE;
    int max = 0;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        calDepth(root,0);
        return max - min < 2;
    }

    public void calDepth(TreeNode root, int depth){
        if (root == null){
            if (depth < min){
                min = depth;
            }
            if (depth > max){
                max = depth;
            }
        }else{
            depth++;
            calDepth(root.left, depth);
            calDepth(root.right, depth);
        }

    }

}
