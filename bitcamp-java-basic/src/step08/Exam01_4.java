// 클래스 변수와 인스턴스 변수 생성 시점
package step08;

public class Exam01_4 {
    // 지금 당장 A클래스 앞에 붙은 static은 고민하지 말라
    static class A {
        static int v1;
        int v2;
    }
    public static void main(String[] args) {
        
        A.v1 = 100;
        // v2 인스턴스 변수이기 때문에 new 명령을 사용하여 생성해야 한다.
        //A.v2 = 200; // 컴파일 오류
        
        A p = new A(); // 이제 v2 변수는 Heap에 생성되었다.
        // A클래스의 인스턴스를 만들 때
        // static 이 안붙은 변수가 그 대상이다.
        
        // v2 인스턴스 변수는 인스턴스 주소를 통해 사용해야 한다.
        // 클래스이름으로 사용할 수 없다.
        //A.v2 = 200; // 컴파일 오류!
       
        p.v2 = 200;
        
        // 인스턴스 변수는 인스턴스를 만들 때 마다 생성된다.
        A p2 = new A(); // 새 v2 변수가 생성된다.
        p2.v2 = 300;
        
        System.out.printf("A.v1=%d, p.v2=%d, p2.v2=%d\n",
                A.v1, p.v2, p2.v2);
    }
}

// 클래스 변수는 클래스가 로딩될 때 딱 한 번 자동으로 생성되기 떄문에
// 각각 구분되는 개별 데이터를 저장할 수 없다.
// 왜? 변수가 한 개이다.