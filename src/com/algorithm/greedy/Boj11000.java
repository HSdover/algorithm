package com.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//문제
//수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
//
//김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
//
//참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
//
//수강신청 대충한 게 찔리면, 선생님을 도와드리자!
//
//입력
//첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
//
//이후 N개의 줄에 Si, Ti가 주어진다. (1 ≤ Si < Ti ≤ 10^9)
//
//출력
//강의실의 개수를 출력하라.
public class Boj11000 {
    //2차원 배열, 클래스를 이용
    //클래스 이용을 위해선 클래스 정렬을 위해 compareTo 인터페이스를 구현해야함.
    static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture lec) {
            if(this.start == lec.start)
                return this.end - lec.end;

            return this.start - lec.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Lecture[] lec = new Lecture[N];
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lec[i] = new Lecture(s, e);
        }

        //우선순위 큐를 사용한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(lec);

        pq.add(lec[0].end);

        //끝나는 시간을 넣고 다음 lec의 시작 시간과 비교하여 교체,
        for(int i = 1; i < N; i++) {
            if(pq.peek() <= lec[i].start)
                pq.poll();
            pq.add(lec[i].end);
        }

        System.out.println(pq.size());
    }
}
