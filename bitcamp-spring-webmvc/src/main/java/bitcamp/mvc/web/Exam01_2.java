package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class Exam01_2 {
    // 한 클래스에 여러 개의 요청 핸들러를 정의할 때는
    // 각각의 RequestMapping 애노테이션에 URL을 저장한다.
    
    @RequestMapping("/exam01_2/m1")
    @ResponseBody
    public String test1() {
        return "Exam01_2.m1()";
    }
    
    @RequestMapping("/exam01_2/m2")
    @ResponseBody 
    public String m2() {
        return "Exam01_2.m2()";
    }

}
