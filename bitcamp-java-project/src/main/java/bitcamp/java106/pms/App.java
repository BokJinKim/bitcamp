package bitcamp.java106.pms;

import javax.xml.stream.events.StartDocument;

public class App{
    
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);
        String team;
        String explan;
        int people;
        String start;
        String end;

        System.out.print("팀명 : ");
        team = keyScan.nextLine();
        System.out.print("설명 : ");
        explan = keyScan.nextLine();
        System.out.print("최대인원 : ");
        people = keyScan.nextInt();
        keyScan.nextLine();
        System.out.print("시작일 : ");
        start = keyScan.nextLine();
        System.out.print("종료일 : ");
        end = keyScan.nextLine();
        
        System.out.println("---------------------------");
        System.out.printf("팀명 : %s\n", team);
        System.out.printf("설명 : \n%s\n", explan);
        System.out.printf("최대인원 : %d명\n", people);
        System.out.printf("시작일 : %s\n", start);
        System.out.printf("종료일 : %s\n", end);

    }

}
/*
# 자바 프로젝트 

## src02 - 키보드 입력 과 변수
- 학습목표
  - 키보드로부터 데이터를 입력 받는 방법을 익힌다.
  - 사용자가 입력한 값을 메모리에 보관하는 방법을 익힌다.
- 작업내용
  - 사용자로부터 팀 정보를 입력 받아 출력하라.
- 실행 결과
'''
> java -classpath bin bitcamp.java106.pms.App
팀명? 비트비트
설명? 자바 프로젝트 팀
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
------------------------
팀명: 비트비트
설명:
자바 프로젝트 팀
최대인원: 5명
일자: 2018-05-05 ~ 2018-08-20

*/