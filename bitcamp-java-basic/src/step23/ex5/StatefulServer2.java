// Stateless와 Stateful 의 비교 
package step23.ex5;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateful 방식의 특징
// => 클라이언트와 계속 연결을 유지하기 때문에 작업 결과를 계속 서버에 유지할 수 있다.
// 
public class StatefulServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        // 합계를 계산하는 서버를 만들어보자!
        ServerSocket ss = new ServerSocket(8888);
        
        while (true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 연결 승인 및 작업 처리 중...");
            
            MyThread requestHandler = new MyThread(socket);
            
            requestHandler.start();
        }
    }
    
    static class MyThread extends Thread {
        Socket socket;
        public MyThread(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try (
                Socket socket2 = socket;
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
                ) {
                
                int sum = 0;
                
                while (true) {
                    String str = in.nextLine();
                    if (str.equals(""))
                        break;
                    sum += Integer.parseInt(str);
                }
                
                out.println("결과 = " + sum);
                
            } catch (Exception e) {
                System.out.println("클라이언트 요청 처리중 오류 발생");
            }
        }
    
    static void processRequest(Socket socket) throws Exception {
        
        }
    }
}






