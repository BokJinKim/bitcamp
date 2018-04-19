package step24.ex4;

public class Exam02 {

    public static void main(String[] args) throws Exception {
        System.out.println("스레드 실행 전");
        Thread t = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        };
        t.start();
        t.join();
        
        System.out.println("스레드 실행 후");
        
        t.start();
    }

}
