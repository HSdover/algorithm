package com.algorithm.greedy;

import java.util.PriorityQueue;

public class prac {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(5);
        pq.add(3);
        pq.add(4);
        pq.add(6);

        while(!(pq.isEmpty()))
            System.out.println(pq.poll());
    }
}
