package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class Exam05_5_GlobalControllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        System.out.println("Exam05_5_GlobalControllerAdvice.initBinder()");
        
        binder.registerCustomEditor(
                java.sql.Date.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(Date.valueOf(text));
                    }
                });
        
    }
}
