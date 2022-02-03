package com.algorithm.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] arr = {4,4,4,3,3};

        int temp = arr[0];
        List<Integer> distinct = new ArrayList<>();
        distinct.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != temp) {
                distinct.add(arr[i]);
                temp = arr[i];
            }
        }

        int[] answer = new int[distinct.size()];

        for(int i = 0; i < distinct.size(); i++)
            answer[i] = distinct.get(i);

        return answer;
    }
}
