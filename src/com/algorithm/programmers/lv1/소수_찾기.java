package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 소수_찾기 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int n = 1000000;

        int answer = 1;
        for(int i = 3; i <= n; i+=2) {
            int proc = 2;
            answer++;
            while(proc <= Math.sqrt(i)) {
                if(i % proc == 0) {
                    answer--;
                    break;
                }
                proc++;
            }

        }
//        int answer = 0;
//
//        for(int i = 2; i <= n; i++) {
//            answer++;
//            int proc = 2;
//            while(proc <= Math.sqrt(i)) {
//               if(i % proc == 0) {
//                   answer--;
//                   break;
//               }
//               proc++;
//           }
//        }
//        System.out.println(answer);
        return answer;
    }
}
