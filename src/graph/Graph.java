package graph;

import java.util.*;

/**
 * Created by sergei.kostin on 12/8/17.
 */
public class Graph<T> {

    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;

    public Graph( boolean isDirected ){
        this.isDirected = isDirected;
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
    }

    public void addVertex( Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(Edge<T> edge : vertex.getEdges()){
            allEdges.add(edge);
        }
    }

    public Vertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }

    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }

    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertexes(){
        return allVertex.values();
    }

    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }

    public void addEdge(long id1,long id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }

}

class Vertex<T> {

    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertexes = new ArrayList<>();

    Vertex( long id ) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addAdjacentVertex( Edge<T> e, Vertex<T> v ){
        edges.add(e);
        adjacentVertexes.add(v);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public List<Vertex<T>> getAdjacentVertexes() {
        return adjacentVertexes;
    }

    public int getDegree(){
        return edges.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

class Edge<T> implements Comparable<Edge<T>>{

    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    public Edge( Vertex<T> v1, Vertex<T> v2){
        vertex1 = v1;
        vertex2 = v2;
    }

    public Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2) {
        this.isDirected = isDirected;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge( Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
        this.isDirected = isDirected;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (vertex1 != null ? !vertex1.equals(edge.vertex1) : edge.vertex1 != null) return false;
        return vertex2 != null ? vertex2.equals(edge.vertex2) : edge.vertex2 == null;
    }

    @Override
    public int hashCode() {
        int result = vertex1 != null ? vertex1.hashCode() : 0;
        result = 31 * result + (vertex2 != null ? vertex2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "isDirected=" + isDirected +
                ", vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge<T> o) {
        return this.getWeight() - o.getWeight();
    }
}
