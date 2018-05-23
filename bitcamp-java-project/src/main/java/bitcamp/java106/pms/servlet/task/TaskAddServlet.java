// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/task/add")
public class TaskAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        teamDao = iocContainer.getBean(TeamDao.class);
        taskDao = iocContainer.getBean(TaskDao.class);
        teamMemberDao = iocContainer.getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String teamName = request.getParameter("teamName");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                throw new Exception(teamName + " 팀은 존재하지 않습니다.");
            }
            List<Member> members = teamMemberDao.selectListWithEmail(teamName);
            out.println("<form action='add' method='post'>");
            out.printf("<input type='hidden' name='teamName' value='%s'>\n", teamName);
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>작업명</th><td><input type='text' name='title'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>시작일</th><td><input type='date' name='startDate'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>종료일</th><td><input type='date' name='endDate'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("   <th>작업자</th>");
            out.println("   <td>");
            out.println("       <select name='memberId'>");
            out.println("           <option value=''>--선택 안함--</option>");
            
            for (Member member : members ) {
                out.printf("           <option>%s</option>\n", member.getId());
            }
            out.println("       </select>");
            out.println("   </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<button>등록</button>");
            out.println("</form>");
            
        } catch (Exception e) {
         // 예외가 발생하면 ErrorServlet으로 예외 내용을 출력하도록 실행을 위임한다.
            // 1) 실행을 위임할 객체를 준비한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            
            // 2) 다른 서블릿에게 실행을 위임하기 전에 그 서블릿에 전달할 데이터가 있다면,
            //    ServletRequest 보관소에 담아라.
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 등록 실패!");
            
            // 3) 다른 서블릿으로 실행을 위임한다.
            요청배달자.forward(request, response);
        }
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String teamName = request.getParameter("teamName");
        try {
            Task task = new Task();
            task.setTitle(request.getParameter("title"));
            task.setStartDate(Date.valueOf(request.getParameter("startDate")));
            task.setEndDate(Date.valueOf(request.getParameter("endDate")));
            task.setTeam(new Team().setName(teamName));
            task.setWorker(new Member().setId(request.getParameter("memberId")));
            
            Team team = teamDao.selectOne(task.getTeam().getName());
            if (team == null) {
                throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
            }
            
            if (task.getWorker().getId().length() > 0 &&
                !teamMemberDao.isExist(
                    task.getTeam().getName(), task.getWorker().getId())) {
                throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
            } 
            taskDao.insert(task);
            response.sendRedirect("list?teamName="+ URLEncoder.encode(teamName, "UTF-8"));
            
        } catch (Exception e) {
            // 예외가 발생하면 ErrorServlet으로 예외 내용을 출력하도록 실행을 위임한다.
            // 1) 실행을 위임할 객체를 준비한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            
            // 2) 다른 서블릿에게 실행을 위임하기 전에 그 서블릿에 전달할 데이터가 있다면,
            //    ServletRequest 보관소에 담아라.
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 등록 실패!");
            
            // 3) 다른 서블릿으로 실행을 위임한다.
            요청배달자.forward(request, response);
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
