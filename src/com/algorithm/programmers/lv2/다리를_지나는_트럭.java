package com.algorithm.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        다리를_지나는_트럭 t = new 다리를_지나는_트럭();
        int[] truck_weights = {7,4,5,6};
        t.solution(2, 10, truck_weights);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int w = 0, i = 0;

        while(q.size() != 0) {
            if(answer == 0)
                q.poll();

            answer++;

            if(answer > answer % (bridge_length+1))
                w -= q.poll();

            if(i < truck_weights.length && w + truck_weights[i] <= weight) {
                q.offer(truck_weights[i]);
                w += truck_weights[i++];
            }
            else if(i != truck_weights.length)
                q.offer(0);
            System.out.println(q);
        }

        System.out.println(answer);
        return answer;
    }
}
