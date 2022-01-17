package com.algorithm.boj.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1202 {
    //문제
    //세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
    //
    //상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
    //
    //상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
    //
    //다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
    //
    //다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
    //
    //모든 숫자는 양의 정수이다.
    //
    //출력
    //첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.

    /**
     * 아이디어
     * 가장 비싼 보석을 최대한 많이 가방에 담는다.
     *
     * 보석 무게를 오름차순으로 정렬한 후 가방의 무게와 비교해 가치값을 내림차순으로 우선순위 큐에 담는다.
     *
     * 보석의 가치가 21억 이상이 가능한데 sum을 int로 해서 틀린걸 못찾고 있었음.. long으로 해야됨 꼼꼼하게 풀자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jws = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            jws[i][0] = Integer.parseInt(st.nextToken());
            jws[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bw = new int[K];
        for(int i = 0; i < K; i++)
            bw[i] = Integer.parseInt(br.readLine());

        Arrays.sort(jws, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bw);

        PriorityQueue<Integer> jw = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int j = 0;
        for(int i = 0; i < K; i++) {
            while(j < N && bw[i] >= jws[j][0]) {
                jw.offer(jws[j][1]);
                j++;
            }
            if(!jw.isEmpty())
                sum += jw.poll();
        }
        System.out.println(sum);
    }
}
