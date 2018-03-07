// 레퍼런스 배열 - 반복문 결합
package step03;

public class Exam02_3 {
    public static void main(String[] args) {
        // 여러개의 인스턴스 주소를 저장하려면?
        
        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        // 레퍼런스 배열 준비
        Score[] arr = new Score[3];

        // 반복문을 이용하여 레퍼런스 배열에 인스턴스 주소를 저장한다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Score();
        }
        
        // 값을 저장할 때는 일일이 값을 지정해야 한다.
        arr[0].name = "홍길동";
        arr[1].name = "임꺽정";
        arr[2].name = "유관순";

        // 레퍼런스를 통해 인스턴스의 각 항목 값을 꺼낸다.
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("이름: %s\n", arr[i].name);
        }
    }
}

// 결론!
// - 배열은 반복문과 함께 쓸 때 특히 유용한다.