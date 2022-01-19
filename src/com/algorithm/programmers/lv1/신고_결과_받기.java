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

        // 아이디별 신고당한 횟수
        int[] cnt = new int[id_list.length];

        int[][] cId = new int[id_list.length][id_list.length];

        for(int i = 0; i < result.size(); i++ ) {
            //피신고자 아이디만 구하기
            String id = result.get(i).substring(result.get(i).lastIndexOf(" ") + 1);

            //신고 횟수가 들어갈 배열 위치 지정
            int idx = Arrays.asList(id_list).indexOf(id);
            cnt[idx]++;
            //신고한 사람 확인하는 배열
            cId[idx][Arrays.asList(id_list).indexOf(result.get(i).substring(0, result.get(i).indexOf(" ")))]++;
        }

        for(int i = 0; i < id_list.length; i++) {
            if(cnt[i] >= k) {
                for(int j = 0; j < id_list.length; j++) {
                    if(cId[i][j] > 0)
                        answer[j]++;
                }
            }
        }

//        for(int i = 0; i < id_list.length; i++) {
//            //신고당한 횟수가 k회 이상일 경우
//            if(cnt[i] >= k) {
//                for(int j = 0; j < result.size(); j++) {
//                    if(id_list[i].equals(result.get(j).substring(result.get(j).lastIndexOf(" ") + 1))) {
//                        String idxId = result.get(j).substring(0, result.get(j).indexOf(" "));
//                        answer[Arrays.asList(id_list).indexOf(idxId)]++;
//                    }
//                }
//            }
//        }

        return answer;
    }
}
