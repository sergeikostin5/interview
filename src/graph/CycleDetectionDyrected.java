package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class CycleDetectionDyrected {

    private Set<Vertex> whiteSet = new HashSet<>();
    private Set<Vertex> greySet = new HashSet<>();
    private Set<Vertex> blackSet = new HashSet<>();

    public boolean hasCycle(Graph<?> graph){
        whiteSet.addAll(graph.getAllVertexes());

        while(whiteSet.size() > 0){
            Vertex<?> current = whiteSet.iterator().next();
            if(dfs(current)){
                return true;
            }
        }

        return false;

    }

    private boolean dfs(Vertex<?> current){
        move(current, whiteSet, greySet);
        for(Vertex neighbor : current.getAdjacentVertexes()){
            // if in black set -> means already explored, so continue
            if(blackSet.contains(neighbor)) continue;

            // if in grey set -> means cycle found
            if(greySet.contains(neighbor)) return true;

            if(dfs(neighbor)) return true;
        }
        move(current, greySet, blackSet);
        return false;
    }

    private void move(Vertex current, Set<Vertex> from, Set<Vertex> to){
        from.remove(current);
        to.add(current);
    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
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
        graph.addEdge(3,2);
        graph.addEdge(2,1);
        CycleDetectionDyrected cd = new CycleDetectionDyrected();
        System.out.println(cd.hasCycle(graph));

    }


}
