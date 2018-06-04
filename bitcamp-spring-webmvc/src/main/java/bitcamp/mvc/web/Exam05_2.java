// @RequestMapping - HTTP 요청에서 Content-Type 헤더 다루기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_2") 
public class Exam05_2 {
    
    
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        return String.format("m1(): name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m2")  
    @ResponseBody  
    public String m2(
            @RequestParam String name,
            @RequestParam int age) {
        return String.format("m2(): name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m3")  
    @ResponseBody  
    public String m3(
            String name,
            int age) {
        return String.format("m3(): name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m4")  
    @ResponseBody  
    public String m4(
            @RequestParam(required=false) String name,
            @RequestParam(required=false) int age) {
        return String.format("m4(): name=%s, age=%d", name, age);
    }
    
    @GetMapping(value="m5")  
    @ResponseBody  
    public String m5(
            String name,
            @RequestParam(defaultValue="20") int age) {
        return String.format("m5(): name=%s, age=%d", name, age);
    }
}







