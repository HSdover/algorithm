package com.algorithm.programmers.lv1;

import java.util.Arrays;
import java.util.Collections;

public class 정수_내림차순으로_배치하기 {
    public static void main(String[] args) {
        solution();
    }

    public static long solution() {
        long n = 118372;
        long answer = 0;

        String s = String.valueOf(n);

        char[] cc = s.toCharArray();
        Arrays.sort(cc);
        StringBuilder sb = new StringBuilder(String.valueOf(cc));
        sb.reverse();
        answer = Long.parseLong(sb.toString());
        System.out.println(answer);
        return answer;
    }
}
