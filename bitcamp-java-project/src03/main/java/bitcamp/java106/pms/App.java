package bitcamp.java106.pms;

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정 말라!
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;
// 4단계: 조건문 적용
public class App {
    
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        // 팀 정보를 받을 메모리 준비
        Team[] teams = new Team[5]; // 레퍼런스

        int count = 0;
        for (int i = 0; i < teams.length; i++) {  // for문 안에 i 는 index 약자
            count++;
            teams[i] = new Team(); // teams 배열에 객체의 주소가 들어간다 
                                   // => 객체를 저장한다.
                                
            System.out.print("팀명 : ");
            teams[i].name = keyScan.nextLine();

            System.out.print("설명 : ");
            teams[i].description = keyScan.nextLine();

            System.out.print("최대인원 : ");
            teams[i].maxQty = keyScan.nextInt();
            keyScan.nextLine();

            System.out.print("시작일 : ");
            teams[i].startDate  = keyScan.nextLine();

            System.out.print("종료일 : ");
            teams[i].endDate = keyScan.nextLine();

            if (count == teams.length) { // = if (i == teams.length -1) 최대치 도달
                break;
            }
            System.out.print("계속하시겠습니까?(Y/n) : ");
            String str = keyScan.nextLine();
            if (str.toLowerCase().equals("n")) { 
                // 입력받은 문자열을 대문자든 소문자든 소문자로 바꿔서 비교 
                // equals은 안에 적힌 문자열과 비교
                break;
            }
        }

        System.out.println("---------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n", 
                teams[i].name, teams[i].maxQty,
                teams[i].startDate, teams[i].endDate); 

        }
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

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("팀명? ");
        String name = keyScan.nextLine();

        System.out.print("설명? ");
        String description = keyScan.nextLine();

        System.out.print("최대인원? ");
        int maxQty = keyScan.nextInt();
        keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드를 읽는다.
                            // 읽고 난 뒤에 아무것도 안하기 때문에 
                            // 일종의 줄바꿈 코드를 제거하는 효과가 있다.

        System.out.print("시작일? ");
        String startDate = keyScan.nextLine();

        System.out.print("종료일? ");
        String endDate = keyScan.nextLine();

        System.out.println("-----------------------------");
        System.out.print("팀명: ");
        System.out.println(name);
        System.out.println("설명: ");
        System.out.println(description);
        System.out.print("최대인원: ");
        System.out.println(maxQty);
        System.out.print("일자: ");
        System.out.print(startDate);
        System.out.print(" ~ ");
        System.out.println(endDate);
    }
}
*/