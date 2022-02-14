package com.algorithm.programmers.lv2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class 기능개발 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = {};

        Stack<Integer> st = new Stack<>();
        for(int i = progresses.length-1; i >= 0; i--)
            st.push(progresses[i]);

        st.add(0, 20);
        System.out.println(st);

        return answer;
    }
}
