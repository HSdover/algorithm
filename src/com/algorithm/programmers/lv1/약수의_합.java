package com.algorithm.programmers.lv1;

public class 약수의_합 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int n = 5;
        int answer = 0;

        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i == Math.sqrt(n))
                answer += i;
            else if(n % i == 0)
                answer += i + (n / i);
        }
        System.out.println(answer);

        return answer;
    }
}
