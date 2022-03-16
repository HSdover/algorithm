package com.algorithm.programmers.lv2;

import java.util.Arrays;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        큰_수_만들기 t = new 큰_수_만들기();
        t.solution("1231234", 3);
    }

    public String solution(String number, int k) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max;
        for(int i = 0; i < number.length()-k; i++) {
            max = 0;
            for(int j = index; j <= k+i; i++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }

        return answer;

        //시간초과
//        while(answer.length() != out) {
//            char num = '0';
//            int idx = 0;
//            for(int i = 0; i <= k; i++) {
//                if(sb.charAt(i) > num) {
//                    num = sb.charAt(i);
//                    idx = i;
//                }
//            }
//            answer += num;
//            sb = new StringBuilder(sb.substring(idx + 1));
//            k -= idx;
//        }
//
//        System.out.println(answer);
//        return answer;
    }
}
