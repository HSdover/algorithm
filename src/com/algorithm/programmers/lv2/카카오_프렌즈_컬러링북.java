package com.algorithm.programmers.lv2;

import java.util.Arrays;

public class 카카오_프렌즈_컬러링북 {
    public static void main(String[] args) {
        solution();
    }

    // 재귀함수를 이용한 DFS 더 공부가 필요할듯싶다.
    static int areaSize = 0;
    static int[] posX = {0, 0, 1, -1};
    static int[] posY = {1, -1, 0, 0};
    public static void dfs(int x, int y, int[][] picture, boolean[][] check) {
        if(check[x][y])
            return;
        else
            check[x][y] = true;

        areaSize++;
        for(int i = 0; i < 4; i++) {
            int mx = x + posX[i];
            int my = y + posY[i];
            if(i == 2)
                System.out.println("i는 2야 x=" + mx + "y=" + my);
            if(!(mx >= 0 && my >= 0 && mx < picture.length && my < picture[0].length))
                continue;

            System.out.println("x=" + x + "y=" + y);
            if(picture[x][y] == picture[mx][my] && !check[mx][my])
                dfs(mx, my, picture,check);

        }
    }

    public static int[] solution() {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        boolean[][] check = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !check[i][j]) {
                    numberOfArea++;
                    dfs(i, j, picture, check);
                    if(areaSize > maxSizeOfOneArea)
                        maxSizeOfOneArea = areaSize;
                    areaSize = 0;
                }

            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
