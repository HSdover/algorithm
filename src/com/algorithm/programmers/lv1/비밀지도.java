package com.algorithm.programmers.lv1;

import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) {
        solution();
    }

    public static String[] solution() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            while(true) {
                if(arr1[i] / 2 == 0 && arr1[i] % 2 == 0 && arr2[i] / 2 == 0 && arr2[i] % 2 == 0) {
                    if(sb.length() < n) {
                        while(sb.length() < n) {
                            sb.insert(0, " ");
                        }
                    }
                    break;
                }

                if(arr1[i] % 2 == 1 || arr2[i] % 2 == 1) {
                    arr1[i] /= 2;
                    arr2[i] /= 2;
                    sb.insert(0, "#");
                }
                else {
                    arr1[i] /= 2;
                    arr2[i] /= 2;
                    if(sb == null && sb.charAt(0) != ' ')
                        sb.insert(0, " ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
