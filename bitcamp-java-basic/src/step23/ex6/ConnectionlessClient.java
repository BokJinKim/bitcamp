// 응용 - 에코 클라이언트 만들기
package step23.ex6;

import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionlessClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        
        String receiver = args[0];
        int port = 8888;
        
        byte[] bytes = args[1].getBytes("UTF-8");
        
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                InetAddress.getByName(receiver), port);
        
        socket.send(packet);
        System.out.println("데이터 전송 완료");
        
        socket.close();
    }
}





