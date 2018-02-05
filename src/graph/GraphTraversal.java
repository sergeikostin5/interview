package graph;

import java.util.*;

/**
 * Created by sergei.kostin on 12/8/17.
 */
public class GraphTraversal {

    public void DFS( Graph<?> graph ){
        Set<Vertex> visited = new HashSet<>();
        for( Vertex vert : graph.getAllVertexes()){
            if(!visited.contains(vert)){
               DFSUtil(vert, visited);
            }
        }
    }

    private void DFSUtil( Vertex<?> current, Set<Vertex> visited){
        visited.add(current);
        System.out.println(current);
        for(Vertex v : current.getAdjacentVertexes()){
            if(!visited.contains(v)){
                DFSUtil(v, visited);
            }
        }
    }

    public void DFSIterative( Graph<?> graph ){
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();

        for(Vertex vert : graph.getAllVertexes()){
            if(!visited.contains(vert)){
                stack.add(vert);
                while(!stack.isEmpty()){
                    Vertex<?> current = stack.pop();
                    visited.add(current);
                    System.out.println(current);
                    for(Vertex neighbor : current.getAdjacentVertexes()){
                        if(!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
    }

    public void BFS( Graph<?> graph){
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> q = new LinkedList<>();

        for(Vertex vertex : graph.getAllVertexes()){
            if(!visited.contains(vertex)){
                q.add(vertex);
                visited.add(vertex);
                while (!q.isEmpty()){
                    Vertex<?> current = q.remove();
                    System.out.println(current);
                    for(Vertex vert : current.getAdjacentVertexes()){
                        if(!visited.contains(vert)){
                            visited.add(vert);
                            q.add(vert);
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        GraphTraversal gt = new GraphTraversal();
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

        gt.DFSIterative(graph);

    }
}
