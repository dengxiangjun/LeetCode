import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/description/
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * <p>
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * <p>
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 * Created by deng on 2018/4/9.
 */
public class CloneGraph {

    public static void main(String[] args) {

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.offer(node);
        map.put(node, null);
        while (queue.size() > 0) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
            map.put(cur,copy);
            for (UndirectedGraphNode neighbor : cur.neighbors){
                if (!map.containsKey(neighbor)){
                    queue.offer(neighbor);
                    map.put(neighbor,null);
                }
            }
        }

        for (UndirectedGraphNode origin : map.keySet()){
            UndirectedGraphNode copy = map.get(origin);
            for (UndirectedGraphNode neighbor : origin.neighbors) copy.neighbors.add(map.get(neighbor));
        }
        return map.get(node);
    }


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}

