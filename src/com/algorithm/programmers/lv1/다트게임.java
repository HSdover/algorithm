package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 다트게임 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        String dartResult = "1S2D*3T";
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        List<String> score = new ArrayList<>();
        while(!dartResult.isEmpty()) {
            if(dartResult.length() > 0 && !dartResult.substring(0,1).matches("[SDT]")) {
                sb.append(dartResult.substring(0, 1));
                dartResult = dartResult.substring(1);
            }
            else {
                sb.append(dartResult.substring(0, 1));
                dartResult = dartResult.substring(1);
                if(dartResult.length() > 0 && dartResult.substring(0,1).matches("[#*]")) {
                    sb.append(dartResult.substring(0, 1));
                    dartResult = dartResult.substring(1);
                }
                score.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        System.out.println(score);

        int[] one = new int[3];
        for(int i = 0; i < score.size(); i++) {
            StringBuilder num = new StringBuilder();
            while(!score.get(i).isEmpty()) {
                if(!score.get(i).substring(0,1).matches("[SDT]")) {
                    num.append(score.get(i).substring(0, 1));
                    score.set(i, score.get(i).substring(1));
                }
                else {
                    one[i] = Integer.parseInt(num.toString());
                    if(score.get(i).charAt(0) == 'D')
                        one[i] = (int) Math.pow(one[i], 2);
                    else if(score.get(i).charAt(0) == 'T')
                        one[i] = (int)Math.pow(one[i], 3);

                    if(score.get(i).length() == 2) {
                        if(score.get(i).charAt(1) == '#')
                            one[i] *= -1;
                        else if(i != 0 && score.get(i).charAt(1) == '*') {
                            one[i] *= 2;
                            one[i-1] *= 2;
                        }
                        else
                            one[i] *= 2;
                    }
                    num = new StringBuilder();
                    score.set(i, "");
                }
            }
        }
        System.out.println(Arrays.toString(one));

        for(int val : one)
            answer += val;

        System.out.println(answer);
        // 고쳤는데 비슷하네ㅋㅋ;



        // 더 간단하게 할 수 있을거같은데 이렇게 시작하다보니 오기로 이렇게 품..
        // 샷 하나 별로 나누기
//        List<String> oneScore = new ArrayList<>();
//        int drIdx = 0;
//        StringBuilder sb = new StringBuilder();
//        while(!dartResult.isEmpty()) {
//            sb.append(dartResult.substring(drIdx, drIdx+1));
//            System.out.println(sb);
//            if(dartResult.substring(drIdx, drIdx+1).matches("[SDT]")) {
//                System.out.println(drIdx);
//                dartResult = dartResult.substring(drIdx+1);
//                if(dartResult.length() != 0 && (dartResult.substring(0, 1).matches("[#*]"))) {
//                    sb.append(dartResult.substring(0, 1));
//                    dartResult = dartResult.substring(1);
//                }
//                else if(dartResult.length() == 1 && (dartResult.substring(0, 1).matches("[#*]"))){
//                    sb.append(dartResult.substring(0, 1));
//                    dartResult = "";
//                }
//                oneScore.add(sb.toString());
//                sb = new StringBuilder();
//                drIdx = -1;
//            }
//            drIdx++;
//        }
//        System.out.println(oneScore);
        // 점수가 10점일경우 이 코드를 못써
//        while(!dartResult.isEmpty()) {
//            if(dartResult.length() > 2 && (dartResult.charAt(2) == '*' || dartResult.charAt(2) == '#')) {
//                oneScore.add(dartResult.substring(0, 3));
//                dartResult = dartResult.substring(3);
//            }
//            else {
//                oneScore.add(dartResult.substring(0, 2));
//                dartResult = dartResult.substring(2);
//            }
//        }

//        int sc[] = new int[oneScore.size()];
//        for(int i = 0; i < oneScore.size(); i++) {
//            int idx = 0;
//            while(true) {
//                idx++;
//                if (oneScore.get(i).substring(idx-1, idx).matches("[SDT]")) {
//                    sc[i] = Integer.parseInt(oneScore.get(i).substring(0, idx-1));
//                    oneScore.set(i, oneScore.get(i).substring(idx-1));
//                    System.out.println(sc[i]);
//                    System.out.println(oneScore.get(i));
//                    break;
//                }
//            }
//            if(oneScore.get(i).charAt(0) == 'D')
//                sc[i] = (int) Math.pow(sc[i], 2);
//            else if(oneScore.get(i).charAt(0) == 'T')
//                sc[i] = (int) Math.pow(sc[i], 3);
//
//            if(oneScore.get(i).length() == 2) {
//                if(oneScore.get(i).charAt(1) == '#')
//                    sc[i] *= -1;
//                else if(i != 0 && oneScore.get(i).charAt(1) == '*') {
//                    sc[i] *= 2;
//                    sc[i-1] *= 2;
//                }
//                else
//                    sc[i] *= 2;
//            }
//        }
        // 숫자가 10일 경우때문에 다시 짜야함
//        or(int i = 0; i < oneScore.size(); i++) {
//            if(oneScore.get(i).length() > 2 && (oneScore.get(i).charAt(oneScore.get(i).length()-1) != '*' || oneScore.get(i).charAt(oneScore.get(i).length()-1) != '#'))
//                sc[i] = Integer.parseInt(oneScore.get(i).substring(0,2));
//            else
//                sc[i] = Integer.parseInt(oneScore.get(i).substring(0,1));
//
//            if(oneScore.get(i).charAt(1) == 'D')
//                sc[i] = (int) Math.pow(sc[i], 2);
//            else if(oneScore.get(i).charAt(1) == 'T')
//                sc[i] = (int) Math.pow(sc[i], 3);
//            // *, #이 존재할 경우
//            if(oneScore.get(i).charAt(oneScore.get(i).length()-1) == '#')
//                sc[i] *= -1;
//            else if(i == 0 && oneScore.get(i).charAt(oneScore.get(i).length()-1) == '*')
//                sc[i] *= 2;
//            else if(oneScore.get(i).charAt(oneScore.get(i).length()-1) == '*'){
//                sc[i-1] *= 2;
//                sc[i] *= 2;
//            }
//        }

//        System.out.println(Arrays.toString(sc));
//        for(int num : sc)
//            answer += num;
//
//        System.out.println(answer);
        return answer;
    }
}
