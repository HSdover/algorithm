package com.algorithm.programmers.lv1;

public class 콜라츠_추측 {
    public static void main(String[] args) {
        solution(6);
    }

    public static int solution(int num) {
        int answer = 0;

        int cnt = 0;
        while(!(num == 1)) {
            System.out.println(num);
            if(cnt == 500) {
                cnt = -1;
                break;
            }

            if(num % 2 == 0)
                num /= 2;
            else if(num % 2 == 1)
                num = (num * 3) + 1;
            cnt++;
        }
        answer = cnt;
        System.out.println(answer);
        return answer;
    }
}
