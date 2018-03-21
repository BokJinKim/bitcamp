// 인스턴스 메서드와 클래스 메서드의 활용 - CalenDar 클래스
package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;


public class Test01 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        
        System.out.print("년, 월, 일?");
        int year = keyScan.nextInt();
        int month = keyScan.nextInt();
        int day = keyScan.nextInt();

        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        //c.set(Calendar.YEAR, year);
        //c.set(Calendar.MONTH, month - 1);
        //c.set(Calendar.DATE, day);
        //c.set(year, month -1, day, 0, 0, 0);
        String[] weeks = {"", "일", "월", "화", "수", "목", "금", "토"};

        System.out.printf("요일: %s요일\n", weeks[c.get(Calendar.DAY_OF_WEEK)]);
        System.out.printf("주차: %d주차\n", c.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("일차: %d일차\n", c.get(Calendar.DAY_OF_YEAR));
    }
}
