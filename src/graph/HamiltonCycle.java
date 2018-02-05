package graph;

/**
 * Created by sergei.kostin on 12/24/17.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Hamilton cycle, or Hamilton circuit, is a graph cycle (i.e., closed loop)
 * through a graph that visits each node exactly once
 */
public class HamiltonCycle {

    public List<Vertex<Integer>> getHamiltonPath( Graph<Integer> graph){
        List<Vertex<Integer>> result = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        Vertex current = graph.getAllVertexes().iterator().next();
        if(isHamiltonCycle( graph, result, visited, current, current)){
            return result;
        }
        return null;
    }

    private boolean isHamiltonCycle( Graph<Integer> graph, List<Vertex<Integer>> result, Set<Vertex> visited, Vertex<Integer> current, Vertex<Integer> startedVertex){
        visited.add(current);
        result.add(current);

        for(Vertex elem : current.getAdjacentVertexes()){
            if(result.size() == graph.getAllVertexes().size() && elem.equals(startedVertex)){
                result.add(elem);
                return true;
            }
            if(!visited.contains(elem)){
                if(isHamiltonCycle(graph, result, visited, elem, startedVertex)){
                    return true;
                }
            }
        }

        visited.remove(current);
        result.remove(result.size() - 1 );
        return false;
    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addSingleVertex(1);
        graph.addSingleVertex(2);
        graph.addSingleVertex(3);
        graph.addSingleVertex(4);
        graph.addSingleVertex(5);
        graph.addSingleVertex(6);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(3,2);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        graph.addEdge(5,6);

        HamiltonCycle hc = new HamiltonCycle();
        List<Vertex<Integer>> hamilitonList = hc.getHamiltonPath(graph);
        if( hamilitonList == null ){
            System.out.println("There is no hamilton path");
        } else {
            System.out.println(hamilitonList);
        }

    }

}
