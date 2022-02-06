package com.algorithm.programmers.lv1;

import java.util.Arrays;
import java.util.Locale;

public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String s = "try           hello world";
        String answer = "";

        String[] word = s.split(" ", -1);
        System.out.println(Arrays.toString(word));
        for(int i = 0; i < word.length; i++) {
            for(int j = 0; j < word[i].length(); j++) {
                    if(j % 2 == 0)
                        answer += word[i].substring(j, j+1).toUpperCase(Locale.ROOT);
                    else if(j % 2 == 1)
                        answer += word[i].substring(j, j+1).toLowerCase(Locale.ROOT);
            }
            if(i != word.length-1)
                answer += " ";
        }
        System.out.println(answer);
        return answer;
    }
}
