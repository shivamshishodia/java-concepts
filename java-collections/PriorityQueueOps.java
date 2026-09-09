import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueOps {

    /*
     * PriorityQueue operations:
     * - offer(value): adds an element; returns false if insertion fails.
     * - peek(): returns the next element without removing it; returns null if empty.
     * - poll(): returns and removes the next element; returns null if empty.
     *
     * - add(value): adds an element; THROWS an exception if insertion fails.
     * - remove(): returns and removes the next element; THROWS if empty.
     *
     * A PriorityQueue is a min-heap by default: the smallest element has
     * the highest priority. Use Collections.reverseOrder() for a max-heap.
     *
     * Iterating or printing a PriorityQueue does not guarantee sorted order.
     */

    public static void main(String[] args) {
        demonstratePriorityQueueOperations();
    }

    public static void demonstratePriorityQueueOperations() {

        // Min-heap by default: smallest element comes out first.
        // PriorityQueue supports duplicate values
        Queue<Integer> minQueue = new PriorityQueue<>();
        minQueue.addAll(Arrays.asList(5, 3, 6, 8, 2));
        minQueue.offer(1);

        System.out.println("Min-heap peek: " + minQueue.peek()); // 1
        System.out.println("Min-heap poll: " + minQueue.poll()); // 1
        System.out.println("Min-heap poll: " + minQueue.poll()); // 2

        // Max-heap: largest element comes out first.
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(5, 3, 6, 8, 2));
        maxHeap.offer(1);

        System.out.println("Max-heap peek: " + maxHeap.peek()); // 8
        System.out.println("Max-heap poll: " + maxHeap.poll()); // 8
        System.out.println("Max-heap poll: " + maxHeap.poll()); // 6

        // Custom priority queue: lower priority number comes out first.
        record Task(String name, int priority) {
        }

        Queue<Task> customHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.priority(), b.priority())
        );

        customHeap.offer(new Task("Email", 1));
        customHeap.offer(new Task("Meeting", 5));
        customHeap.offer(new Task("Slack", 3));

        System.out.println("Custom-heap peek: " + customHeap.peek());
        System.out.println("Custom-heap poll: " + customHeap.poll());
        System.out.println("Next task name: " + customHeap.poll().name());
    }
}
