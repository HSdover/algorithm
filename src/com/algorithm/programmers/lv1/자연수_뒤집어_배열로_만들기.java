package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        long n = 12340;
        int[] answer = {};
        // 나누는 방식은 왜 안되지?.. 아 n이 int값을 넘어서면 .. 오류가 난다
//        List<Integer> num = new ArrayList<>();
//        while(n != 0) {
                        // 여기서 괄호를 n % 10에 걸어줘야 캐스팅이 되서 성공
//            num.add((int) n % 10);
//            n /= 10;
//        }

        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();

        int[] num = new int[sb.length()];
        for(int i = 0; i < sb.length(); i++)
            num[i] = sb.charAt(i) - '0';

        answer = num;
//        int[] answer = new int[num.size()];
//        for(int i = 0; i < num.size(); i++)
//            answer[i] = num.get(i);

        return answer;
    }
}
