// 팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamMemberController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // keyScan 변수에 저장하라!
    Scanner keyScan;

    TeamDao teamDao = new TeamDao();
    Team[] teams = new Team[1000];
    int teamIndex = 0;
    MemberDao memberDao = new MemberDao();
    
    public TeamMemberController(Scanner scanner) {
        this.keyScan = scanner;
    }
    

    public void service(String menu, String option) {
        if (menu.equals("team/add")) {
            this.onTeamMemberAdd(option);
        } else if (menu.equals("team/list")) {
            this.onTeamMemberList();
        } else if (menu.equals("team/delete")) {
            this.onTeamMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    int getTeamIndex(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(this.teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    void onTeamMemberAdd(String name) {
        System.out.println("[팀 회원 정보 입력]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        Team team = teamDao.get(name);
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) 
                System.out.printf("%s 팀은 존재하지 않습니다\n", name); continue;
                if (name.equals(this.teams[i].name.toLowerCase())) {
                    System.out.print("추가할 멤버의 아이디는? ");
                String id1 = keyScan.nextLine();
                Member member = memberDao.get(id1);
                if (member == null)
                    System.out.printf("%s 회원은 없습니다.", member.id);
                
        }
    }        
    
    
    void onTeamMemberList() {
        System.out.println("[팀 목록]");
        Team[] list = teamDao.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n", 
                    list[i].name, list[i].maxQty, 
                    list[i].startDate, list[i].endDate);
        }
    }

    void onTeamMemberDelete(String name) {
        System.out.println("[팀 회원 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(name);

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                teamDao.delete(team.name);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}

//ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.