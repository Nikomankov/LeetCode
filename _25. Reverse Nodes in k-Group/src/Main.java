public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));

        Long start = System.currentTimeMillis();

        ListNode result = Solution.reverseKGroup(list1,3);

//        System.out.println(System.currentTimeMillis()-start);
//        ListNode result = Solution.helper(list1,3);

        while(result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}

class Solution {
    private static ListNode result;
    private static ListNode auxNode;

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head.next == null) return head;
        ListNode countNode = head;
        result = new ListNode(-1);
        auxNode = result;

        //Count nodes
        int counter = 0;
        while(countNode!=null){
            countNode = countNode.next;
            counter++;
        }
        if(counter<k) return head;

        //Reverse
        for(int i = 0; i < counter/k; i++){
            if(i != 0) head = head.next;
            helper(head,k);
        }

        return result.next;
    }

    public static void helper(ListNode node, int count){
        if(count==1 || node == null){
            auxNode.next = node;
            auxNode = auxNode.next;
            return;
        }
        helper(node.next,count-1);
        node.next = auxNode.next;
        auxNode.next = node;
        auxNode = auxNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}