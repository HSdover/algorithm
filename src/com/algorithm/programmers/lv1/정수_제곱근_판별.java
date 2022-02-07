package com.algorithm.programmers.lv1;

public class 정수_제곱근_판별 {
    public static void main(String[] args) {
        solution();
    }

    public static long solution() {
        long n = 121;
        long answer = 0;

        double d = Math.sqrt(n);
        if((int)d == d)
            answer = (long) ((d +1) * (d + 1));
        else
            answer = -1;

        System.out.println(answer);
        return answer;
    }
}
