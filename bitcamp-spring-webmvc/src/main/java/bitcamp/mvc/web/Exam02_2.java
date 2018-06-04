package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.dao.BoardDao;

@Controller
@RequestMapping("/exam02_2")
public class Exam02_2 {
    
    BoardDao boardDao;
    
    // ServletContext를 주입 받을 때도 인스턴스 변수로 주입받는다.
    ServletContext servletContext;
    
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Autowired
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @RequestMapping("m1")
    @ResponseBody
    public String test1() {
        return "Exam02_2.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody 
    public String m2() {
        return "Exam02_2.m2()";
    }

}
