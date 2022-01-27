package com.algorithm.programmers.lv1;

import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2};

        //수포자1
        int num = 1;
        int[] sub1 = new int[answers.length];
        for(int i = 0; i < answers.length; i++) {
            sub1[i] = num++;
            if(num == 6)
                num = 1;
        }
        System.out.println(Arrays.toString(sub1));
        //수포자2
        num = 1;
        int[] sub2 = new int[answers.length];
        for(int i = 0; i < answers.length; i++) {
            if(num == 6)
                num = 1;

            if(i % 2 == 0)
                sub2[i] = 2;
            else {
                if (num == 2)
                    num = 3;
                sub2[i] = num++;
            }
        }
        System.out.println(Arrays.toString(sub2));
        //수포자3
        num = 0;
        int[] ex = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] sub3 = new int[answers.length];
        for(int i = 0; i < answers.length; i++) {
            sub3[i] = ex[num++];
            if(num == 10)
                num = 0;
        }
        System.out.println(Arrays.toString(sub3));
        //채점
        int[] o = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(sub1[i] == answers[i])
                o[0]++;
            if(sub2[i] == answers[i])
                o[1]++;
            if(sub3[i] == answers[i])
                o[2]++;
        }

        int temp = o[0];
        for(int i = 1; i < 3; i++) {
            if(o[i] > temp)
                temp = o[i];
        }

        int idx = 0, cnt = 0;

        for(int i = 0; i < 3; i++) {
            if (o[i] == temp)
                cnt++;
        }

        int[] answer = new int[cnt];
        for(int i = 0; i < 3; i++) {
            if(o[i] == temp)
                answer[idx++] = i + 1;
        }
        Arrays.sort(answer);
        //모든 경우의 수는 그닥..?
//        if(o[0] == o[1] && o[1] == o[2])
//            answer = new int[]{1, 2, 3};
//        else if(o[0] > o[1] && o[0] > o[2])
//            answer[0] = 1;
//        else if(o[1] > o[0] && o[1] > o[2])
//            answer[0] = 2;
//        else if(o[2] > o[0] && o[2] > o[1])
//            answer[0] = 3;
//        else if(o[0] == o[1] && o[0] > o[2])
//            answer = new int[]{1, 2};
//        else if(o[0] > o[1] && o[0] == o[2])
//            answer = new int[]{1, 3};
//        else if(o[1] == o[0] && o[1] > o[2])
//            answer = new int[]{1, 2};
//        else if(o[1] > o[0] && o[1] == o[2])
//            answer = new int[]{2, 3};
//        else if(o[2] == o[1] && o[2] > o[0])
//            answer = new int[]{2, 3};
//        else if(o[2] > o[1] && o[2] == o[0])
//            answer = new int[]{1, 3};

        System.out.println(Arrays.toString(answer));



        return answer;
    }
}
