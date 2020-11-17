package java_common;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-05-21 16:31
 * @Description:
 */
public class Trie {

    private TreeNode root;

    class TreeNode{
        //所有子节点
        private TreeNode[] links;
        //子节点最大长度
        private int R = 26;
        //是否是单词结尾
        private boolean isEnd = false;

        public TreeNode(){
            links = new TreeNode[R];
        }

        public TreeNode get(char c){
            return links[c-'a'];
        }

        public boolean contains(char c){
            return links[c-'a'] != null;
        }

        public void put(char c, TreeNode node){
            links[c-'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (!node.contains(c)){
                TreeNode next = new TreeNode();
                node.put(c, next);
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (!node.contains(c)){
                return false;
            }
            node = node.get(c);
        }
        if (node.isEnd()){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if (!node.contains(c)){
                return false;
            }
            node = node.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
    }
}
