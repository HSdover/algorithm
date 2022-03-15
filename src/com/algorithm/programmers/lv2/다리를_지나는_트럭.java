package com.algorithm.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        다리를_지나는_트럭 t = new 다리를_지나는_트럭();
        int[] truck_weights = {10};
        t.solution(100, 100, truck_weights);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int w = 0, i = 0;

        while(i != truck_weights.length) {
            answer++;

            if(q.size() > bridge_length)
                w -= q.poll();

            if(w + truck_weights[i] <= weight) {
                q.offer(truck_weights[i]);
                w += truck_weights[i];
                i++;
            }
            else
                q.offer(0);
        }
        System.out.println(q.size());
        System.out.println(q.peek());
        answer += bridge_length;
        System.out.println(answer);
        return answer;
    }
}
