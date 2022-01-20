package com.algorithm.programmers.lv1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        solution();

    }

    public static int[] solution() {
        int[] answer = new int[2];
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int win = 7, zeroCnt = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] != 0) {
                for(int j = 0; j < win_nums.length; j++) {
                    if(lottos[i] == win_nums[j])
                        win--;
                }
            }
            else
                zeroCnt++;

        }
        answer[1] = win;
        answer[0] = win - zeroCnt;
        if(win == 7)
            win = 6;
        if(answer[0] == 7)
            answer[0] = 6;
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
