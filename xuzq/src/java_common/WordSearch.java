package java_common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-05-27 14:53
 * @Description: 单词搜索
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 */
public class WordSearch {

//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> res = new ArrayList<>();
//        int row = board.length;
//        int col = board[0].length;
//        for(String word: words){
//            Set<String> path = new HashSet<>();
//            boolean find = false;
//            for(int i=0; i<row; i++){
//                for (int j=0; j<col; j++){
//                    if (board[i][j] == word.charAt(0)){
//                        path.add(i+""+j);
//                        find = backtrack(word,0,board,i,j,path,res);
//                        path.remove(i+""+j);
//                        if (find) break;
//                    }
//                }
//                if (find) break;
//            }
//        }
//        return res;
//    }
//
//    public boolean backtrack(String s, int index, char[][] board, int row, int col, Set<String> path, List<String> res){
//
//        //结束条件
//        if (index == s.length()-1){
//            res.add(s);
//            return true;
//        }
//
//        String[] directions = {"-1,0","1,0","0,-1","0,1"};
//
//        //做选择
//        for (String direction : directions){
//            int i = Integer.parseInt(direction.split(",")[0]);
//            int j = Integer.parseInt(direction.split(",")[1]);
//            if (isValid(s,index+1, board,row+i, col+j, path)){
//                int r = row + i;
//                int c = col + j;
//                path.add(r + "" + c);
//                boolean isFind = backtrack(s,index+1, board,row+i, col+j, path, res);
//                path.remove(r + "" + c);
//                if (isFind){
//                    return true;
//                }
//
//            }
//        }
//        return false;
//    }
//
//    public boolean isValid(String s, int index, char[][] board, int row, int col, Set<String> path){
//        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || path.contains(row + "" + col) || s.charAt(index) != board[row][col]){
//            return false;
//        }
//        return true;
//    }


    private TrieNode root = new TrieNode();

    class TrieNode{
        TrieNode[] links;
        public String word = null;

        public TrieNode(){
            links = new TrieNode[26];
        }

        public void insert(char c, TrieNode node){
            links[c-'a']=node;
        }

        public TrieNode get(char c){
            return links[c-'a'];
        }

        public boolean contains(char c){
            return links[c-'a'] != null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            TrieNode node = root;
            for(int i=0; i<word.length();i++){
                if (!node.contains(word.charAt(i))){
                    TrieNode newNode = new TrieNode();
                    node.insert(word.charAt(i), newNode);
                }
                node = node.get(word.charAt(i));
            }
            node.word = word;
        }

        List<String> res = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if (root.contains(board[i][j])){
                    Set<String> path = new HashSet<>();
                    path.add(i+""+j);
                    backtrack(board,i,j,path,res,root.get(board[i][j]));
                }
            }
        }
        return res;
    }

    public void backtrack(char[][] board, int row, int col, Set<String> path, List<String> res, TrieNode node){

        //结束条件
        if (node.word != null){
            res.add(node.word);
            node.word = null;
        }

        String[] directions = {"-1,0","1,0","0,-1","0,1"};

        //做选择
        for (String direction : directions){
            int i = Integer.parseInt(direction.split(",")[0]);
            int j = Integer.parseInt(direction.split(",")[1]);
            if (isValid(board,row+i, col+j, path, node)){
                int r = row + i;
                int c = col + j;
                path.add(r + "" + c);
                backtrack(board,row+i, col+j, path, res, node.get(board[row+i][col+j]));
                path.remove(r + "" + c);

            }
        }
    }

    public boolean isValid( char[][] board, int row, int col, Set<String> path, TrieNode node){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || path.contains(row + "" + col) || !node.contains(board[row][col])){
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        char[][] board = {{'a','b'},{'c','d'}};
        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        List<String> wordList = findWords(board,words);
        for (String word: wordList){
            System.out.println(word);
        }
    }
}
