import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
      public class ListNode {
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
      }

      public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = createMinHeap(lists);
            ListNode head = new ListNode();
            ListNode tail = new ListNode();

            while (!minHeap.isEmpty()) {
                  ListNode node = minHeap.poll();
                  tail.next = node;

                  if(node.next != null) {
                        minHeap.add(node.next);
                  }
            }

            return head.next;
      }

      PriorityQueue<ListNode> createMinHeap(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                  Comparator.comparingInt(l -> l.val)
            );
            for (ListNode node : lists) {
                  if (node != null) minHeap.add(node);
            }

            return minHeap;
      }

      public static void main(String[] args) {
            MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
            mergeKSortedLists.mergeKLists()
      }
}