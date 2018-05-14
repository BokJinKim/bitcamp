// 요청 파라미터의 값이 한글일 경우 깨지는 현상 해결
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam04")
public class Exam04 extends GenericServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // tomcat7 이하 버전:
        // => GET 요청으로 한글 문자열을 파라미터로 보낼 때
        //    서버에서 꺼내면 한글이 깨진다.
        //    예) http://localhost:8888/test01/step03/exam04?name=홍길동&age=20
        // => 이유?
        //    웹브라우저: 
        //      1) URL에 입력한 값(UTF-8
        //      2) URL 인코딩: "AB%EA%B0%80%EA%B0%81" (4142)
        
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("이름=%s\n", name);
        out.printf("나이=%d\n", age);
    }
}
