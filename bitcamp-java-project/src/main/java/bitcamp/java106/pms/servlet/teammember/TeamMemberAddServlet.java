// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/teammember/add")
public class TeamMemberAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        // 스프링 IoC 컨테이너에서 서블릿 객체를 관리하는 것이 아니기 때문에
        // 스프링 IoC 컨테이너에 들어 있는 DAO 객체를 자동으로 주입 받을 수 없다.
        // 서블릿을 생성할 때 스프링 IoC 컨테이너에서 직접 DAO를 꺼내와야 한다.
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        memberDao = InitServlet.getApplicationContext().getBean(MemberDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                out.printf("%s 팀은 존재하지 않습니다.\n", teamName);
                return;
            }
            Member member = memberDao.selectOne(memberId);
            if (member == null) {
                out.printf("%s 회원은 없습니다.\n", memberId);
                return;
            }
            if (teamMemberDao.isExist(teamName, memberId)) {
                out.println("이미 등록된 회원입니다.");
                return;
            }
            teamMemberDao.insert(teamName, memberId);
            out.println("팀에 회원을 추가하였습니다.");
            
        } catch (Exception e) {
            out.println("등록 실패!");
            e.printStackTrace(out);
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamMemberController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
//ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.