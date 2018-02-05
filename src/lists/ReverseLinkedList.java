package lists;

import java.util.List;

/**
 * Created by sergei.kostin on 1/17/18.
 */
public class ReverseLinkedList {

    public LinkedListImpl.ListNode reverse(LinkedListImpl.ListNode root){
        if(root == null) return null;
        return reverse(root, null);
    }

    private LinkedListImpl.ListNode reverse(LinkedListImpl.ListNode root, LinkedListImpl.ListNode prev){
        if(root.next == null) {
            root.next = prev;
            return root;
        }

        LinkedListImpl.ListNode next = root.next;
        root.next = prev;
        prev = root;
        return reverse(next, prev);
    }

    public LinkedListImpl.ListNode reverseIterative(LinkedListImpl.ListNode root){
        if(root == null || root.next == null) return root;
        LinkedListImpl.ListNode prev = null;
        LinkedListImpl.ListNode next = null;
        while(root.next != null){
            next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        root.next = prev;
        return root;
    }

    public LinkedListImpl.ListNode reverseRec(LinkedListImpl.ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        LinkedListImpl.ListNode last = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public LinkedListImpl.ListNode reverseRec(LinkedListImpl.ListNode head, Integer n){
        if(head == null || head.next == null){
            return head;
        }

        LinkedListImpl.ListNode last = reverseRec(head.next, n);
        n = n -1;
        System.out.println(n);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public int findKthFromEnd(LinkedListImpl.ListNode head, int k){
        if(head == null) return 0;
        int i = findKthFromEnd(head.next, k);
        i++;
        if(i == k){
            System.out.println(head.value);
        }
        return i;
    }

    public LinkedListImpl.ListNode findKthFromEndWithWrapper(LinkedListImpl.ListNode head, int k){
        IntWrapper w = new IntWrapper();
        return findKthFromEndWithWrapper(head, k, w);
    }

    private LinkedListImpl.ListNode findKthFromEndWithWrapper(LinkedListImpl.ListNode head, int k, IntWrapper w){
        if(head == null) return null;
        LinkedListImpl.ListNode result = findKthFromEndWithWrapper(head.next, k, w);
        w.val = w.val + 1;
        if(w.val == k){
            result = head;
        }
        return result;
    }

    private static class IntWrapper{
        int val = 0;
    }


    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        LinkedListImpl ll = new LinkedListImpl();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.printList(ll.getRoot());
        System.out.println();
        System.out.println(rl.findKthFromEndWithWrapper(ll.getRoot(), 4));
    }

}
