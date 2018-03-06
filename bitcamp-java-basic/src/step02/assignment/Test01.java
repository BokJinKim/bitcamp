/*
# 과제(2018-03-05)
사용자로부터 이름, 국어, 영어, 수학 데이터를 입력
받고 합계와 평균을 출력하라
## 실행 결과
'''
>java -classpath bin step02.assignment.Test01
이름? 홍길동
국어? 100
영어? 90
수학? 80
--------
홍길동 100 90 80 270 90.0

'''
*/
package step02.assignment;
public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);
        String name;
        int lan;
        int eng;
        int math;
        int sum;
        float aver;

        System.out.print("이름 : ");
        name = keyScan.nextLine();
        System.out.print("국어 : ");
        lan = keyScan.nextInt();
        System.out.print("영어 : ");
        eng = keyScan.nextInt();
        System.out.print("수학 : ");
        math = keyScan.nextInt();

        System.out.println("-------------");
        sum = lan + eng + math;
        aver = sum / 3f ;

        System.out.printf("%s %d %d %d %d %.1f", name, lan, eng, math, sum, aver);
        

    }
}

// 키보드 정보를 가져온다.


// 키보드에서 값을 꺼내주는 도구를 연결한다.


// print()는 문자열을 출력한 후 줄 바꿈을 하지 않는다.

/*
public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("이름? ");
        String name = keyScan.nextLine();

        System.out.print("국어? ");
        int kor = keyScan.nextInt();

        System.out.print("영어? ");
        // 이전에 국어 점수를 입력받을 때 들어온 줄바꿈 코드는 
        // nextInt() 메서드에서 버린다.
        int eng = keyScan.nextInt();

        System.out.print("수학? ");
        int math = keyScan.nextInt();

        int sum = kor + eng + math;
        float average = sum / 3;

        System.out.println("------------------------------");
        System.out.print(name);
        System.out.print(" ");
        System.out.print(kor);
        System.out.print(" ");
        System.out.print(eng);
        System.out.print(" ");
        System.out.print(math);
        System.out.print(" ");
        System.out.print(sum);
        System.out.print(" ");
        System.out.print(average);
        System.out.println();
    }
}
*/