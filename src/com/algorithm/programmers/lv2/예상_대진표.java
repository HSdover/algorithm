package com.algorithm.programmers.lv2;

public class 예상_대진표 {
    public static void main(String[] args) {
        예상_대진표 test = new 예상_대진표();
        test.solution(32, 1, 32);
    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            answer++;
            if(Math.abs(a-b) == 1 && a/2 != b/2)
                break;

            if(a % 2 == 1)
                a = (a / 2) + 1;
            else
                a = a / 2;

            if(b % 2 == 1)
                b = (b / 2) + 1;
            else
                b = b / 2;
        }

        System.out.println(answer);
        return answer;
    }
}
