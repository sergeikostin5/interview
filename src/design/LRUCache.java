package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 3/24/18.
 */
class LRUCache {

    private DLList doublyList;
    private Map<Integer, Node> map;
    private final int MAX_CAPACITY;

    public LRUCache(int capacity) {
        MAX_CAPACITY = capacity;
        map = new HashMap<>();
        doublyList = new DLList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else {
            Node node = map.get(key);
            doublyList.promote(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            doublyList.promote(node);
            return;
        }

        if(map.size() == MAX_CAPACITY){
            int removed = doublyList.removeLast();
            map.remove(removed);
        }
        Node newNode = new Node(key, value);
        doublyList.insertFirst(newNode);
        map.put(key, newNode);
    }

    private static class Node{
        int key;
        int value;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private static class DLList{

        Node head;
        Node tail;

        void insertFirst(Node node){
            if(head == null){
                head = node;
                tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        int removeLast(){
            int result = tail.key;
            if(tail == head){
                tail = null;
                head = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;
            }
            return result;
        }

        void promote(Node node){
            if(head == node) return;
            node.prev.next = node.next;
            if(node.next != null){
                node.next.prev = node.prev;
            }else{
                tail = node.prev;
            }
            head.prev = node;
            node.next = head;
            head = node;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4


    }

}
