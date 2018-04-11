// Byte Stream - 바이트 단위로 출력하기 
package step22.ex5;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        
        byte[] buf = new byte[8196]; // 보통 8KB 정도 메모리를 준비한다.
        int count = 0;
        long startTime = System.currentTimeMillis();
        while ((count = in.read(buf)) != -1);
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);

    }

}
