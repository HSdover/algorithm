package com.algorithm.programmers.lv2;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,4,5},{3,3,6,6},{5,1,6,3}, {2,2,4,5},{3,3,6,6},{5,1,6,3}};
        int[] answer = new int[queries.length];

        int val = 1;
        int[][] sq = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++)
                sq[i][j] = val++;
        }

        for(int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(sq[i]));
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            // 테두리 값 구하기
            int back = sq[x1][y1];
            int temp = 0;
            // min값을 sq[rows-1][colunms-1]로 했는데 이렇게할 경우
            // sq의 맨 끝값이 돌아서 바뀔경우 min값에 영향을 미치게된다.
            int min = 10001;
            System.out.println(min);
            for(int j = y1; j < y2; j++) {
                temp = sq[x1][j];
                if(temp < min)
                    min = temp;
                sq[x1][j] = back;
                back = temp;
            }
            for(int j = x1 + 1; j < x2; j++) {
                temp = sq[j][y2 - 1];
                if(temp < min)
                    min = temp;
                sq[j][y2 - 1] = back;
                back = temp;
            }
            for(int j = y2 - 2; j >= y1; j--) {
                temp = sq[x2 - 1][j];
                if(temp < min)
                    min = temp;
                sq[x2 - 1][j] = back;
                back = temp;
            }
            for(int j = x2 - 2; j >= x1; j--) {
                temp = sq[j][y1];
                if(temp < min)
                    min = temp;
                sq[j][y1] = back;
                back = temp;
            }
            System.out.println(min);
            answer[i] = min;
//            for(int t = 0; t < rows; t++)
//                System.out.println(Arrays.toString(sq[t]));
        }


        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
