package com.algorithm.programmers.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class H_Index {
    public static void main(String[] args) {
        H_Index t = new H_Index();
        int[] citations = {3,0,6,1,5};
        t.solution(citations);
    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = citations.length-1; i >= 0; i--) {
            if(!(citations[i] > answer))
                break;
            answer++;
        }

        return answer;
    }
}
