package step24.ex4;

public class Exam04 {

    public static void main(String[] args) throws Exception {
        System.out.println("스레드 실행 전");
         class MyThread extends Thread {
             public MyThread(String name) {
                 super(name);
         }
            public void run() {
                for (int i = 0; i < 1000; i++)
                    System.out.printf("%s %d\n", this.getName(), i);
            }
         }
         
         MyThread t1 = new MyThread("홍길동===>");
         MyThread t2 = new MyThread("오호라===>");
         MyThread t3 = new MyThread("우헤헤##");
         t1.start();
         t2.start();
         t3.start();
         for (int i = 0; i < 1000; i++)
             System.out.printf("main 스레드: %d\n", i);
    }
}
