import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode list3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = new ListNode[]{list1,list2,list3};
//        ListNode result = Solution.mergeKLists(lists);
        ListNode result = Solution.mergeKLists(new ListNode[0]);

//        System.out.println(new ListNode().val);

        while(result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }

    }
}

class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1) return null;
        if(lists.length==1) return lists[0];
        for(int i = 0; i < lists.length-1; i++){
            ListNode node = mergeTwo(lists[i],lists[i+1]);
            lists[i+1] = node;
        }
        return lists[lists.length-1];
    }

    private static ListNode mergeTwo(ListNode list1, ListNode list2){
        ListNode result = new ListNode(-1);
        ListNode cur = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return result.next;
    }

    //------------------------------------------------------------------------------------------

    public ListNode mergeKLists1(ListNode[] lists) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                arrayList.add(lists[i].val);
                lists[i] = lists[i].next;
            }

        }
        Collections.sort(arrayList);

        ListNode head = new ListNode();
        ListNode answer = head;
        for (int i = 0; i < arrayList.size(); i++) {
            head.next = new ListNode(arrayList.get(i));
            head = head.next;

        }

        return answer.next;
    }

    //------------------------------------------------------------------------------------------


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}