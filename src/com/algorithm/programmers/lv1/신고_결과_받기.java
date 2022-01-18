package com.algorithm.programmers.lv1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {

        신고_결과_받기.solution();
    }

    public static int[] solution() {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = new int[id_list.length];

        // 같은 신고자가 신고한 중복 신고 지우기
        Set<String> set = new HashSet<String>(Arrays.asList(report));

        List<String> result = new ArrayList<String>(set);

        int[] cnt = new int[id_list.length];
        for(int i = 0; i < result.size(); i++ ) {
            //피신고자 아이디만 구하기
            String id = result.get(i).substring(result.get(i).lastIndexOf(" ") + 1);

            //신고 회수가 들어갈 배열 위치 지정
            int idx = Arrays.asList(id_list).indexOf(id);
            cnt[idx]++;
        }


        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] >= k)
                answer[i] = cnt[i] / 2;
            else
                answer[i] = 0;
        }

        return answer;
        //신고자 구분 필요
    }
}
