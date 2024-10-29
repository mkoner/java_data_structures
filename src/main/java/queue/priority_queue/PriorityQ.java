package queue.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQ {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>(Comparator.reverseOrder());
        q.add(4);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
