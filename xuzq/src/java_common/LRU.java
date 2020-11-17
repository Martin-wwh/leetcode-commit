package java_common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-08-31 11:08
 * @Description:
 */
public class LRU {

    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        //将node放到队首
//        map.remove(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveNodeToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1){
            map.get(key).val = value;
            return;
        }

        //不在map中
        Node node = new Node(key,value);
        map.put(key, node);
        moveNodeToHead(node);

        if (map.size() > capacity){
            map.remove(tail.pre.key);
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
        }
    }

    private void moveNodeToHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}
