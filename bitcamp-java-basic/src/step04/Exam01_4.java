// 살술 연산자 : 연산의 결과 타입
package step04;

public class Exam01_4 {
    public static void main(String[] args) {
        int i = 5;
        int j = 2;
        float r = (float)i / j;
        // int는 정수라서 float 타입으로 변환 필요
        System.out.println(r);
    }
}