package com.algorithm.programmers.lv1;

import java.util.*;

public class 두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] numbers = {2,2, 2, 2,2,2,2,2,2,99,100};


        Set<Integer> sums = new HashSet<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++)
                sums.add(numbers[i] + numbers[j]);
        }

        List<Integer> aToL = new ArrayList<>(sums);
        int[] answer = new int[aToL.size()];
        for(int i = 0; i < aToL.size(); i++)
            answer[i] = aToL.get(i);
        Arrays.sort(answer);
        return answer;
    }
}
