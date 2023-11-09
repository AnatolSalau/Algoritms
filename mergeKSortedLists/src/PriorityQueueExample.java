import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
      public static void main(String[] args) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.addAll(Arrays.asList(4,5,8,2,3,0));
            System.out.println(priorityQueue);
            System.out.println("priorityQueue");
            System.out.println("poll (get and remove min element) : " + priorityQueue.poll());
            System.out.println("add 1: " + priorityQueue.add(1));
            System.out.println("priorityQueue : " + priorityQueue);
            System.out.println("poll (get and remove min element) : " + priorityQueue.poll());

            System.out.println();

            System.out.println("priorityQueueWithComparator");
            PriorityQueue<Integer> priorityQueueWithComparator = new PriorityQueue<>(Collections.reverseOrder());
            priorityQueueWithComparator.addAll(Arrays.asList(4,5,8,2,3,0));
            System.out.println(priorityQueueWithComparator);
            while (!priorityQueueWithComparator.isEmpty()) {
                  Integer poll = priorityQueueWithComparator.poll();
                  System.out.print(poll + " ");
            }

      }
}
