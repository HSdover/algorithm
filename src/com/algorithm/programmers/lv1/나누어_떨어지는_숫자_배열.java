package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        List<Integer> listToArr = new ArrayList<>();

        for(int val : arr) {
            if(val % divisor == 0)
                listToArr.add(val);
        }
        listToArr.sort(Comparator.naturalOrder());

        int[] answer = new int[listToArr.size()];
        if(listToArr.size() != 0) {
            for(int i = 0; i < listToArr.size(); i++)
                answer[i] = listToArr.get(i);
        }
        else {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }
}
