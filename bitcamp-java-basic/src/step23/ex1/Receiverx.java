package step23.ex1;

import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver4 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);
        
        
        Socket socket = serverSocket.accept();
        
        socket.getOutputStream();
        socket.getInputStream();
        
        FileOutputStream out = new FileOutputStream("temp/ecc.exe");
        Scanner in = new Scanner(socket.getInputStream());
        
        while (true) {
            String str = in.nextLine();
            if (str.equals("quit"))
                break;
            
            int a = Integer.parseInt(str);
            out.write(a);
            System.out.println(a);
        }
        
        in.close();
        out.close();
        socket.close();
        keyScan.close();
    }
}