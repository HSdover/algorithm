package com.algorithm.programmers.lv2;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        solution();
    }

    public static List<Integer> solution() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        List<Integer> answer = new ArrayList<>();

        List<Integer> progresses2 = new ArrayList<>();
        List<Integer> speeds2 = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            progresses2.add(progresses[i]);
            speeds2.add(speeds[i]);
        }

        int cnt = 0;
        while(progresses2.size() != 0) {
            for(int i = 0; i < progresses2.size(); i++)
                progresses2.set(i, progresses2.get(i) + speeds2.get(i));

            System.out.println(progresses2.get(0));
            while(progresses2.size() != 0 && progresses2.get(0) >= 100) {
                cnt++;
                progresses2.remove(0);
                speeds2.remove(0);
            }

            if(cnt != 0) {
                answer.add(cnt);
                cnt = 0;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
