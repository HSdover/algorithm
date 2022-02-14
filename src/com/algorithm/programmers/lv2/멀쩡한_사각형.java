package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 멀쩡한_사각형 {
    public static void main(String[] args) {
        solution(100000000, 99999999);
    }

    public static List<Integer> getMeasure(int num) {
        List<Integer> measure = new ArrayList<>();
        for(int i = 1; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) {
                measure.add(num/i);
                measure.add(i);
            }
        }
        return measure;
    }
    // https://leedakyeong.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95-in-python
    // 이 사람은 천재인가..?
    public static long solution(int w, int h) {
        long answer = 1;

        List<Integer> wList = getMeasure(w);
        List<Integer> hList = getMeasure(h);


        hList.sort(Comparator.naturalOrder());
        wList.sort(Comparator.naturalOrder());
        int max = 1;
        for(int i = 0; i < wList.size(); i++) {
            for(int j = 0; j < hList.size(); j++) {
                if(wList.get(i).equals(hList.get(j)))
                    max = wList.get(i);
            }
        }

        answer = (long)(w * h) - (long)(w + h - max);
        System.out.println(wList);
        System.out.println(hList);
        System.out.println(max);
        System.out.println(answer);
        return answer;
    }
}
