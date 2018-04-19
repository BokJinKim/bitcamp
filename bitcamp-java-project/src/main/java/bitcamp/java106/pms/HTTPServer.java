// HTTP 프로토콜에 따라 요청을 처리할 서버
package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    int port;
    ApplicationContainer applicationContainer;
    
    public HTTPServer(int port, ApplicationContainer applicationContainer) {
        this.port = port;
        this.applicationContainer = applicationContainer;
    }
    public void execute() throws Exception {
     // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("서버 실행 했음!");
        
        while (true) {
            Socket socket = serverSocket.accept();
            
            new RequestProcessorThread(socket).start();;
        }
    }
    
    class RequestProcessorThread extends Thread {
        Socket socket;
        
        public RequestProcessorThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            PrintWriter out = null;
            Scanner in = null;
            
            try {
                out = new PrintWriter(socket.getOutputStream());
                in = new Scanner(socket.getInputStream());
                
                boolean firstLine = true;
                String requestURI = null;
                
                while (true) {
                    String line = in.nextLine();
                    if (line.equals(""))
                        break;
                    
                    if (!firstLine)
                        continue;
                    
                    requestURI = line.split(" ")[1];
                    firstLine = false;
                }
                
                String result = applicationContainer.execute(requestURI);
                
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain;charset=UTF-8");
                out.println();
                out.println(result);
                
                
            } catch (Exception e) {
                out.println("서버 오류!");
                e.printStackTrace(out);
                out.println();
            } finally {
                out.close();
                in.close();
                try {socket.close();} catch (Exception e) {}
            }
        }
    }
}
