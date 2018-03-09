package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        Team[] teams = new Team[5];
        Member[] member = new Member[5];
        int count1 = 0;
        int count2 = 0;
        while(true) {
            System.out.printf("명령> ");
            String order = keyScan.nextLine();
        if (order.toLowerCase().equals("quit")){
            System.out.println("안녕히가세요!");break;}
        else if (order.toLowerCase().equals("help")) {
            System.out.println("팀 등록 명령 : team/add");
            System.out.println("팀 조회 명령 : team/list");
            System.out.println("팀 상세조회 명령 : team/view 팀명");
            System.out.println("회원 등록 명령 : member/add");
            System.out.println("회원 조회 명령 : member/view");
            System.out.println("회원 상세조회 명령 : member/view 아이디");
            System.out.println("종료 : quit");
        }
        else if (order.toLowerCase().equals("team/add")) {
            for (int i = 0; i < teams.length; i++) {
            count1 ++;
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
            break;
            }
            for (int i = 0; i < count1; i++) {
                System.out.printf("%s", teams[i].name);
            }
        }
        else if (order.toLowerCase().equals("member/add")) {
            for (int i = 0; i < member.length; i++) {
            count2 ++;    
            member[i] = new Member();    
            System.out.print("아이디? ");
            member[i].id = keyScan.nextLine();
            System.out.print("이메일? ");
            member[i].email = keyScan.nextLine();
            System.out.print("암호? ");
            member[i].password = keyScan.nextInt();
            keyScan.nextLine();
            }
        }
        else if (order.toLowerCase().equals("team/list")) {
            for (int i = 0; i < count1; i++) {
            System.out.printf("%s, %d, %s ~ %s\n", teams[i].name, 
                teams[i].maxQty, teams[i].startDate, teams[i].endDate);
            }
        }
        else if (order.toLowerCase().equals("member/view")) {
            System.out.println("아이디를 입력하시기 바랍니다.");
        }
        else if (order.toLowerCase().equals("member/list")) {
            for (int i = 0; i < count2; i++) {
            System.out.printf("%s, %s, %d \n", member[i].id,
                member[i].email, member[i].password);
            }
        }
        else if (order.toLowerCase().equals("member/viewokok")) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        }
       
        else if (order.toLowerCase().equals("memeber/list")) {
            System.out.println("명령어가 올바르지 않습니다.");
        }
        
    }
}
}
