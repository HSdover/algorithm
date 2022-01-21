package com.algorithm.programmers.lv1;

public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        String s = "one4seveneight";
        int answer = 0;

//        s = s.replaceAll("zero", "0").replaceAll("one", "1");
//        s = s.replaceAll("two", "2");
//        s = s.replaceAll("three", "3");
//        s = s.replaceAll("four", "4");
//        s = s.replaceAll("five", "5");
//        s = s.replaceAll("six", "6");
//        s = s.replaceAll("seven", "7");
//        s = s.replaceAll("eight", "8");
//        s = s.replaceAll("nine", "9");

        //반복문으로 바꿔서 표현할 수 있다.
        String[] cha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for(int i = 0; i < cha.length; i++)
            s = s.replaceAll(cha[i], num[i]);

        System.out.println(s);
        answer = Integer.parseInt(s);
        return answer;
    }
}
