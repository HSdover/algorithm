package com.algorithm.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 폰켓몬 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] nums = {3,3,3,2,2,4};
        int answer = 0;

        Integer[] inteNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<Integer> distincNums = new HashSet<Integer>(Arrays.asList(inteNums));

        if(distincNums.size() >= nums.length/2)
            answer = nums.length/2;
        else
            answer = distincNums.size();

        return answer;
    }
}
