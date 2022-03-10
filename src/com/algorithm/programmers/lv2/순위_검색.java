package com.algorithm.programmers.lv2;

import java.util.Arrays;

public class 순위_검색 {
    public static void main(String[] args) {
        순위_검색 test = new 순위_검색();
        test.solution();
    }

    // 이렇게까지 할 필욘없을듯
//    public int[] solution() {
//        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
//                "python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80",
//                "python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
//                "cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100",
//                "- and - and - and - 150"};
//        int[] answer = new int[query.length];
//
//        Condition[] con = new Condition[query.length];
//        Applicant[] appli = new Applicant[info.length];
//        for(int i = 0; i < info.length; i++) {
//            String[] s = info[i].split(" ");
//            String[] s2 = query[i].split(" and ");
//            con[i] = new Condition(s2[0], s2[1], s2[2], s2[3].substring(0, s2[3].indexOf(" ")), Integer.parseInt(s2[3].substring(s2[3].indexOf(" ") + 1)));
//            appli[i] = new Applicant(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]));
//        }
//
//        for(int i = 0; i < con.length; i++) {
//            int cnt = 0;
//            for(int j = 0; j < appli.length; j++) {
//                if(!(con[i].lang.equals("-") || con[i].lang.equals(appli[j].lang))
//                || !(con[i].job.equals("-") || con[i].job.equals(appli[j].job))
//                || !(con[i].career.equals("-") || con[i].career.equals(appli[j].career))
//                || !(con[i].food.equals("-") || con[i].food.equals(appli[j].food))
//                || appli[j].score < con[i].score)
//                    continue;
//                else
//                    cnt++;
//            }
//            answer[i] = cnt;
//        }
//        return answer;
//    }
//
//    public class Condition {
//        String lang;
//        String job;
//        String career;
//        String food;
//        int score;
//
//        public Condition(String lang, String job, String career, String food, int score) {
//            this.lang = lang;
//            this.job = job;
//            this.career = career;
//            this.food = food;
//            this.score = score;
//        }
//
//        @Override
//        public String toString() {
//            return "Condition{" +
//                    "lang='" + lang + '\'' +
//                    ", job='" + job + '\'' +
//                    ", career='" + career + '\'' +
//                    ", food='" + food + '\'' +
//                    ", score=" + score +
//                    '}';
//        }
//    }
//
//    public class Applicant extends Condition{
//        public Applicant(String lang, String job, String career, String food, int score) {
//            super(lang, job, career, food, score);
//        }
//    }

}
