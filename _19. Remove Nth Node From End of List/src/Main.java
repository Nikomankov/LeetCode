import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {
        ListNode head1 = new ListNode();


    }
}

class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        int count = 0;
        while (first != null) {
            count++;
            first = first.next;
        }
        int len = count - n;
        if (len == 0) {
            head = head.next;
        }
        else {
            ListNode second = head;
            while (len - 1 != 0) {
                second = second.next;
                len--;
            }
            second.next = second.next.next;
        }
        return head;
    }
}