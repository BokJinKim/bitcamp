// 요청 핸들러의 파라미터 - 클라이언트가 보낸 데이터를 객체로 받기
package bitcamp.mvc.web;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_5") 
public class Exam05_5 {
    
    // 프론트 컨트롤러로부터 클라이언트가 보낸 값들을 객체에 담아서 받을 수 있다.
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1():%s,%s,%s", title, content, createdDate);
    }
    /*
    @InitBinder
    public void 오호라(WebDataBinder binder) {
        
        System.out.println("exam05_5오호라");
        binder.registerCustomEditor(
                java.sql.Date.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(Date.valueOf(text));
                    }
                });
        
    }
    */
}







