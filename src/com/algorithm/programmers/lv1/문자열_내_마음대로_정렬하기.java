package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        solution();
    }

    public static String[] solution() {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        // n번째를 알파벳을 각 단어 맨앞으로 뺌
        List<String> sortStrings = new ArrayList<>();
        for(String s : strings)
            sortStrings.add(s.charAt(n) + s);

        // 정렬
        sortStrings.sort(Comparator.naturalOrder());

        // 정답에 넣기
        String[] answer = new String[strings.length];
        for(int i = 0; i < strings.length; i++)
            answer[i] = sortStrings.get(i).substring(1);

        return answer;
    }
}
