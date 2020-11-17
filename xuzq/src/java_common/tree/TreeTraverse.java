package java_common.tree;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-19 14:59
 * @Description: 树的遍历
 */
public class TreeTraverse {

    List<Integer> resList = new ArrayList<>();

    //先序
    //递归
    public List<Integer> first(TreeNode root) {
        if (root != null) {
            resList.add(root.val);
            if (root.left != null) mid(root.left);
            if (root.right != null) mid(root.right);
        }
        return resList;
    }

    //迭代
    public List<Integer> firstD(TreeNode root) {
        if (root == null) return resList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            resList.add(top.val);
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
        }
        return resList;
    }

    //中

    //递归
    public List<Integer> mid(TreeNode root) {
        if (root != null) {
            if (root.left != null) mid(root.left);
            resList.add(root.val);
            if (root.right != null) mid(root.right);
        }
        return resList;
    }

    //迭代
    public List<Integer> midD(TreeNode root) {
        if (root == null) return resList;
        Deque<TreeNode> queue = new LinkedList<>();
        while(root != null || !queue.isEmpty()){
            while (root != null){
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            resList.add(root.val);
            root = root.right;
        }
        return resList;
    }


    //后
    //递归
    public List<Integer> last(TreeNode root) {
        if (root != null) {
            if (root.left != null) last(root.left);
            if (root.right != null) last(root.right);
            resList.add(root.val);
        }
        return resList;
    }

    //迭代
    public List<Integer> lastD(TreeNode root) {
        LinkedList<Integer> resList = new LinkedList<>();
        if (root == null) return resList;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.pop();
            resList.addFirst(top.val);
            if (top.right != null) queue.push(top.right);
            if (top.left != null) queue.push(top.left);
        }
        return resList;
    }


    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        deque.addLast(null);
        int i=0;
        while(deque.size() > 0){
            TreeNode top = deque.poll();
            if (top == null) break;
            List<Integer> cellList = new ArrayList<>();
            while(top != null){
                cellList.add(top.val);
                if (top.left != null) deque.addLast(top.left);
                if (top.right != null) deque.addLast(top.right);
                top = deque.poll();
            }
            deque.addLast(null);
            res.add(cellList);
        }
        return res;
    }
}
