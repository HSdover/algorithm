package com.algorithm.programmers.lv1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int N = 5;
        int[] stages = {1, 1, 1, 1, 1};
        int[] answer = new int[N];

        int cnt = 0;
        double people = stages.length;
        List<Double> stage = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < stages.length; j++) {
                if(i == stages[j]-1)
                    cnt++;
            }
            // 남아있는 사람 수가 0명일경우를 처리해주지않으면 NaN이 나와 멀쩡한 연산을 할 수 없다.
//            [1.0, NaN, NaN, NaN, NaN]
//            [2, 3, 4, 5, 1]
            if(people == 0) {
                stage.add(0.0);
            }
            else {
                stage.add(cnt / people);
                people -= cnt;
                cnt = 0;
            }
        }

        System.out.println(stage);
        List<Double> copyS = new ArrayList<>(stage);

        stage.sort(Comparator.reverseOrder());

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(copyS.get(j) != -1.0 && copyS.get(j) == stage.get(i)) {
                    copyS.set(j, -1.0);
                    answer[i] = j + 1;
                    break;
                }
            }
//            if(i == 1)
//                break;
        }
        System.out.println(Arrays.toString(answer));
        //모든 테스트 케이스 통과 불가..
//        int cnt = 0;
//        double people = stages.length;
//        List<Double> stage = new ArrayList<>();
//        stage.add(0.0);
//        for(int i = 1; i < N+1; i++) {
//            for(int j = 0; j < stages.length; j++) {
//                if(stages[j] == i)
//                    cnt++;
//            }
//            stage.add(i,cnt / people);
//            people -= cnt;
//            cnt = 0;
//        }
//
//        double lagest = stage.get(1);
//        int idx = 1, aIdx = 0;
//        for(int i = 0; i < N; i++) {
//            for(int j = 2; j < N+1; j++) {
//                if(stage.get(j) != -1.0 && stage.get(j) > lagest ) {
//                    lagest = stage.get(j);
//                    idx = j;
//                }
//            }
//            stage.set(idx, -1.0);
//            answer[aIdx++] = idx;
//            lagest = stage.get(1);
//            idx = 1;
//        }

        return answer;
    }

}
