// @RequestMapping - HTTP 요청에서 Content-Type 헤더 다루기
package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_1") 
public class Exam05_1 {
    
    
    // 만약 클라이언트가 보낸 데이터가 "변수=값&변수=값&변수=값" 형태로 돼 있다면?
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(ServletRequest request,
            ServletResponse response) {
        return "Exam05_1.m1()";
    }
    
    @GetMapping(value="m2")  
    @ResponseBody  
    public String m2(HttpServletRequest request,
            HttpServletResponse response) {
        return "Exam05_1.m2()";
    }
    
    @GetMapping(value="m3")  
    @ResponseBody  
    public String m3(HttpSession request) {
        return "Exam05_1.m3()";
    }
    /*
    @GetMapping(value="m4")  
    @ResponseBody  
    public String m4(ServletContext request) {
        return "Exam05_1.m4()";
    }
    */
    
}







