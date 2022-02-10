package com.algorithm.programmers.lv2;

public class 카카오_프렌즈_컬러링북 {
    public static void main(String[] args) {
        solution();
    }


    public static int dfs(int x, int y, int[][] pic, boolean[][] check) {


        return 0;
    }

    public static int[] solution() {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        boolean[][] check = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !check[i][j]) {
                    check[i][j] = true;
                    dfs(i, j, picture, check);
                }
            }
        }
        return answer;
    }
}
