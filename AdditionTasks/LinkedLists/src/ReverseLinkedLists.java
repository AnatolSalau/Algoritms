import java.util.Stack;

public class ReverseLinkedLists {
      static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                  this.val = val;
            }

            ListNode(int val, ListNode next) {
                  this.val = val;
                  this.next = next;
            }

            @Override
            public String toString() {
                  return " ListNode{" +
                        "val=" + val +
                        '}';
            }
      }

      ListNode reverseListByStack(ListNode head) {
            Stack<ListNode> stack = new Stack<>();

            ListNode curr = head; //add new link to head
            while (curr.next != null) { // fill stack
                  stack.push(curr);
                  curr = curr.next;
            }
            head.next = null; // first element in stack, still have link to next, will make it null
            head = curr;// last curr = new head of list

            while (!stack.isEmpty()) {
                  ListNode pop = stack.pop();
                  if (head.next == null) {//add next link in head
                        head.next = pop;
                        curr = pop;
                  } else {// add next link other elements
                        curr.next = pop;
                        curr = pop;
                  }
            }
            return head;
      }

      void printList(ListNode head) {
            ListNode curr = head;
            while (curr.next != null) {
                  System.out.println(curr);
                  curr = curr.next;
            }
            System.out.println(curr);
      }
      public static void main(String[] args) {
            testOne();
      }

      static void testOne() {
            ListNode list5 = new ListNode(5, null);
            ListNode list4 = new ListNode(4, list5);
            ListNode list3 = new ListNode(3, list4);
            ListNode list2 = new ListNode(2, list3);
            ListNode list1 = new ListNode(1, list2);
            ReverseLinkedLists reverseLinkedLists = new ReverseLinkedLists();
            System.out.println("Linked list");
            reverseLinkedLists.printList(list1);
            ListNode result = reverseLinkedLists.reverseListByStack(list1);
            System.out.println("Reversed list");
            reverseLinkedLists.printList(result);
      }

      static void testTwo() {
            ListNode list50 = new ListNode(5, null);
            ListNode list40 = new ListNode(4, list50);
            ListNode list30 = new ListNode(3, list40);
            ListNode list20 = new ListNode(2, list30);
            ListNode list10 = new ListNode(1, list20);
            ListNode[] arr2 = {list10, list20, list30, list40, list50};
      }

      static void testThree() {
            ListNode list500 = new ListNode(500, null);
            ListNode list400 = new ListNode(4, list500);
            ListNode list300 = new ListNode(3, list400);
            ListNode list200 = new ListNode(2, list300);
            ListNode list100 = new ListNode(1, list200);
            ListNode[] arr3 = {list100, list200, list300, list400, list500};
      }


}
