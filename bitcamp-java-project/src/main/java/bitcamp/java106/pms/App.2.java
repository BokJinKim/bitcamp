package bitcamp.java106.pms;


public class App{
    
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(System.in);
        
        
        // Score 메모리(인스턴스)의 주소를 저장할 변수: 레퍼런스 준비
        bitcamp.java106.pms.Score[] a1  = new bitcamp.java106.pms.Score[5];
        int count = 0;

// Score 메모리(인스턴스)의 주소를 저장할 변수: 레퍼런스 준비
      // 입력 값을 저장할 Score 메모리를 준비한다.
        for (int i = 0; i < a1.length; i++) {
            a1[i] = new bitcamp.java106.pms.Score();
        System.out.print("팀명 : ");
        a1[i].teamName = keyScan.nextLine();
        System.out.print("설명 : ");
        a1[i].description = keyScan.nextLine();
        System.out.print("최대인원 : ");
        a1[i].maxQty = keyScan.nextInt();
        keyScan.nextLine();
        System.out.print("시작일 : ");
        a1[i].startDate = keyScan.nextLine();
        System.out.print("종료일 : ");
        a1[i].endDate = keyScan.nextLine();
      
        System.out.print("계속 입력하시겠습니다?(Y/n) ");
        String ys = keyScan.nextLine();
        if (ys.equalsIgnoreCase("n")) 
        count = i + 1 ;
        break;
       
       
        
                            
                
        }     
        System.out.println("---------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n", a1[i].teamName,
            a1[i].maxQty, a1[i].startDate, a1[i].endDate); 
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
        String teamName = keyScan.nextLine();

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
        System.out.println(teamName);
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