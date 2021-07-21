package com.algorithm.greedy.two;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1946 {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //테스트 케이스
            int T = Integer.parseInt(br.readLine());
            //테스트 케이스 수만큼의 합격자 집단 수
            int[] cnt = new int[T];

            for(int i = 0; i < T; i++) {
                //지원자 수
                int N = Integer.parseInt(br.readLine());

                for(int j = 0; j < N; j++) {
                    //지원자 성적
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                    double score[] = new double[N];
                    score[j] = (Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken())) / 2;
                    if(score[j] >= T / 2.0)
                        cnt[i]++;
                }
            }
            for(int i = 0; i < T; i++)
                System.out.println(cnt[i]);
    }
}
