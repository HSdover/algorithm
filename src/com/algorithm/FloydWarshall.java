package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        FloydWarshall t = new FloydWarshall();
        t.floydWarshall();
    }

    int number = 4;
    int INF = 10000000;

    int[][] a = {
        {0, 5, INF, 8},
        {7, 0, 9, INF},
        {2, INF, 0, 4},
        {INF, INF, 3, 0}
    };

    public void floydWarshall() {
        int[][] d = new int[number][number];

        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                d[i][j] = a[i][j];
            }
        }

        for(int k = 0; k < number; k++) {
            for(int i = 0; i < number; i++) {
                for(int j = 0; j < number; j++) {
                    if(d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < number; i++)
            System.out.println(Arrays.toString(d[i]));
    }
}
