package com.algorithm.programmers.lv1;

public class 삼진법_뒤집기 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int n = 125;

        StringBuilder sb = new StringBuilder();
        while(true) {
            if(n < 3) {
                sb.insert(0,n % 3);
                break;
            }
            else if(n % 3 == 0)
                sb.insert(0, 0);
            else
                sb.insert(0,n % 3);
            n /= 3;
        }

        int answer = 0;
        int proc = 1;
        for(int i = 0; i < sb.length(); i++) {
            answer += ( Integer.parseInt(String.valueOf(sb.charAt(i))) * proc);
            proc *= 3;
        }

        System.out.println(answer);

        return answer;
    }
}
