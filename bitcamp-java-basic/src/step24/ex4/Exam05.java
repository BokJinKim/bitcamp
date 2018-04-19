package step24.ex4;

public class Exam05 {

    public static void main(String[] args) throws Exception {
         class MyThread extends Thread {
             public MyThread(String name) {
                 super(name);
         }
            public void run() {
                for (int i = 0; i < 1000; i++)
                    System.out.printf("%s %d\n", this.getName(), i);
            }
         }
         
         MyThread t1 = new MyThread("t1");
         
         System.out.printf("우선순위범위: %s ~ %s\n",
                 Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);
         
         System.out.printf("우선순위 기본값: %d\n",
                 Thread.NORM_PRIORITY);
         
         System.out.printf("main 스레드 우선 순위: %d\n",
                 Thread.currentThread().getPriority());
         
         System.out.printf("%s 스레드 우선 순위: %d\n",
                 t1.getName(), t1.getPriority());
    }
}
