package com.algorithm.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16953 {
    //문제
    //정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
    //
    //2를 곱한다.
    //1을 수의 가장 오른쪽에 추가한다.
    //A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
    //
    //입력
    //첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
    //
    //출력
    //A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

    /**
     * 아이디어
     * B가 짝수인 경우 B를 2로 나누고 제일 오른쪽 수가 1일 경우 10으로 나눠주고 연산할때마다 회수를 카운트하고 A와 비교한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(true) {
            if(A == B)
                break;
            else if(B < A) {
                cnt = -1;
                break;
            }

            if(B % 2 == 0)
                B /= 2;
            else if((B - 1) % 10 == 0)
                B /= 10;
            else {
                cnt = -1;
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
