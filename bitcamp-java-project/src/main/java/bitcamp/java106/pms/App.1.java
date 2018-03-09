package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        Team[] teams= new Team[3];
        Member member = new Member();
        int count = 0;
        
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
            count ++;
            }
        }
        else if (order.toLowerCase().equals("member/add")) {
            member = new Member();    
            System.out.print("아이디? ");
            member.id = keyScan.nextLine();
            System.out.print("이메일? ");
            member.email = keyScan.nextLine();
            System.out.print("암호? ");
            member.password = keyScan.nextInt();
            keyScan.nextLine();
            }
        else if (order.toLowerCase().equals("team/list")) { 
            for (int i = 0; i < count; i++) {
            System.out.printf("%s, %d, %s ~ %s\n", teams[i].name, 
                teams[i].maxQty, teams[i].startDate, teams[i].endDate);
           }
        }
        else if (order.toLowerCase().equals("member/view")) {
            System.out.println("아이디를 입력하시기 바랍니다.");
        }
        else if (order.toLowerCase().equals("member/list")) {
            System.out.printf("%s, %s, %d \n", member.id,
                member.email, member.password);
        }
        else if (order.toLowerCase().equals("member/viewokok")) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        }
       
        else if (order.toLowerCase().equals("memeber/list")) {
            System.out.println("명령어가 올바르지 않습니다.");
        }
        else if ((order.startsWith("team/view"))) {
            String tv[] = order.substring(10); 
            (teams[i].name).equals(tv);
            System.out.printf("팀명: %s \n설명: %s \n최대인원: %d \n기간 %s ~ %s\n", teams[i].name, teams[i].description, teams[i].maxQty, teams[i].startDate, teams[i].endDate);
            
        }
        else if ((order.startsWith("member/view"))) {
            String mv = order.substring(10); 
            member.name.equals(mv);
            System.out.printf("아이디: %s \n이메일: %s \n암호: %d \n", member.id, member.email, member.password);

        } 
      
    }
}
}
