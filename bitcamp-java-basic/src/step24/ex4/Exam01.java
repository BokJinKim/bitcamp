package step24.ex4;

public class Exam01 {

    public static void main(String[] args) {
        System.out.println("스레드 실행 전");
        new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }.start();
        System.out.println("스레드 실행 후");
    }

}
