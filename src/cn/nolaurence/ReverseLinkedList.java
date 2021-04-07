package cn.nolaurence;

public class ReverseLinkedList {
    // 反转链表的衣部分：给你一个索引区间，让你把单链表中这部分元素反转，其他部分不变
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;  // base case
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 这个函数中，最终head就是最后一个node
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;  // 理解不能
    }
}
