package stack;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeSolution {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class MyStack{
        private List<TreeNode> list;

        public MyStack(){
            this.list = new ArrayList<>();
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public void push(TreeNode s){
            list.add(s);
        }

        public TreeNode poll(){
            if (list.size()>0){
                TreeNode num = list.remove(list.size()-1);
                return num;
            }
            return null;
        }

        public TreeNode top(){
            if(list.size() > 0){
                TreeNode temp = list.get(list.size()-1);
                return temp;
            }
            return null;
        }

        public void reset(){
            list.clear();
        }

        public int size(){
            return list.size();
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) return ansList;

        Set<TreeNode> seenSet = new HashSet<>();
        MyStack mystack = new MyStack();
        mystack.push(root);
        while(!mystack.isEmpty()){
            TreeNode node = mystack.top();
            if (node.left != null && !seenSet.contains(node.left)){
                mystack.push(node.left);
                continue;
            }

            ansList.add(node.val);
            seenSet.add(node);
            mystack.poll();
            if(node.right != null){
                if (!seenSet.contains(node.right))
                    mystack.push(node.right);
                else{
                    ansList.add(node.val);
                    seenSet.add(node);
                    mystack.poll();
                }
            }
        }
        return ansList;
    }
    

}
