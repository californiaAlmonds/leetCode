import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}

class InsertHead{
    public static ListNode insertHead(int val, ListNode head){
        ListNode newNode = new ListNode(val, head);
        return newNode;
    }
}

class PrintList{
    public static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}

class DetectCycle{
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static ListNode entryPoint(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != null && fast != null && slow != fast) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class CyclicLinkedList {
    public static void main(String[] args) {
        ListNode head0 = new ListNode(0);
        ListNode head = InsertHead.insertHead(1, head0);
        head = InsertHead.insertHead(2, head);
        head = InsertHead.insertHead(3, head);
        head = InsertHead.insertHead(4, head);
        head = InsertHead.insertHead(5, head0);
        PrintList.printList(head);
        System.out.println("Has Cycle: " + DetectCycle.hasCycle(head0));
        System.out.println("Entry Point: " + DetectCycle.entryPoint(head).val);
    }
}
