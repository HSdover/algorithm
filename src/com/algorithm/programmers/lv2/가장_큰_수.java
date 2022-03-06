package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 가장_큰_수 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = "";

        String[] sNum = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            sNum[i] = String.valueOf(numbers[i]);

        Arrays.sort(sNum, new Comparator<String>() {
            // 어떻게 비교해서 들어가는건지 이해해보자..
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o1 + ", " + o2);
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for(int i = 0; i < sNum.length; i++)
            answer += sNum[i];

        if(answer.charAt(0) == '0')
            answer = "0";

        return answer;
    }


    // 예상대로 dfs는 메모리 초과로 실패..
//    static List<String> ans = new ArrayList<>();
//    static String s = new String();
//    private static void dfs(String[] sNum, boolean[] check, String s) {
//        int cnt = 0;
//        for(int i = 0; i < check.length; i++) {
//            if(!check[i])
//                break;
//            else {
//                if(cnt == check.length-1) {
//                    ans.add(s);
//                    return;
//                }
//                cnt++;
//            }
//        }
//
//        for(int i = 0; i < sNum.length; i++) {
//            String ss = s;
//            if(!check[i]) {
//                ss += sNum[i];
//                check[i] = true;
//                dfs(sNum, check, ss);
//                check[i] = false;
//            }
//        }
//    }
//
//    public static String solution() {
//        int[] numbers = {3, 30, 34, 5, 9};
//        String answer = "";
//
//        String[] sNum = new String[numbers.length];
//        for(int i = 0; i < numbers.length; i++)
//            sNum[i] = String.valueOf(numbers[i]);
//
//        Arrays.sort(sNum, Comparator.reverseOrder());
//        boolean[] check = new boolean[numbers.length];
//        String s = new String();
//        dfs(sNum, check, s);
//
//        ans.sort(Comparator.reverseOrder());
//        answer = ans.get(0);
//        return answer;
//    }
}
