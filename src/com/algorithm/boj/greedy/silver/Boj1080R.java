package com.algorithm.boj.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Boj1080R {
    //문제
    //0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.
    //
    //행렬을 변환하는 연산은 어떤 3*3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 -> 1, 1 -> 0)
    //
    //입력
    //첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.
    //
    //출력
    //첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다.

    /**
     * 아이디어
     * 구현 자체는 어렵않은데. 문제를 이해못했다.
     * 행렬을 변환하는게 A 행렬안에 있는 랜덤의 3 * 3 부분 행렬을 뒤집는거였다.
     * 그냥 문제가 줬기 때문에 저렇게 뒤집는건지 저런 방식으로 행렬을 치환하는 공식이 있는건지 모르겠다.
     * 실제로 이런문제가 나온다면 문제 이해가 안되서 풀기 어려울거 같다. 사고력을 기르자.
     *
     * 더 찾아보니 이런 공식이 있는거 같진 않고 주어진 방식으로 풀면서 그리디적인 사고가 필요한거 같다.
     * 특정 위치의 원소를 뒤집기 위해선 그 위치의 원소를 부분 행렬의 (0, 0) 위치에 두고 전부 뒤집는다.
     * 특정 원소를 뒤집기 위해 (0, 1)이나 그 외 3 * 3 부분 행렬 에서 겹치는 원소를 기준으로 뒤집을 경우는 서로 영향을 주게 되므로 그리디하지 않게된다.
     * https://unglog.tistory.com/13를 참고하였다.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for(int i = 0; i < N * 2; i++) {
            String S = br.readLine();
            for(int j = 0; j < M; j++) {
                int i1 = parseInt(String.valueOf(S.charAt(j)));
                if(i < N)
                    A[i][j] = i1;
                else if(i >= N)
                    B[i-N][j] = i1;
            }
        }

        int cnt = 0;
        if(N >= 3 && M >= 3) {
            for(int i = 0; i < N - 2; i++) {
                for(int j = 0; j < M - 2; j++) {
                    if(A[i][j] != B[i][j]) {
                        cnt++;
                        for(int r = i; r < i + 3; r++) {
                            for(int c = j; c < j + 3; c++) {
                                A[r][c] = A[r][c] == 0 ? 1 : 0;
                            }
                        }
                    }
                }
            }
        }

        boolean flag = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}