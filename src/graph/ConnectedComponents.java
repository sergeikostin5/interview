package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergei.kostin on 12/11/17.
 */
public class ConnectedComponents<T> {

    private Graph<T> graph;
    private int count;
    private int[] component;
    private Set<Vertex<T>> visited = new HashSet<>();

    public ConnectedComponents(Graph<T> graph){
        this.graph = graph;
        component = new int[graph.getAllVertexes().size()];
        preprocess();
    }


    private void preprocess(){
        for(Vertex<T> vert : graph.getAllVertexes()){
            if(!visited.contains(vert)) {
                dfs(vert);
                count++;
            }

        }
    }

    private void dfs(Vertex<T> vert){
        visited.add(vert);
        component[(int) vert.id] = count;
        for(Vertex<T> current : vert.getAdjacentVertexes()){
            if(!visited.contains(current)){
                dfs(current);
            }
        }
    }

    public boolean isConnected(int v, int w){
        return component[v] == component[w];
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addSingleVertex(0);
        graph.addSingleVertex(1);
        graph.addSingleVertex(2);
        graph.addSingleVertex(3);
        graph.addSingleVertex(4);
        graph.addSingleVertex(5);
        graph.addSingleVertex(6);
        graph.addSingleVertex(7);
        graph.addSingleVertex(8);
        graph.addSingleVertex(9);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(5,6);
        graph.addEdge(7,8);
        graph.addEdge(7,9);
        graph.addEdge(8,9);
        ConnectedComponents<Integer> cc = new ConnectedComponents<>(graph);
        System.out.println(cc.count);
        System.out.println();
        System.out.println(Arrays.toString(cc.component));
        System.out.println(cc.isConnected(0,1));
        System.out.println(cc.isConnected(2,4));
        System.out.println(cc.isConnected(0,5));
        System.out.println(cc.isConnected(7,8));
        System.out.println(cc.isConnected(7,6));

    }




}
