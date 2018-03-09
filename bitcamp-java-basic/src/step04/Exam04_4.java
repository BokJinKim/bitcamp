// 비트 이동 연산자 : 응용 I
package step04;

public class Exam04_4 {
    public static void main(String[] args) {
        int i =  0x27_a1_30_ff;
        int a, b, c, d;
        System.out.println(Integer.toHexString(i));
        
        a = i >> 24;
        b = (i >> 16) & 0xff;
        c = (i >> 8) & 0xff;
        d = i & 0xff;

        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));
        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.toHexString(d));
    }
}
