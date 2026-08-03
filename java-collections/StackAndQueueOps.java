import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackAndQueueOps {

    public static void main(String[] args) {
        // Stack is a legacy class that extends Vector and exposes unrelated indexed-list operations.
        // It is synchronized by default, which can add unnecessary overhead in single-threaded code.
        demonstrateStackOperations();
        demonstrateQueueOperations();
        // A Deque can act as both a stack (push, pop, peek) and a queue (offer, poll, peek).
        demonstrateDequeOperations();
    }

    public static void demonstrateStackOperations() {
        Stack<String> names = new Stack<>();
        names.push("First");
        names.push("Second");
        names.push("Third");
        names.push("Fourth");

        System.out.println("Stack after pushes: " + names);
        System.out.println("Top element: " + names.peek());
        System.out.println("Popped element: " + names.pop());
        System.out.println("Stack after pop: " + names);
        System.out.println("New top element: " + names.peek());
        System.out.println("Is empty: " + names.isEmpty());

        names.clear();
        System.out.println("Stack after clear: " + names);
        System.out.println("Is empty: " + names.isEmpty());
    }

    public static void demonstrateQueueOperations() {
        // Basic queue operations:
        // offer(e): Adds an element to the rear and returns false if it cannot be added.
        // poll(): Removes and returns the front element, or null if the queue is empty.
        // peek(): Returns the front element without removing it, or null if the queue is empty.
        Queue<String> names = new ArrayDeque<>();
        names.offer("Shivam");
        names.offer("Sneha");

        System.out.println("Queue after offers: " + names);
        System.out.println("Front element: " + names.peek());
        System.out.println("Removed front element: " + names.poll());
        System.out.println("Queue after poll: " + names);
        System.out.println("New front element: " + names.peek());

        // Equivalent operations that throw exceptions when they cannot succeed:
        // add(e) instead of offer(e): offer returns false, while add throws IllegalStateException.
        // This distinction matters for bounded queues, such as ArrayBlockingQueue.
        // remove() instead of poll(): poll returns null, while remove throws NoSuchElementException.
        // element() instead of peek(): peek returns null, while element throws NoSuchElementException.
        // Prefer offer, poll, and peek when you want to handle empty or full queues without exceptions.
    }

    public static void demonstrateDequeOperations() {
        // Using general queue specific methods (offer, poll, and peek)
        Deque<String> cars = new ArrayDeque<>();
        cars.offer("Innova");
        cars.offer("Suzuki");
        System.out.println("Front element: " + cars.peek());
        System.out.println("Remove front element: " + cars.poll());
        System.out.println("Front" + cars.peek());

        // Using specific operation methods
        Deque<String> names = new ArrayDeque<>();
        names.offerLast("Shivam");
        names.offerLast("Sneha");
        names.offerLast("Sunita");
        names.offerLast("Tikam");

        System.out.println("Deque after offers: " + names);
        System.out.println("First element: " + names.peekFirst());
        System.out.println("Last element: " + names.peekLast());

        System.out.println("Removed from front: " + names.pollFirst());
        System.out.println("Removed from front: " + names.pollFirst());
        System.out.println("Deque after front removals: " + names);

        System.out.println("Removed from rear: " + names.pollLast());
        System.out.println("Deque after rear removal: " + names);
    }
}
