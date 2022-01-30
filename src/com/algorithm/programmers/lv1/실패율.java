package com.algorithm.programmers.lv1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = new int[N];

        int cnt = 0;
        double people = stages.length;
        List<Double> stage = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < stages.length; j++) {
                if(i == stages[j]-1)
                    cnt++;
            }
            stage.add(cnt / people);
            people -= cnt;
            cnt = 0;
        }

        List<Double> copyS = new ArrayList<>(stage);

        stage.sort(Comparator.reverseOrder());
        System.out.println(stage);
        System.out.println(copyS);

        System.out.println(stage.get(0) == copyS.get(2));
        System.out.println(stage.get(0) == copyS.get(3));
        System.out.println(stage.get(0).floatValue());
        System.out.println(copyS.get(2).floatValue());
        System.out.println(stage.get(0).floatValue());
        System.out.println(copyS.get(3).floatValue());
        System.out.println(stage.get(1) == copyS.get(2));
        System.out.println(stage.get(1) == copyS.get(3));
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.println(i);
                System.out.println(copyS.get(j));
                System.out.println(stage.get(i));
                if(copyS.get(j) == stage.get(i)) {
                    answer[i] = j + 1;
                    System.out.println("break point");
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
