// 오버로딩 - 응용
package step11.ex10;

public class Exam03 {
    public static void main(String[] args) {
        // 다양한 파라미터 값을 받는 println()
        System.out.println(100);
        System.out.println(true);
        System.out.println("hello");
        
        // 외부에서 값을 받아 Integer 객체를 생성하는 메서드들
        Integer obj1 = Integer.valueOf(100);
        Integer obj2 = Integer.valueOf("100");
        Integer obj3 = Integer.valueOf("64", 16);
        
        System.out.printf("%d, %d, %d\n", obj1, obj2, obj3);
        
        
    }
}

// 오버로딩(overloading)
// => 파라미터의 형식은 다르지만 같은 기능을 수행하는 메소드에 대해
//    같은 이름을 부여함으로써 프로그래밍의 일관성을 제공하기 위한 문법이다.
