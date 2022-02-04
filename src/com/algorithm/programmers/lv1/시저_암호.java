package com.algorithm.programmers.lv1;

public class 시저_암호 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String s = "a B z";
        int n = 4;
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                answer += " ";
            else {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    if(s.charAt(i) + n > 'Z')
                        answer +=  (char) ('A' + ((s.charAt(i) + n) - 'Z') -1);
                    else
                        answer += (char) (s.charAt(i) + n);
                }
                else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    if(s.charAt(i) + n > 'z')
                        answer += (char) ('a' + ((s.charAt(i) + n) - 'z') - 1);
                    else
                        answer += (char) (s.charAt(i) + n);
                }
                else
                    answer += (char) (s.charAt(i) + n);
            }
        }
        System.out.println(answer);

        return answer;
    }
}
