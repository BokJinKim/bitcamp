package step05.assignment;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = keyScan.nextInt();
        int count = 1;
       
        while (count <= len) {
            int starLen = 1;
            while (starLen <= count ) {
            System.out.print("*");
            starLen++;
            }
            System.out.println();
            count ++;

        }
    }
}
        