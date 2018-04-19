package step24.ex4;

public class Exam06 {

    public static void main(String[] args) throws Exception {
         class MyThread extends Thread {
             public MyThread(String name) {
                 super(name);
         }
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 100000000; i++)
                    Math.asin(38.567);
                long endTime = System.currentTimeMillis();
                System.out.printf("MyThread = %d\n", endTime - startTime);
            }
         }
         Thread.currentThread().setPriority(1);
         MyThread t1 = new MyThread("t1");
         t1.setPriority(10);
         
         System.out.printf("우선순위범위: %s ~ %s\n",
                 Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);
         
         System.out.printf("우선순위 기본값: %d\n",
                 Thread.NORM_PRIORITY);
         
         System.out.printf("main 스레드 우선 순위: %d\n",
                 Thread.currentThread().getPriority());
         
         System.out.printf("%s 스레드 우선 순위: %d\n",
                 t1.getName(), t1.getPriority());
         t1.start();
         
         long startTime = System.currentTimeMillis();
         for (int i = 0; i < 100000; i++)
             Math.asin(38.567);
         long endTime = System.currentTimeMillis();
         System.out.printf("main = %d\n", endTime - startTime);
    }
}
