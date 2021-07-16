package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
//
//동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
//
//둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
//
//출력
//첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //동전 종류 개수
        int N = Integer.parseInt(st.nextToken());
        //타겟 값
        int K = Integer.parseInt(st.nextToken());
        //동전 개수
        int cnt = 0;

        int[] val = new int[N];

        //동전 하나의 값
        for(int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; i--) {
            //K가 0이 되면 작업이 끝난다.
            if(K == 0)
                break;
            //동전의 값이 현재 값보다 크면 안됨
            if(val[i] <= K) {
                cnt += (K / val[i]);
                K %= val[i];
            }
        }
        System.out.println(cnt);
    }
}
