// Java I/O API 사용하기 - Serialize의 대상 클래스가 변경된 경우
package step22.ex9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam04_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_5.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);
        
        Score s = (Score) in.readObject();
        
        
        in.close();
        
        System.out.println(s);
        s.compute();
        System.out.println(s);
    }

}










