public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode list2 = new ListNode();
        ListNode result = Solution.swapPairs1(list1);

        while(result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }


    }
}

class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode result;
        if(head == null || head.next == null) return head;
        else result = head.next;

        ListNode curr;
        ListNode prev = null;
        while(head != null && head.next != null){

            curr = head.next;
            head.next = curr.next;
            curr.next = head;
            if(prev != null){
                prev.next = curr;
            }
            prev = head;
            head = head.next;
        }

        return result;
    }

    public static ListNode swapPairs1(ListNode head) {
        ListNode zeroNode = new ListNode(0);
        ListNode result = zeroNode;

        while (head != null) {
            if (head.next != null) {
                ListNode node = new ListNode(head.next.val, new ListNode(head.val));
                result.next = node;
                result = node.next;
                head = head.next.next;
            } else {
                ListNode node = new ListNode(head.val);
                result.next = node;
                result = node;
                head = head.next;
            }
        }
        return zeroNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}