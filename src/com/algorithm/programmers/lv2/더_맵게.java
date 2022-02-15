package com.algorithm.programmers.lv2;

import java.util.*;

public class 더_맵게 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] scoville = {2, 1, 9, 3, 10, 12};
        int K = 7;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i = 0; i < scoville.length; i++)
            pq.offer(scoville[i]);

        int min;
        while(pq.peek() < K && pq.size() > 1) {
            min = pq.poll() + pq.poll() * 2;
            pq.offer(min);
            answer++;
        }

        if(pq.size() == 1 && pq.peek() < K)
            answer = -1;
        return answer;
    }
}
