/**
 * DoublePointer
 * User: nolau
 * Date: 2021/5/20
 * Time: 9:36
 */
package cn.nolaurence.sort;

public class DoublePointer {
    public static ListNode swapPairs(ListNode head) {
        ListNode newListHead = new ListNode(0);
        ListNode pointer = new ListNode(0);

        newListHead = head.next;
        pointer = newListHead;
        while(head.next != null) {
            pointer.next = head.next;
            pointer = pointer.next;
            pointer.next = head;
            pointer = pointer.next;

            head = head.next.next;
        }
        return newListHead;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
        ListNode head, p;
        head = new ListNode(0);
        p = head;

        // init
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                head = new ListNode(a[i]);
                p = head;
                p = p.next;
            } else {
                p.next = new ListNode(a[i]);
                p = p.next;
            }
        }
        p = DoublePointer.swapPairs(head);
        while (p.next != null) {
            System.out.println(p.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}