package lists;

/**
 * Created by sergei.kostin on 1/18/18.
 */
public class ZipList {

    public void zipList(LinkedListImpl.ListNode pList){
        if(pList == null) return;
        LinkedListImpl.ListNode slow = pList;
        LinkedListImpl.ListNode fast = pList;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListImpl.ListNode root2 = reverseList(slow, null);

        LinkedListImpl ll = new LinkedListImpl();
        System.out.println();
        ll.printList(root2);

        LinkedListImpl.ListNode next1;
        LinkedListImpl.ListNode next2;

        while(pList != null && root2 != null){
            next1 = pList.next;
            if(next1 == root2) next1 = null;
            next2 = root2.next;
            pList.next = root2;
            root2.next = next1;
            root2 = next2;
            pList = next1;
        }

    }

    private LinkedListImpl.ListNode reverseList(LinkedListImpl.ListNode root, LinkedListImpl.ListNode prev){
        if(root.next == null) {
            root.next = prev;
            return root;
        }
        LinkedListImpl.ListNode next = root.next;
        root.next = prev;
        prev = root;
        return reverseList(next, prev);
    }




    public static void main(String[] args) {
        ZipList zl = new ZipList();
        LinkedListImpl ll = new LinkedListImpl();
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.printList(ll.getRoot());
        zl.zipList(ll.getRoot());
        System.out.println();
        System.out.println(ll.getRoot());
        ll.printList(ll.getRoot());
    }
}
