package com.algorithm.programmers.lv2;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        solution("{{2,1,3,4},{2,1},{2},{2,1,3}}");
    }

    public static int[] solution(String s) {
        StringBuilder sb = new StringBuilder(s.substring(1, s.length()-1));
        for(int i = 0; i < sb.length(); i++) {
            if(i != sb.length()-1 && sb.charAt(i) == '}')
                sb.setCharAt(i+1, ' ');
        }

        String[] tuple = sb.toString().split(" ");
        for(int i = 0; i < tuple.length; i++)
            tuple[i] = tuple[i].substring(1, tuple[i].length()-1);

        String[][] tuple2 = new String[tuple.length][];
        for(int i = 0; i < tuple.length; i++)
            tuple2[i] = tuple[i].split(",");

        for(int i = 0; i < tuple2.length; i++) {
            for(int j = i+1; j < tuple2.length; j++) {
                if(tuple2[i].length > tuple2[j].length) {
                    String[] before = tuple2[i];
                    tuple2[i] = tuple2[j];
                    tuple2[j] = before;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < tuple2.length; i++) {
            for(int j = 0; j < tuple2[i].length; j++) {
                if(!ans.contains(Integer.parseInt(tuple2[i][j])))
                    ans.add(Integer.parseInt(tuple2[i][j]));
            }
        }

        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);

        return answer;
    }
}
