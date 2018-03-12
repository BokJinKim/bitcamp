package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        Team[] teams= new Team[3]; // teams에 레퍼런스 주소값 3개 생김
        Member[] member = new Member[5];
        int count1 = 0;
        int count2 = 0;
        while(true) {
            System.out.printf("명령> ");
            String order = keyScan.nextLine();
            if (order.toLowerCase().equals("quit")) {
              System.out.println("안녕히가세요!"); break;
            }
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
                teams[count1] = new Team();    
                System.out.print("팀명? ");
                teams[count1].name = keyScan.nextLine();
                System.out.print("설명? ");
                teams[count1].description = keyScan.nextLine();
                System.out.print("최대인원? ");
                teams[count1].maxQty = keyScan.nextInt();
                keyScan.nextLine();
                System.out.print("시작일? ");
                teams[count1].startDate = keyScan.nextLine();
                System.out.print("종료일 ");
                teams[count1].endDate = keyScan.nextLine();
                count1 ++;
            }
            else if (order.toLowerCase().equals("member/add")) {
                member[count2] = new Member();    
                System.out.print("아이디? ");
                member[count2].id = keyScan.nextLine();
                System.out.print("이메일? ");
                member[count2].email = keyScan.nextLine();
                System.out.print("암호? ");
                member[count2].password = keyScan.nextInt();
                keyScan.nextLine();
                count2 ++;
            }
            else if (order.toLowerCase().equals("team/list")) { 
                for (int i = 0; i < count1; i++) {
                System.out.printf("%s, %d, %s ~ %s\n", teams[i].name, 
                    teams[i].maxQty, teams[i].startDate, teams[i].endDate);
                }
            }
            else if (order.toLowerCase().equals("team/view 비트오케이")) {
                System.out.println("해당 이름의 팀이 없습니다.");
            }
            else if (order.toLowerCase().equals("team/view")) {
                System.out.println("해당 이름의 팀이 없습니다.");
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
            else if ((order.startsWith("team/view"))) {
                String tv = order.substring(10); 
                for(int i = 0; i < count1; i++) {
                    if(tv.equals(teams[i].name)) { 
                    System.out.printf("팀명: %s \n설명: %s \n최대인원: %d \n기간 %s ~ %s\n", 
                    teams[i].name, teams[i].description, teams[i].maxQty, teams[i].startDate, teams[i].endDate);
                    break;
                    } 
                }
            }
            else if ((order.startsWith("member/view"))) {
                String mv = order.substring(12); 
                for(int i = 0; i < count2; i++) {
                    if(mv.equals(member[i].id)) { 
                    System.out.printf("아이디: %s \n이메일: %s \n암호: %d \n", 
                    member[i].id, member[i].email, member[i].password);
                    break;
                    } 
                }
            }
        }
    }
}
