package lists;

/**
 * Created by sergei.kostin on 1/17/18.
 */
public class LinkedListImpl {

    private ListNode root;

    public ListNode getRoot() {
        return root;
    }

    public void add(int val){
        ListNode node = new ListNode(val);
        node.next = root;
        root = node;
    }

    public void remove(){
        if(root != null) root = root.next;
    }

    public void printList( ListNode root){
        if(root == null) return;
        System.out.print(root + " -> ");
        printList(root.next);
    }

    public static class ListNode{

        public ListNode(int val){
            value = val;
        }

        public int value;
        public ListNode next;

        @Override
        public String toString() {
            return value +"";
        }
    }

    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.printList(ll.getRoot());
    }
}
