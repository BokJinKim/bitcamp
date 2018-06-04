package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.dao.BoardDao;

@Controller
@RequestMapping("/exam02_3")
public class Exam02_3 {
    
    @Autowired BoardDao boardDao;
    
    @Autowired ServletContext servletContext;

    @RequestMapping("m1")
    @ResponseBody
    public String test1() {
        return "Exam02_3.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody 
    public String m2() {
        return "Exam02_3.m2()";
    }

}
