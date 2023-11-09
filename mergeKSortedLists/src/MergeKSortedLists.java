import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
                  ListNode[] arr2 = {list1, list2, list3, list4, list5};
                  ListNode[] arr3 = {list1, list2, list3, list4, list5};
                  ListNode headOfList = mergeKSortedLists.mergeKLists(arr1, arr2, arr3);
                  mergeKSortedLists.printOneLinkList(headOfList);
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
      public ListNode mergeKLists(ListNode[]... lists) {
            PriorityQueue<ListNode> minHeap = createMinHeap(lists);
            ListNode head = minHeap.poll();
            ListNode tail = null;
            ListNode prev = head;

            while (!minHeap.isEmpty()) {
                  ListNode node = minHeap.poll();
                  prev.next = node;
                  prev = node;
                  prev.next = null;
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

      void printOneLinkList(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                  System.out.print(curr + " -> ");
                  curr = curr.next;
            }
      }
}