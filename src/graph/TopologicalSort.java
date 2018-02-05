package graph;

import java.util.*;

/**
 * Created by sergei.kostin on 12/9/17.
 */
public class TopologicalSort {

    public void topoSort( Graph<?> graph){

        Set<Vertex<?>> visited = new HashSet<>();
        Stack<Vertex<?>> result = new Stack<>();

        for(Vertex v : graph.getAllVertexes() ){
            visited.add(v);
            if(!visited.contains(v)) topoSortUtil(result, visited, v);
        }

        while(!result.isEmpty()){
            System.out.print(result.pop() + "->");
        }

    }

    private void topoSortUtil(Stack<Vertex<?>> result, Set<Vertex<?>> visited, Vertex<?> current){
        for(Vertex vert : current.getAdjacentVertexes()){
            if(!visited.contains(vert)){
                visited.add(vert);
                topoSortUtil(result, visited, vert);
            }
        }
        result.add(current);
    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        TopologicalSort ts = new TopologicalSort();
        graph.addSingleVertex(1);
        graph.addSingleVertex(2);
        graph.addSingleVertex(3);
        graph.addSingleVertex(4);
        graph.addSingleVertex(5);
        graph.addSingleVertex(6);
        graph.addSingleVertex(7);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(5,6);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(4,7);

        ts.topoSort(graph);

    }

    //        Stack<Vertex<?>> result = new Stack<>();
//        Set<Vertex<?>> visited = new HashSet<>();
//        for(Vertex<?> vertex : graph.getAllVertexes()){
//            if(!visited.contains(vertex)){
//                visited.add(vertex);
//                topoSortUtil(graph, result, visited, vertex);
//            }
//        }
//
//        while(!result.isEmpty()){
//            System.out.println(result.pop());
//        }



    //        for(Vertex<?> vertex : current.getAdjacentVertexes()){
//            if(!visited.contains(vertex)){
//                visited.add(vertex);
//                topoSortUtil(graph, result, visited, vertex);
//            }
//        }
//        result.add(current);

}
