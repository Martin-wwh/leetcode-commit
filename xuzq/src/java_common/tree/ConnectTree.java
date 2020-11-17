package java_common.tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.tree
 * @Author: xuzq11
 * @CreateTime: 2020-09-21 14:24
 * @Description:
 */
public class ConnectTree {

    Integer[] treeArray = {5,2,-2,4,-4,-9,2,7,2,null,-9,-9,null,null,3,null,7,null,null,null,null,null,null,null,3};

    public TreeNode arrayToTree(){
        TreeNode head = new TreeNode();
        int n = treeArray.length;
        buildTree(head, 1, n);
        return head;
    }

    public TreeNode arrayToTree(Integer[] nums){
        treeArray = nums;
        TreeNode head = new TreeNode();
        int n = nums.length;
        buildTree(head, 1, n);
        return head;
    }

    public void buildTree(TreeNode node, int index, int arraySize){
        if (index > arraySize) return;
        node.val = treeArray[index-1];
        if (2*index <= arraySize && treeArray[2*index - 1] != null){
            TreeNode lnode = new TreeNode(treeArray[2*index-1]);
            node.left = lnode;
            buildTree(lnode,2*index, arraySize);
        }

        if (2*index+1 <= arraySize && treeArray[2*index] != null){
            TreeNode rnode = new TreeNode(treeArray[2*index]);
            node.right = rnode;
            buildTree(rnode,2*index+1, arraySize);
        }
    }

    @Test
    public void test(){
        connect(arrayToTree());
    }


    public TreeNode connect(TreeNode root) {
        if (root == null) return root;
        connect(root, null);
        return root;
    }

    public void connect(TreeNode node, TreeNode brother){
        if (node.left != null || node.right != null){
            if (node.right != null){
                node.right.next = brother == null ?
                        null : brother.left == null ? brother.right : brother.left;
                TreeNode nextNode = node.right.next;
                TreeNode brotherNext = brother;
                nextNode = nextHasChildBrotherNode(nextNode, brotherNext);
                connect(node.right, nextNode);
            }
            if (node.left != null){
                if (node.left.val == 7){
                    System.out.println(111);
                }
                if (node.right != null){
                    node.left.next = node.right;
                }else {
                    node.left.next = brother == null ?
                            null : brother.left == null ? brother.right : brother.left;
                }
                TreeNode nextNode = node.left.next;
                TreeNode brotherNext = brother;
                nextNode = nextHasChildBrotherNode(nextNode, brotherNext);
                connect(node.left, nextNode);
            }

        }
    }

    public TreeNode nextHasChildBrotherNode(TreeNode nextNode, TreeNode brotherNext){
        if (nextNode != null && nextNode.left == null && nextNode.right == null){
            while (brotherNext != null ){
                if (brotherNext.left != null){
                    if (brotherNext.left.left != null || brotherNext.left.right != null){
                        nextNode = brotherNext.left;
                        break;
                    }
                }
                if (brotherNext.right != null){
                    if (brotherNext.right.left != null || brotherNext.right.right != null){
                        nextNode = brotherNext.right;
                        break;
                    }
                }
                brotherNext = brotherNext.next;
            }
        }
        return nextNode;
    }
}
