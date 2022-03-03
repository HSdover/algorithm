package com.algorithm.programmers.lv2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class 프린터 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(priorities[i]);
        }

        System.out.println(q);
        boolean escape = true;
        while(escape) {
            for(int i = 0; i < priorities.length; i++) {
                answer++;
                if(pq.peek() == q.poll()) {
                    if(location == 0)
                        escape = false;
                    else
                        location--;
                }
                else {
                    q.add(q.poll());
                    if(location == 0)
                        location = q.size();
                    else
                        location--;
                }
            }
            System.out.println(answer);
        }





        return answer;
    }
}
