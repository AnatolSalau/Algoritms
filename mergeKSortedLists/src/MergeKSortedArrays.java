import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MergeKSortedArrays {
      public static void main(String[] args) {

      }

      public ArrayList<Integer> mergeKLists(ArrayList<Integer>... lists) {
            ListNode head = new ListNode(), tail = head;

            while (!minHeap.isEmpty()) {
                  ListNode node = minHeap.poll();
                  tail.next = node;
                  tail = node;

                  if (node.next != null) {
                        minHeap.add(node.next);
                  }
            }

            return head.next;
            return null;
      }
}
