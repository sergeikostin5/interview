package hash;

import java.util.LinkedList;

/**
 * Created by sergei.kostin on 2/4/18.
 */
public class HashTable<Key, Value> {

    private final int MAX_SIZE = 10;
    LinkedList<Cell<Key, Value>>[] items;

    public HashTable(){
        items = (LinkedList<Cell<Key,Value>>[]) new LinkedList[MAX_SIZE];
    }

    public void put(Key key, Value val){
        int x = hashCodeOfKey(key);
        if(items[x] == null){
            items[x] = new LinkedList<>();
        }
        LinkedList<Cell<Key, Value>> collided = items[x];
        for(Cell<Key, Value> cell : collided){
            if(cell.key.equals(key)){
                cell.value = val;
                return;
            }
        }
        collided.add(new Cell<>(key,val));
    }

    public Value get(Key key){
        int x = hashCodeOfKey(key);
        LinkedList<Cell<Key, Value>> collided = items[x];
        if(collided == null) return null;
        for(Cell<Key, Value> cell : collided){
            if(cell.key.equals(key)) return cell.value;
        }
        return null;
    }

    public int hashCodeOfKey(Key key){
        return key.hashCode()%items.length;
    }

    private static class Cell<Key, Value>{
        private Key key;
        private Value value;
        public Cell(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("One", 1);
        table.put("Two", 2);
        table.put("Three", 3);
        System.out.println(table.get("One"));
        System.out.println(table.get("Two"));
        System.out.println(table.get("Three"));
    }

}
