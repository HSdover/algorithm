package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//백준대학교에서는 대회에 나갈 때 2명의 여학생과 1명의 남학생이 팀을 결성해서 나가는 것이 원칙이다. (왜인지는 총장님께 여쭈어보는 것이 좋겠다.)
//
//백준대학교는 뛰어난 인재들이 많아 올해에도 N명의 여학생과 M명의 남학생이 팀원을 찾고 있다. 대회에 참여하려는 학생들 중 K명은 반드시 인턴쉽 프로그램에 참여해야 한다. 인턴쉽에 참여하는 학생은 대회에 참여하지 못한다.
//
//백준대학교에서는 뛰어난 인재들이 많기 때문에, 많은 팀을 만드는 것이 최선이다.
//
//여러분은 여학생의 수 N, 남학생의 수 M, 인턴쉽에 참여해야하는 인원 K가 주어질 때 만들 수 있는 최대의 팀 수를 구하면 된다.
//
//입력
//첫째 줄에 N, M, K가 순서대로 주어진다. (0 ≤ M ≤ 100, 0 ≤ N ≤ 100, 0 ≤ K ≤ M+N),
//
//출력
//만들 수 있는 팀의 최대 개수을 출력하면 된다.
public class Boj2875 {

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //여학생
        int N = Integer.parseInt(st.nextToken());
        //남학생
        int M = Integer.parseInt(st.nextToken());
        //인턴십 참여 인원
        int K = Integer.parseInt(st.nextToken());
        //팀 개수
        int cnt = 0;

        // 여2 남1 팀결성, 인턴십 참여 학생은 대회 참가 불가, 최대한 많은 팀 구성

        // 일단 최대한 많은 팀을 만든다. => X 인턴십 인원부터 고려해야함.
//        cnt = N / 2;
//        N %= 2;
//        M -= cnt;

        // 최대한 많은 팀을 만들고 남은 인원과 인턴십 인원을 비교!
        // 최대 팀 수
        cnt = N / 2;
        N %= 2;

        //남자 인원이 최대 팀 수 보다 많은 경우 남은 남학생 수
        if(M > cnt) {
            M -= cnt;
        }
        //남자 인원이 최대 팀 수 보다 적은 경우 남은 남학생 수는 무조건 0이 된다.
        else {
            M -= cnt;
            cnt += M;

            //남학생의 수가 모자라 팀을 못이룬 여학생 수
            N = 2 * Math.abs(M);
            M = 0;
        }

        // 인턴십 인원 제외
        // 남은 학생 수
        int sum = N + M;

        // 남은 학생 수를 인턴십에 포함 시키고 남은 인턴십 인원 수
        K -= sum;

        //인턴십 인원을 비교하기 위해 3을 곱해줌
        cnt *= 3;

        // 인턴십 인원이 남아 있으면 팀에서 인턴십 인원을 뺀다.
        if(K >= 0){
            cnt -= K;
        }
        //최대 팀 수
       System.out.println(cnt/3);
    }
}
