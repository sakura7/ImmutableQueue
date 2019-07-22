package com.codingchallenge.myanswer;

public class ImmutableQueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = ImmutableQueue.getEmptyQueue();
            q = q.enQueue(1);
            printQueue(q);
            q = q.deQueue();
            printQueue(q);
            System.out.println("Is queue empty ? " + q.isEmpty());
            q = q.enQueue(9);
            printQueue(q);
            q = q.enQueue(3);
            printQueue(q);
            q = q.enQueue(4);
            printQueue(q);
            q = q.enQueue(5);
            printQueue(q);
            q = q.enQueue(6);
            printQueue(q);
            q = q.enQueue(7);
            printQueue(q);
            q = q.deQueue();
            printQueue(q);
            q = q.deQueue();
            printQueue(q);
            System.out.println("Is queue empty ? " + q.isEmpty());
    }

        private static void printQueue(Queue<Integer> q){
            System.out.print("[");
            while(q != null && !q.isEmpty()){
                System.out.print(q.head());
                q = q.deQueue();
                if(!q.isEmpty()){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
}