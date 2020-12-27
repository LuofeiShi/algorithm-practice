/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        // create a map to store visited nodes.
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode graphNode = queue.poll();
            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(graphNode).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}