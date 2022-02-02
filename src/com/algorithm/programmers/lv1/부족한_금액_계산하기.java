package com.algorithm.programmers.lv1;

public class 부족한_금액_계산하기 {
    public static void main(String[] args) {
        solution();
    }

    public static long solution() {
        int price = 3;
        int money = 20;
        int count = 4;
        long answer = -1;

        long sum = 0;
        for(int i = 1; i <= count; i++) {
            sum += price * i;
        }

        if(sum - money < 0)
            answer = 0;
        else
            answer = sum - money;
        return answer;
    }
}
