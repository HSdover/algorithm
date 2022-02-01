package com.algorithm.programmers.lv1;

public class 최소직사각형 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int answer = 0;

        int[] max = new int[2];
        // 한 축은 전부 만족시킴
        for(int i = 0; i < sizes.length; i++) {
            if(max[0] < sizes[i][0]) {
                max[0] = sizes[i][0];
                max[1] = sizes[i][1];
            }
            if(max[0] < sizes[i][1]) {
                max[0] = sizes[i][1];
                max[1] = sizes[i][0];
            }
        }

        for(int i = 0; i < sizes.length; i++) {
            if(!(max[0] >= sizes[i][0] && max[1] >= sizes[i][1])) {
                if(!(max[0] >= sizes[i][1] && max[1] >= sizes[i][0]))
                    if(sizes[i][0] > sizes[i][1])
                        max[1] = sizes[i][1];
                    else
                        max[1] = sizes[i][0];
            }
        }
        answer = max[0] * max[1];
        return answer;
    }
}
