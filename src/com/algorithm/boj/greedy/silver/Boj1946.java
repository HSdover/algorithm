package com.algorithm.boj.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//문제
//언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
//
//그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
//
//이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
//
//출력
//각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
public class Boj1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());
        //테스트 케이스 수만큼의 합격자 집단 수
        int[] cnt = new int[T];
        int N;
        int[] score;

        for(int i = 0; i < T; i++) {
            //지원자 수
            N = Integer.parseInt(br.readLine());
            score = new int[N];

            for(int j = 0; j < N; j++) {
                //지원자 성적
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                score[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
            }
            cnt[i] = 1;
            //합격자 기준
            int pass = score[0];

            for(int j = 1; j < N; j++) {
                //합격자 기준으로 합격자 판단하여 합격자 증가
                if(score[j] < pass) {
                    cnt[i]++;
                    //합격자 기준 교체
                    pass = score[j];
                }
            }
        }
        for(int i = 0; i < T; i++)
            System.out.println(cnt[i]);
    }
}
