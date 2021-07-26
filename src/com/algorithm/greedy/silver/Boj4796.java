package com.algorithm.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//문제
//등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.
//
//캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
//
//강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?
//
//강산이는 조금 더 일반화해서 문제를 풀려고 한다.
//
//캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
//
//입력
//입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다. 모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.
//
//출력
//각 테스트 케이스에 대해서, 강산이가 캠핑장을 최대 며칠동안 사용할 수 있는지 예제 출력처럼 출력한다.
public class Boj4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L;
        int P;
        int V;
        ArrayList<Integer> day = new ArrayList<>();
        int sum = 10;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            sum = L + P + V;

            //마지막 줄
            if(sum == 0)
                break;

            //휴가일수를 구하기 위해선 휴가일수 / 캠핑연속일 * 캠핑가능일에 휴가일수 / 캠핑연속일의 나머지를 더해줘야함
            //하지만 휴가일수 / 캠핑연속일의 나머지가 캠핑연속일보단 작지만 캠핑가능일보다 클 수 있기 때문에 if문으로 분기처리해준다.
            int v = (V / P) * L;

            if(V % P > L)
                v += L;
            else
                v += V % P;

            day.add(v);
        }
        for(int i = 0; i < day.size(); i++)
            System.out.println("Case " + (i + 1) + ": " + day.get(i));
    }
}
