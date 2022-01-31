package com.algorithm.programmers.lv1;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] d = {1,3,2,5,4};
        int budget = 9;

        Arrays.sort(d);
        int cnt = 0;
        for(int dept : d) {
            budget -= dept;
            if(budget >= 0)
                cnt++;
            else
                break;
        }

        int answer = cnt;
        System.out.println(answer);
        return answer;
    }
}
