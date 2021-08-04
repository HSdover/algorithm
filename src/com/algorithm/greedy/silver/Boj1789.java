package com.algorithm.greedy.silver;

//문제
//서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
//
//입력
//첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
//
//출력
//첫째 줄에 자연수 N의 최댓값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 아이디어
 * 많은 양의 수로 빼려면 작은수부터 빼준다.
 *
 */
public class Boj1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        int max = 1;

        while(true) {
            S -= max;
            if(S == 0)
                break;

            max++;
            if(S < max) {
                max--;
                break;
            }
        }
        System.out.println(max);
    }
}
