// @RequestMapping - HTTP 요청에서 Content-Type 헤더 다루기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
@RequestMapping("/exam06_4") 
public class Exam06_4 {
    
    
    @GetMapping(value="m1")  
    public String m1(Model model) {
        model.addAttribute("name","홍길동");
        model.addAttribute("age",20);
        
        return "exam06_4";
    }
    
    @GetMapping(value="m2")  
    public void m2(Model model) {
        model.addAttribute("name","홍길동");
        model.addAttribute("age",20);
        
    }
}







