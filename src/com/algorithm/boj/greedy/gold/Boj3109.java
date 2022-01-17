package com.algorithm.boj.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
    //문제
    //유명한 제빵사 김원웅은 빵집을 운영하고 있다. 원웅이의 빵집은 글로벌 재정 위기를 피해가지 못했고, 결국 심각한 재정 위기에 빠졌다.
    //
    //원웅이는 지출을 줄이고자 여기저기 지출을 살펴보던 중에, 가스비가 제일 크다는 것을 알게되었다. 따라서 원웅이는 근처 빵집의 가스관에 몰래 파이프를 설치해 훔쳐서 사용하기로 했다.
    //
    //빵집이 있는 곳은 R*C 격자로 표현할 수 있다. 첫째 열은 근처 빵집의 가스관이고, 마지막 열은 원웅이의 빵집이다.
    //
    //원웅이는 가스관과 빵집을 연결하는 파이프를 설치하려고 한다. 빵집과 가스관 사이에는 건물이 있을 수도 있다. 건물이 있는 경우에는 파이프를 놓을 수 없다.
    //
    //가스관과 빵집을 연결하는 모든 파이프라인은 첫째 열에서 시작해야 하고, 마지막 열에서 끝나야 한다. 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있고, 각 칸의 중심끼리 연결하는 것이다.
    //
    //원웅이는 가스를 되도록 많이 훔치려고 한다. 따라서, 가스관과 빵집을 연결하는 파이프라인을 여러 개 설치할 것이다. 이 경로는 겹칠 수 없고, 서로 접할 수도 없다. 즉, 각 칸을 지나는 파이프는 하나이어야 한다.
    //
    //원웅이 빵집의 모습이 주어졌을 때, 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 R과 C가 주어진다. (1 ≤ R ≤ 10,000, 5 ≤ C ≤ 500)
    //
    //다음 R개 줄에는 빵집 근처의 모습이 주어진다. '.'는 빈 칸이고, 'x'는 건물이다. 처음과 마지막 열은 항상 비어있다.
    //
    //출력
    //첫째 줄에 원웅이가 놓을 수 있는 파이프라인의 최대 개수를 출력한다.

    /**
     * 아이디어
     * 백트래킹을 이용해서 푼다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] p = new char[R][C];
        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++)
                p[i][j] = s.charAt(j);
        }

        int ans = 0;
        for(int i = 0; i < R; i++) {
            int j = 0;
            while(i < R && j < C) {
                p[i][j] = 'c';
                if(j == C - 1) {
                    ans++;
                    break;
                }

                if(i != 0 && p[i - 1][j + 1] == '.') {
                    i--;
                    j++;
                }
                else if(i != R - 1 && p[i + 1][j + 1] == '.') {
                    i++;
                    j++;
                }
                else if(p[i][j + 1] == '.')
                    j++;
                else
                    break;
            }

            for(int o = 0; o < R; o++) {
                for(int k = 0; k < C; k++)
                    System.out.print(p[o][k]);
                System.out.println();
            }
        }
//        for(int i = 0; i < R; i++) {
//            for(int j = 0; j < C; j++)
//                System.out.print(p[i][j]);
//            System.out.println();
//        }
        System.out.println(ans);
    }
}
