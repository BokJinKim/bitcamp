// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/add")
public class TaskAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        // 스프링 IoC 컨테이너에서 서블릿 객체를 관리하는 것이 아니기 때문에
        // 스프링 IoC 컨테이너에 들어 있는 DAO 객체를 자동으로 주입 받을 수 없다.
        // 서블릿을 생성할 때 스프링 IoC 컨테이너에서 직접 DAO를 꺼내와야 한다.
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        memberDao = InitServlet.getApplicationContext().getBean(MemberDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Task task = new Task();
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startDate")));
        task.setEndDate(Date.valueOf(request.getParameter("endDate")));
        task.setTeam(new Team().setName(request.getParameter("teamName")));
        task.setWorker(new Member().setId(request.getParameter("memberId")));
        
        try {
            Team team = teamDao.selectOne(task.getTeam().getName());
            if (team == null) {
                out.printf("'%s' 팀은 존재하지 않습니다.\n", task.getTeam().getName());
                return;
            }
            
            Member member = memberDao.selectOne(task.getWorker().getId());
            if (member == null) {
                out.printf("'%s' 회원은 존재하지 않습니다.\n", task.getWorker().getId());
                return;
            }
            
            taskDao.insert(task);
            out.println("등록 성공!");
        } catch (Exception e) {
            out.println("등록 실패!");
            e.printStackTrace(out);
        }
    }

}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
