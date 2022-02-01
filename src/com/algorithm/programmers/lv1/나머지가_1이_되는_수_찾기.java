package com.algorithm.programmers.lv1;

public class 나머지가_1이_되는_수_찾기 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int n = 12;
        int answer = 0;

        int idx = 2;
        while(true) {
            if(n % idx == 1)
                break;
            idx++;
        }
        answer = idx;
        System.out.println(answer);
        return answer;
    }
}
