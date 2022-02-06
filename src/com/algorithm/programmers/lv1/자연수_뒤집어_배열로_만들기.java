package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        long n = 12340;

        List<Integer> num = new ArrayList<>();
        while(n != 0) {
            num.add((int) n % 10);
            n /= 10;
        }
        System.out.println(num);
        int[] answer = new int[num.size()];
        for(int i = 0; i < num.size(); i++)
            answer[i] = num.get(i);

        return answer;
    }
}
