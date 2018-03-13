package step05.assignment;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변의 길이? ");
        int len = keyScan.nextInt();

        int starLen = 1;
        while (starLen <= len) {
            int spaceLen = 1;
            int spaceCnt = (len - starLen) / 2;
            while (spaceLen <= spaceCnt) {
                System.out.print(" ");
                spaceLen++;
            } int starCnt = 1;
            while (starCnt <= starLen) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            starLen += 2;
        }

        
    }
}