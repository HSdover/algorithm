package com.algorithm.programmers.lv1;

import java.util.Arrays;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));

        for(int i = 0; i < completion.length; i++) {
            if(participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
            else if(i == completion.length - 1)
                answer = participant[i + 1];
        }
        System.out.println(answer);
        return answer;
    }
}
