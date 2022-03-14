package com.algorithm.programmers.lv2;

public class 배달_Floyd {
    public static void main(String[] args) {
        배달_Floyd t = new 배달_Floyd();
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};   // 0, 1은 마을 / 2는 마을 이동 간 걸리는 시간
        t.solution(5, road,3);
    }

    // 플로이드 와샬 알고리즘
    // https://blog.naver.com/ndb796/221234427842
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] dt = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) {
                    dt[i][j] = 0;
                    continue;
                }
                // K의 최대 값이 500000이기 때문
                dt[i][j] = 500001;
            }
        }

        for(int i = 0; i < road.length; i++) {
            if(dt[road[i][0]-1][road[i][1]-1] < road[i][2]) continue;

            dt[road[i][0]-1][road[i][1]-1] = road[i][2];
            dt[road[i][1]-1][road[i][0]-1] = road[i][2];
        }


        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;

                    if(dt[i][j] > dt[i][k] + dt[k][j]) {
                        dt[i][j] = dt[i][k] + dt[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < dt[0].length; i++) {
            if(dt[0][i] <= K)
                answer++;
        }

        return answer;
    }
}
