package lists;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class SortLinkedList_148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        // 1) Cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // 2) sort each half
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        // 3) merge node1 and node2
        return merge(node1, node2);
    }

    private ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        ListNode dummy = new ListNode(0) ;
        ListNode current = dummy;

        while(head1 != null && head2 != null){
            if(head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            }else{
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if(head1 != null) current.next = head1;
        if(head2 != null) current.next = head2;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void printList(ListNode head){
        if(head == null) return;
        System.out.print(head.val + "->");
        printList(head.next);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(17);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(100);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        SortLinkedList_148 sl = new SortLinkedList_148();
        sl.printList(node1);
        ListNode node = sl.sortList(node1);
        System.out.println();
        sl.printList(node);

    }


}
