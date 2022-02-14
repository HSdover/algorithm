package com.algorithm.programmers.lv2;

public class lv2_124나라의_숫자 {
    public static void main(String[] args) {
        solution(10);
    }

    public static StringBuilder solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n > 0) {
           if(n % 3 == 0) {
               answer.insert(0, "4");
               n = n / 3 - 1;
           }
           else {
               answer = answer.insert(0,n % 3);
               n /= 3;
           }
        }
        System.out.println(answer);
        return answer;
    }
}
