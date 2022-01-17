package com.algorithm.programmers.lv1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        String[] deleteDupl = new String[id_list.length];
        for(int i = 0; i < id_list.length; i++ )
            deleteDupl[i] = id_list[i].concat("/" + report[i]);

        Set<String> set = new HashSet<String>(Arrays.asList(deleteDupl));

        List<String> result = new ArrayList<String>(set);



        return answer;
    }
}
