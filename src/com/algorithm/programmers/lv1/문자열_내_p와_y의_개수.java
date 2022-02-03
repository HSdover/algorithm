package com.algorithm.programmers.lv1;

public class 문자열_내_p와_y의_개수 {
    public static void main(String[] args) {
        solution();
    }

    static boolean solution() {
        String s = "pPoooyY";
        boolean answer = true;

        int cntP = 0, cntY = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                cntP++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                cntY++;
        }
        answer = cntP == cntY;

        return answer;
    }
}
