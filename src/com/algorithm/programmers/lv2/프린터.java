package com.algorithm.programmers.lv2;

import java.util.*;

public class 프린터 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(priorities[i]);
        }

        boolean escape = true;
        while(escape) {
            for(int i = 0; i < priorities.length; i++) {
                int doc = q.poll();
                if(pq.peek() == doc) {
                    System.out.println(location);
                    System.out.println("pq = " + pq.peek());
                    answer++;
                    if(location == 0) {
                        escape = false;
                        break;
                    }
                    else
                        pq.poll();
                }
                else
                    q.add(doc);

                if(location == 0)
                    location = q.size()-1;
                else
                    location--;
            }
        }
        return answer;
    }
}
