package lists;

/**
 * Created by sergei.kostin on 4/2/18.
 */
public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;

        ListNode oddRunner = odd;
        ListNode evenRunner = even;


        while(evenRunner != null && evenRunner.next != null){
            oddRunner.next = evenRunner.next;
            evenRunner.next = oddRunner.next.next;
            oddRunner = oddRunner.next;
            evenRunner = evenRunner.next;
        }

        oddRunner.next = even;
        return odd;

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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        OddEvenLinkedList_328 oe = new OddEvenLinkedList_328();
        oe.printList(node1);
        ListNode node = oe.oddEvenList(node1);
        System.out.println();
        oe.printList(node);
    }
}
