package hw5.ch10.q1;

import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        for(int i=0; i<5; i++) {
            integers.add(i);
        }

        LQueue<Integer> queue = new LQueue<>();
        System.out.println("Adding list of integers to queue.");
        queue.addAll(integers); // 1
        System.out.println("Current size: " + queue.size() + "\n"); // 2

        System.out.println("Adding integer with enqueue.");
        queue.enqueue(5); // 3
        System.out.println("Current size: " + queue.size() + "\n");

        System.out.println("        Head: " + queue.head() + "\n"); // 4

        while (!queue.isEmpty()) { // 5
            System.out.println("     Dequeue: " + queue.dequeue()); // 6
            System.out.println("Current size: " + queue.size() + "\n");
        }
    }
}
