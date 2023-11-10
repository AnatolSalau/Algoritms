import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
      public static class ListNode {
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
                  return "ListNode{" +
                        "val=" + val +
                        '}';
            }
      }

            public static void main(String[] args) {
                  MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

                  ListNode list5 = new ListNode(5, null);
                  ListNode list4 = new ListNode(4, list5);
                  ListNode list3 = new ListNode(3, list4);
                  ListNode list2 = new ListNode(2, list3);
                  ListNode list1 = new ListNode(1, list2);
                  ListNode[] arr1 = {list1, list2, list3, list4, list5};
                  ListNode list50 = new ListNode(5, null);
                  ListNode list40 = new ListNode(4, list5);
                  ListNode list30 = new ListNode(3, list4);
                  ListNode list20 = new ListNode(2, list3);
                  ListNode list10 = new ListNode(1, list2);
                  ListNode[] arr2 = {list10, list20, list30, list40, list50};
                  ListNode list500 = new ListNode(500, null);
                  ListNode list400 = new ListNode(4, list5);
                  ListNode list300 = new ListNode(3, list4);
                  ListNode list200 = new ListNode(2, list3);
                  ListNode list100 = new ListNode(1, list2);
                  ListNode[] arr3 = {list100, list200, list300, list400, list500};
                  ListNode headOfList = mergeKSortedLists.mergeKLists(arr1, arr2, arr3);
                  mergeKSortedLists.printOneLinkedList(headOfList);
            }
            /*    1, 2, 3, 4, 5
                  head(1)
                  head.next = previous
                  previous(1)
                  tail(null)

                  2, 3, 4, 5
                  tail(2)
                  curr.nex(tail);

             */
            /*
                  head = 1
                  prev = 1
                  -------------while----------------
                  prev = 2

             */
      public ListNode mergeKLists(ListNode[]... lists) {
            PriorityQueue<ListNode> minHeap = createMinHeap(lists);
            ListNode head = minHeap.poll(); // link to head
            ListNode prev = head;   //link to previous element
            ListNode tail = null;   // link to tail

            while (!minHeap.isEmpty()) {
                  ListNode curr = minHeap.poll();
                  prev.next = curr;

                  prev = curr;// change pointer from old to new

                  if (minHeap.isEmpty()) {
                        tail = curr;
                        tail.next = null;
                  }
            }
            return head;
      }

      PriorityQueue<ListNode> createMinHeap(ListNode[]... lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                  Comparator.comparingInt(l -> l.val)
            );
            for (ListNode[] arr : lists) {
                  for (ListNode node : arr)
                        if (node != null) minHeap.add(node);
            }
            return minHeap;
      }

      void printOneLinkedList(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                  System.out.print(curr + " -> ");
                  curr = curr.next;
            }
      }
}