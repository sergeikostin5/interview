package lists;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 1/11/18.
 */
public class LRUCache<K, V> {

    private DLList<K,V> list;
    private Map<K, DLList.DLListNode<K, V>> map;
    private int mCapacity;
    private int size;

    public LRUCache(int capacity){
        mCapacity = capacity;
        size = 0;
        list = new DLList<>(capacity);
        map = new HashMap<>(capacity);
    }

    public V get(K key){
        if(map.containsKey(key)){
            DLList.DLListNode<K, V> node = map.get(key);
            list.relink(node);
            return node.value;
        } else {
            return null;
        }
    }

    public void set(K key,V value){
        if(map.containsKey(key)){
            DLList.DLListNode node = map.get(key);
            node.value = value;
        } else {
            DLList.DLListNode node = new DLList.DLListNode(key, value);
            map.put(key, node);
            list.add(node);
            size++;
        }
    }

    private static class DLList<K,V>{

        private DLListNode<K,V> head;
        private DLListNode<K,V> tail;
        int capacity;
        int size;

        DLList( int capacity){
            this.capacity = capacity;
            head = null;
            tail = null;
        }

        void relink( DLListNode<K, V> node){
            if(node == head){
                return;
            }
            node.previous.next = node.next;
            if(node != tail){
                node.next.previous = node.previous;
            }
            node.next = head;
            head.previous = node;
            head = node;
            node.previous = null;
        }

        void add( DLListNode<K,V> node){
            if(head == null){
                head = node;
                tail = node;
            } else {
                if(size == capacity){
                    removeLast();
                }
                node.next = head;
                head.previous = node;
                head = node;
            }
            size++;
        }

        private void removeLast() {
            tail = tail.previous;
            tail.next = null;

        }


        private static class DLListNode<K, V>{

            DLListNode<K,V> next;
            DLListNode<K,V> previous;
            K key;
            V value;

            DLListNode(K key, V value){
                this.key = key;
                this.value = value;
            }

        }

    }



}
