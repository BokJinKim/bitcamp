package step24.ex4;

public class Exam03 {

    public static void main(String[] args) throws Exception {
        System.out.println("스레드 실행 전");
         new Thread() {
            public void run() {
                    System.out.println("Hello!");
            }
        }.start();
        Thread.currentThread().sleep(3000);
        
        System.out.println("스레드 실행 후");
    }
}
