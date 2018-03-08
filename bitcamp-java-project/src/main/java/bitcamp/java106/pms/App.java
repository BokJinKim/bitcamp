package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;
public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        Team[] teams = new Team[5];
        int count = 0;
        for (int i = 0; i < teams.length; i++) {
            count ++;
            teams[i] = new Team(); 

            System.out.print("팀명? ");
            teams[i].name = keyScan.nextLine();
            System.out.print("설명? ");
            teams[i].description = keyScan.nextLine();
            System.out.print("최대인원? ");
            teams[i].maxQty = keyScan.nextInt();
            keyScan.nextLine();
            System.out.print("시작일? ");
            teams[i].startDate = keyScan.nextLine();
            System.out.print("종료일 ");
            teams[i].endDate = keyScan.nextLine();

            if (count == teams.length) {break;}
            System.out.print("계속 입력하시겠습니까?(Y/n)");
            String str = keyScan.nextLine();
            if (!(str.toLowerCase().equals("y")||str.toLowerCase().equals("n"))) {
                System.out.print("잘못 입력했습니다.(Y/n)");
                String str1 = keyScan.nextLine();
                if (!(str1.toLowerCase().equals("y")||str1.toLowerCase().equals("n"))) {
                    System.out.print("종료 합니다."); break;
                }
            }
            if (str.toLowerCase().equals("n")) {
                break;}
        }
        System.out.println("------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%s, %d, %s ~ %s\n", 
                teams[i].name, teams[i].maxQty, 
                teams[i].startDate, teams[i].endDate);
        }
    }
}