package com.algorithm.programmers.lv1;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        solution();
    }
    public static int solution() {
        int[] numbers = {1,2,3,4,6,7,8,0};
        int answer = -1;

        int all = 45;
        int sum = 0;
        for(int num : numbers)
            sum += num;

        answer = all - sum;
        System.out.println(answer);
        return answer;
    }
}
