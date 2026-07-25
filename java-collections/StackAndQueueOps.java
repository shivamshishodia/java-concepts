import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackAndQueueOps {

    public static void main(String[] args) {
        // Stack is a legacy class that extends Vector, exposing many unrelated indexed-list operations.
        // Stack is synchronized by default, which adds unnecessary overhead in most single-threaded cases.
        demoStackOps();
        demoQueueOps();
        // Use Deque instead The same structure can act as both a stack (push, pop, peek) and a queue (offer, poll, peek).
        demoDeque();
    }

    public static void demoStackOps() {
        Stack<String> names = new Stack<>();
        names.push("First");
        names.push("Second");
        names.push("Third");
        names.push("Fourth");
        System.out.println(names.peek());
        names.pop();
        System.out.println(names.peek());
        System.out.println(names.isEmpty());
        names.clear();
        System.out.println(names.isEmpty());
    }

    public static void demoQueueOps() {
        // Basic queue operations:
        // offer(e) — add to the rear; returns false if it cannot add.
        // poll() — removes and returns the front; returns null if empty.
        // peek() — returns the front without removing it; returns null if empty.
        Queue<String> names = new ArrayDeque<>();
        names.offer("Shivam");
        names.offer("Sneha");
        System.out.println("peek" + names.peek());
        names.poll();
        System.out.println("peek" + names.peek());

        // There are also exception-throwing alternatives:
        // add(e) instead of offer(e) offer returns false; add throws IllegalStateException (for bounded queues, such as ArrayBlockingQueue)
        // remove() instead of poll() poll returns null; remove throws NoSuchElementException
        // element() instead of peek() peek returns null; element throws NoSuchElementException
        // For most application code, prefer offer, poll, and peek because empty/full cases are handled without exceptions.

    }

    public static void demoDeque() {
        Deque<String> names = new ArrayDeque<>();
        names.offerLast("Shivam");
        names.offerLast("Sneha");
        names.offerLast("Sunita");
        names.offerLast("Tikam");
        System.out.println("peekLast" + names.peekLast());
        System.out.println("peekFirst" + names.peekFirst());
        System.out.println(names);

        names.pollFirst();
        names.pollFirst();
        System.out.println(names);

        names.pollLast();
        System.out.println(names);
    }
}
