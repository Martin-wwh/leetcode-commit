package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ref : https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/884/
 */
public class CloneGraphSolution {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Node, Node> map){
        if(node == null)
            return null;
        if (map.containsKey(node)) return map.get(node);

        List<Node> nodes = new ArrayList<>();
        Node copyNode = new Node(node.val, nodes);
        map.put(node, copyNode);
        for(Node neighbor : node.neighbors){
            nodes.add(dfs(neighbor, map));
        }
        return copyNode;

    }
}
