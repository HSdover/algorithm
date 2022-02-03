package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문자열_내림차순으로_배치하기 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String s = "Zbcdefg";
        String answer = "";

        // 이게 더 빠름
        char[] sToC = s.toCharArray();
        Arrays.sort(sToC);

        StringBuilder sb = new StringBuilder(String.valueOf(sToC));
        answer = sb.reverse().toString();

//        List<Character> upper = new ArrayList<>();
//        List<Character> lower = new ArrayList<>();
//        for(int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
//                upper.add(s.charAt(i));
//            else if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a')
//                lower.add(s.charAt(i));
//        }
//        upper.sort(Comparator.reverseOrder());
//        lower.sort(Comparator.reverseOrder());
//
//        for(int i = 0; i < lower.size(); i++)
//            answer += lower.get(i);
//
//        for(int i = 0; i < upper.size(); i++)
//            answer += upper.get(i);

        return answer;
    }
}
