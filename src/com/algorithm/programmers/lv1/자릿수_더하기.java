package com.algorithm.programmers.lv1;

public class 자릿수_더하기 {

    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int n = 987;
        int answer = 0;

        while(n != 0) {
            answer += n % 10;
            n = n / 10;
        }
        System.out.println(answer);
        return answer;
    }
}
