/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null) {
            return result;
        }
        
        Set<UndirectedGraphNode> visited = new HashSet<>();
        for (UndirectedGraphNode curr : nodes) {
            if (!visited.contains(curr)) {
                findConnect(curr, result, visited);
            }
        }
        return result;
    }
    
    private void findConnect(UndirectedGraphNode node, List<List<Integer>> result, Set<UndirectedGraphNode> visited) {
        // bfs
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            list.add(curr.label);
            for(UndirectedGraphNode next : curr.neighbors) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        Collections.sort(list);
        result.add(list);
    }
}