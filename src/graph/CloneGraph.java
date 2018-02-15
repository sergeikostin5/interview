package graph;

import java.util.*;

/**
 * Created by sergei.kostin on 2/6/18.
 */
public class CloneGraph {

    private static class UndirectedGraphNode {
        int label;
        public List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

        @Override
        public String toString() {
            return "UndirectedGraphNode{" +
                    "label=" + label +
                    '}';
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap(); //map of nodes for old graph to new graph
        map.put(node, newNode);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            UndirectedGraphNode current = q.remove();
            for(UndirectedGraphNode temp : current.neighbors){
                if(!map.containsKey(temp)){
                    UndirectedGraphNode cloneNode = new UndirectedGraphNode(temp.label);
                    q.add(temp);
                    map.put(temp, cloneNode);
                }
            }
        }
        System.out.println("Bingo");
        q.add(node);
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(node);
        while(!q.isEmpty()){
            UndirectedGraphNode current = q.remove();
            for(UndirectedGraphNode temp : current.neighbors){
                map.get(current).neighbors.add(map.get(temp));
                if(!visited.contains(temp)){
                    visited.add(temp);
                    q.add(temp);
                }
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);


        node.neighbors.add(node1);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
        CloneGraph cg = new CloneGraph();
        UndirectedGraphNode clone = cg.cloneGraph(node);
        System.out.println(node.neighbors);
        System.out.println(clone.neighbors);
    }

}
