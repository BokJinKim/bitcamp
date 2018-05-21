// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        int no = Integer.parseInt(request.getParameter("no"));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>게시물 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시물 보기</h1>");
        out.println("<form action='update' method='post'>");
        
        try {
            Board board = boardDao.selectOne(no);
            if (board == null) {
                throw new Exception("유효하지 않은 게시물 번호입니다.");
            }
            out.println("<table border='1'>");
            out.println("<tr><th>번호</th><td>");
            out.printf("    <input type='text' name='no' value='%d' readonly></td></tr>\n", 
                    board.getNo());
            out.println("<tr><th>제목</th>");
            out.printf("    <td><input type='text' name='title' value='%s'></td></tr>\n",
                    board.getTitle());
            out.println("<tr><th>내용</th>");
            out.printf("    <td><textarea name='content' rows='10' cols='60'>%s</textarea></td></tr>\n",
                    board.getContent());
            out.printf("<tr><th>등록일</th><td>%s</td></tr>\n", 
                    board.getCreatedDate());
            out.println("</table>");
            
        } catch (Exception e) {
         // 예외가 발생하면 ErrorServlet으로 예외 내용을 출력하도록 실행을 위임한다.
            // 1) 실행을 위임할 객체를 준비한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            
            // 2) 다른 서블릿에게 실행을 위임하기 전에 그 서블릿에 전달할 데이터가 있다면,
            //    ServletRequest 보관소에 담아라.
            request.setAttribute("error", e);
            request.setAttribute("title", "게시판 뷰 실패!");
            
            // 3) 다른 서블릿으로 실행을 위임한다.
            요청배달자.forward(request, response);
        }
        out.println("<p>");
        out.println("<a href='list'>목록</a>");
        out.println("<button>변경</button>");
        out.printf("<a href='delete?no=%d'>삭제</a>\n", no);
        out.println("</p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 view() 메서드를 추출하여 클래스로 정의.
