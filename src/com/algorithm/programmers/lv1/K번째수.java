package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class K번째수 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];

        List<Integer> cutArray = new ArrayList<Integer>();
        for(int i = 0; i < commands.length; i++) {
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++)
                cutArray.add(array[j]);
            cutArray.sort(Comparator.comparingInt(o -> o));
            answer[i] = cutArray.get(commands[i][2] - 1);
            cutArray.removeAll(cutArray);
        }
        return answer;
    }
}
