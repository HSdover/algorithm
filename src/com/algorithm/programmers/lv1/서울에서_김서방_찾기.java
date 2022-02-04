package com.algorithm.programmers.lv1;

public class 서울에서_김서방_찾기 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String[] seoul = {"Jane", "Kim"};
        String answer = "김서방은 ";

        int pos = 0;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim"))
                pos = i;
        }
        answer += pos + "에 있다";
        System.out.println(answer);
        return answer;
    }
}
